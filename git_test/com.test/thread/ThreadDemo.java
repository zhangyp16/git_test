package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();
        printABC();
    }

    // 线程交替打印 A-B-C
    private static void printABC(){
        Lock lock = new ReentrantLock();
        Condition condition_1 = lock.newCondition();
        Condition condition_2 = lock.newCondition();
        Condition condition_3 = lock.newCondition();


        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    condition_2.signal();
                    condition_1.await();
                }
                condition_2.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    condition_3.signal();
                    condition_2.await();
                }
                condition_3.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("C");
                    condition_1.signal();
                    condition_3.await();
                }
                condition_1.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }).start();
    }

}
