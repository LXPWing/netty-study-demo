package common.order;

import common.OperationResult;
import lombok.Data;

import java.util.List;

@Data
public class QueryOrderOperationResult extends OperationResult {

    private final List<String> dish;

}
