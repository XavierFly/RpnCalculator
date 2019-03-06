package test.util;

import org.junit.Assert;
import org.junit.Test;
import rpn.util.StringUtil;
import rpn.stack.RpnStack;

import junit.framework.TestCase;

public class StringUtilTest {
    @org.junit.Test
    public void spiltBySpace() {
        String[] result = {"a", "b", "c", "d"};
        // Assert.assertEquals(result, StringUtil.spiltBySpace("a b c d"));
        TestCase.assertEquals(result, StringUtil.spiltBySpace("a b c d"));
    }

    @Test
    public void go() {
        TestCase.assertEquals(1, StringUtil.go());
    }

    @Test
    public void tt() {
        RpnStack rpnStack = RpnStack.getInstance();
        rpnStack.push("+");
        rpnStack = RpnStack.getInstance();
        System.out.println(rpnStack.getStack());
    }
}