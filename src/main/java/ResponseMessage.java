import io.netty.buffer.ByteBuf;
import utils.JsonUtil;

public class ResponseMessage {
    private MessageHeader messageHeader;

    public ResponseMessage(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public void encode(ByteBuf byteBuf) {
        byteBuf.writeInt(messageHeader.getVersion());
        byteBuf.writeLong(messageHeader.getStreamId());
        byteBuf.writeInt(messageHeader.getCode());
        byteBuf.writeBytes(JsonUtil.toJson(messageHeader.getData()).getBytes());
    }
}
