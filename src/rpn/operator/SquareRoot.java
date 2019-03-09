package rpn.operator;

import rpn.properties.CommonConfiguration;

import java.math.BigDecimal;

public class SquareRoot extends Operator {
    @Override
    public void handle() {
        getOneNumber();
        BigDecimal bigDecimal = new BigDecimal(Math.sqrt(firstNumber));
        String result = bigDecimal.setScale(CommonConfiguration.getCalculatorAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
        rpnStack.stackPush(result);
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
