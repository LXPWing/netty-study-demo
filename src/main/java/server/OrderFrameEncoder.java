package server;

import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 客户端编码器
 */
public class OrderFrameEncoder extends LengthFieldPrepender {
    public OrderFrameEncoder() {
        super(2);
    }
}
