import io.netty.buffer.ByteBuf;

public class RequestMessage {
    private MessageHeader messageHeader;

    public void decode(ByteBuf msg) {
        int version = msg.readInt();
        long streamId = msg.readLong();
        int code = msg.readInt();

        messageHeader = new MessageHeader();
        messageHeader.setCode(code);
        messageHeader.setStreamId(streamId);
        messageHeader.setVersion(version);
    }
}
