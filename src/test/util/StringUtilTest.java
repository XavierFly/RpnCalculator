package test.util;

import org.junit.Test;

import java.util.Stack;

public class StringUtilTest {
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