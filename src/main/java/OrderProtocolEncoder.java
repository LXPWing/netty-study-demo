import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import javax.xml.ws.Response;
import java.util.List;

public class OrderProtocolEncoder extends MessageToMessageEncoder<ResponseMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ResponseMessage msg, List list) throws Exception {
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
        msg.encode(byteBuf);
        list.add(byteBuf);
    }
}
