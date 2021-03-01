package sjms.danli;

public class SingleDemo_01 {
    // volatile 可见行 & 有序行 防止指令重排序
    private static volatile SingleDemo_01 instance = null;

    private SingleDemo_01() {

    }

    static {
        instance = new SingleDemo_01();
    }

    public static SingleDemo_01 getInstance() {
        if (null == instance){
            synchronized (SingleDemo_01.class){
                if (null == instance){ // double check lock
                    synchronized (SingleDemo_01.class){
                        instance = new SingleDemo_01();
                    }
                }
            }
        }
        return instance;
    }
}
