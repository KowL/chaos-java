package org.chaos.netty.guide.codec.serializable.netty;

import org.chaos.netty.guide.codec.pojo.SubscribeReq;
import io.netty.channel.*;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-10 9:41
 * @Modified By:
 */
public class SubReqClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * Creates a client-side handler.
     */
    public SubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i) {
        SubscribeReq req = new SubscribeReq();
        req.setAddress("南京市雨花台区软件大道101号华为基地");
        req.setPhoneNumber("138xxxxxxxxx");
        req.setProductName("Netty 最佳实践和原理分析");
        req.setSubReqID(i);
        req.setUserName("Lilinfeng");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("Receive server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
