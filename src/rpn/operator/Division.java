package rpn.operator;

import rpn.properties.CommonConfiguration;

import java.math.BigDecimal;

public class Division extends Operator {
    @Override
    public void handle() {
        getTwoNumber();
        BigDecimal bigDecimal = new BigDecimal(secondNumber / firstNumber);
        String result = bigDecimal.setScale(CommonConfiguration.getCalculatorAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
        rpnStack.stackPush(result);
        rpnCacheStack.cacheStackLimitPush(rpnStack.getStackString());
    }
}
