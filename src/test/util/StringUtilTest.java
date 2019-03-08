package test.util;

import org.junit.Test;

import rpn.util.StringUtil;

import java.util.Stack;

public class StringUtilTest {
    @Test
    public void spiltBySpace() {
        String[] result = StringUtil.spiltBySpace("a b c d");
        for (String s : result) {
            System.out.println(s);
        }
    }

    @Test
    public void handleClear() {
        System.out.println(StringUtil.handleClear("123 clear test"));
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        String test = stack.toString();
        System.out.println(test);
        System.out.println(stack);
    }
}