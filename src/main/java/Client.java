import common.RequestMessage;
import common.order.OrderOperation;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import server.OrderFrameDecoder;
import server.OrderFrameEncoder;
import server.OrderProtocolDecoder;
import server.OrderProtocolEncoder;
import utils.IdUtil;

public class Client {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new OrderFrameEncoder());
                    pipeline.addLast(new OrderFrameDecoder());

                    pipeline.addLast(new OrderProtocolDecoder());
                    pipeline.addLast(new OrderProtocolEncoder());
                }
            });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090);
            channelFuture.sync();

            OrderOperation orderOperation = new OrderOperation(1001, "tudou");

            channelFuture.channel().writeAndFlush(orderOperation);

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
