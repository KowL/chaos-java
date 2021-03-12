package org.chaos.concurrent.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-12 15:40
 * @Modified By:
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            System.out.println("thread1 do");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            System.out.println("thread2 do");
            lock.unlock();
        }).start();

    }
}
