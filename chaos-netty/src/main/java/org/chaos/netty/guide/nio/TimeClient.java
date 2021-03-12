package org.chaos.netty.guide.nio;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-07 10:07
 * @Modified By:
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-00" + i)
                    .start();
        }
    }
}
