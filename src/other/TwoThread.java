package other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印奇偶数0~100
 *
 * @author qianshuailong
 * @date 2021/3/9
 */
public class TwoThread {

    private static int count = 0;

    private static Object object = new Object();

    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition CONDITION1 = LOCK.newCondition();
    private static final Condition CONDITION2 = LOCK.newCondition();

    public static void main(String[] args) {
        method2();
    }

    /**
     * 方法1：使用synchronized
     */
    public static void method1() {
        new Thread(() -> {
            while (count < 100) {
                synchronized (object) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (object) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "线程2").start();
    }

    /**
     * 方法2：使用ReentrantLock和Condition
     */
    public static void method2() {
        new Thread(() -> {
            while (count <= 100) {
                try {
                    LOCK.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    CONDITION1.await();
                    CONDITION2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            while (count <= 100) {
                try {
                    LOCK.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    CONDITION1.signal();
                    CONDITION2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }
            }
        }, "线程2").start();
    }

}
