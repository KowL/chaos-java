package org.chaos.concurrent.thread;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-11 17:17
 * @Modified By:
 */
public class TheadDemo {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行 Thread");
        }
    }

    public static void main(String[] args) {
        // 继承Thread类创建线程
        new MyThread().start();

        // 实现Runnable接口创建线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行 Runnable");
        }).start();
    }
}
