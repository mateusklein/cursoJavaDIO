package calc;
import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

public enum Operation{
    SUM(n -> LongStream.of(n).reduce(0, Long::sum))
    , SUBTRACTION(n -> LongStream.of(n).reduce(0, (n1, n2) -> n1 - n2));

    private Calc operationCallback;

    private Operation(Calc operationCallback) {
        this.operationCallback = operationCallback;
    }

    public Calc getOperationCallback() {
        return operationCallback;
    }   
}
