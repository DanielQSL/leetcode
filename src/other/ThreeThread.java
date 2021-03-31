package other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替顺序打印ABC
 * 参考：https://blog.csdn.net/hefenglian/article/details/82596072
 *
 * @author qianshuailong
 * @date 2021/4/1
 */
public class ThreeThread {

    private static volatile int count = 0;

    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0) {
                        a.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + "A");
                    count++;
                    b.signal();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1) {
                        b.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + "B");
                    count++;
                    c.signal();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程2").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2) {
                        c.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + "C");
                    count++;
                    a.signal();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程3").start();
    }
}
