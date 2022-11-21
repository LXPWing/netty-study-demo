package server;

import common.RequestMessage;
import common.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class OrderProtocolEncoder extends MessageToMessageEncoder<RequestMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RequestMessage msg, List list) throws Exception {
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer();
        msg.encode(byteBuf);
        list.add(byteBuf);
    }
}
