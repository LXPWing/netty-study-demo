import lombok.Data;

@Data
public class MessageHeader {
    private int version;
    private long streamId;
    private int code;
    private Object data;
}
