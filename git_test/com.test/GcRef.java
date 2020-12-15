import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GcRef {

    public static void main(String[] args) throws IOException {

        // strong();

        // soft();

        weak();
    }

    private static void strong() throws IOException {
        // 强引用
        M m = new M();
        m = null;
        System.gc();
        System.in.read();
    }

    // -xmx20m  软引用 -- 空间不够会被回收   用于缓存
    private static void soft(){
        SoftReference<byte[]> s = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(s.get());
        System.gc();

        try {
            Thread.sleep(5000);
            System.out.println(s.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(s.get());
    }

    // 弱引用 gc 就会回收
    private static void weak() throws IOException {
        WeakReference<M> w = new WeakReference<>(new M());

        System.out.println(w.get());
        System.gc();
        System.out.println(w.get());

        System.in.read();
    }

    // 虚引用 -- 管理 堆外内存
    private static void phantom(){
        PhantomReference<M> p = new PhantomReference<>(new M(), new ReferenceQueue(){

        });
    }
}
