package org.chaos.concurrent.thread;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-11 17:23
 * @Modified By:
 */
public class ThreadStateTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {});
        // 输出 NEW
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
