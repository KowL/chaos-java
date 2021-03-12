package org.chaos.concurrent.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-12 16:35
 * @Modified By:
 */
public class LockSupportDemo {

    public static class LockThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行 start");
            LockSupport.park(this);
            System.out.println(Thread.currentThread().getName() + "执行 end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockThread thread1 = new LockThread();
        thread1.start();
        Thread.sleep(100);
        // LockSupport.park()不会修改线程中断标志
        System.out.println(thread1.isInterrupted());
        // 设置线程中断标志会激活线程，不抛出异常
//        thread1.interrupt();
        LockSupport.unpark(thread1);
        System.out.println(thread1.isInterrupted());
    }
}
