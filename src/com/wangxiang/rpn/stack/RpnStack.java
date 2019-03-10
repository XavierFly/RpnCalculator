package com.wangxiang.rpn.stack;

import java.util.Stack;

import com.wangxiang.rpn.util.StringUtil;
import com.wangxiang.rpn.exception.CommonException;

/**
 * 结果栈
 */
public class RpnStack {
    private static RpnStack rpnStack = null;
    private static Stack<String> stack = null;

    private RpnStack() {}

    /**
     * 获取结果栈实例
     * @return 结果栈实例
     */
    public static RpnStack getInstance() {
        if (rpnStack == null) {
            rpnStack = new RpnStack();
            stack = new Stack<>();
        }
        return rpnStack;
    }

    /**
     * 入结果栈
     * @param item 项
     */
    public void stackPush(String item) {
        stack.push(item);
    }

    /**
     * 出结果栈
     * @return 项
     * @throws CommonException 公共异常
     */
    public String stackPop() throws CommonException {
        try {
            return stack.pop();
        } catch (RuntimeException e) {
            throw new CommonException("E002");
        }
    }

    /**
     * 出结果栈后将还原项入结果栈
     * @param undoNumber 还原数字
     * @return 出结果栈的项
     * @throws CommonException 公共异常
     */
    public String stackPopWithUndo(Double undoNumber) throws CommonException {
        try {
            return stack.pop();
        } catch (RuntimeException e) {
            stack.push(String.valueOf(undoNumber));
            throw new CommonException("E002");
        }
    }

    /**
     * 删除所有结果栈中的项
     */
    public void stackRemoveAll() {
        stack.removeAllElements();
    }

    /**
     * 获取结果栈字符串
     * @return 结果栈字符串
     */
    public String getStackString() {
        return StringUtil.handleStackString(stack.toString());
    }

    /**
     * 获取结果栈展示字符串
     * @return 结果栈展示字符串
     */
    public String getStackShowString() {
        return StringUtil.handleStackShowString(stack);
    }
}
