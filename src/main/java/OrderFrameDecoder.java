import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 客户端解码器
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(Integer.MAX_VALUE, 0, 2, 0, 2);
    }
}
