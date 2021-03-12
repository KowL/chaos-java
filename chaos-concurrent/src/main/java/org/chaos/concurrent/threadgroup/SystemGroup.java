package org.chaos.concurrent.threadgroup;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-11 17:11
 * @Modified By:
 */
public class SystemGroup {

    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("currentThread Group: " + threadGroup);
        System.out.println("currentThread Parent Group: " + threadGroup.getParent());
    }
}
