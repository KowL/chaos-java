package org.chaos.concurrent.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 *
 * 简单的不可重入锁实现
 *
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-12 17:14
 * @Modified By:
 */
public class SimpleLock extends AbstractQueuedSynchronizer {

    public void lock() {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
        } else {
            acquire(1);
        }
    }

    @Override
    protected final boolean tryAcquire(int acquires) {
        final Thread current = Thread.currentThread();
        int state = getState();
        if (state == 0 && compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
        return false;
    }

    public void unlock() {
        release(1);
    }

    @Override
    protected final boolean tryRelease(int releases) {
        int c = getState() - releases;
        if (Thread.currentThread() != getExclusiveOwnerThread()) {
            throw new IllegalMonitorStateException();
        }
        boolean free = false;
        if (c == 0) {
            free = true;
            setExclusiveOwnerThread(null);
        }
        setState(c);
        return free;
    }

    static int cnt = 0;

    public static void main(String[] args) {
        SimpleLock simpleLock = new SimpleLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                simpleLock.lock();
                System.out.println(Thread.currentThread().getName() + " cnt=" + cnt);
                cnt++;
                System.out.println(Thread.currentThread().getName() + " cnt=" + cnt);
                simpleLock.unlock();
            }).start();
        }
    }
}
