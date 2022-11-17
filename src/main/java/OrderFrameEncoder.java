import io.netty.handler.codec.LengthFieldPrepender;

/**
 * 客户端编码器
 */
public class OrderFrameEncoder extends LengthFieldPrepender {
    public OrderFrameEncoder(int lengthFieldLength) {
        super(2);
    }
}
