package com.wangxiang.rpn.stack;

import java.util.Stack;

import com.wangxiang.rpn.properties.CommonConfiguration;

/**
 * 存储栈
 */
public class RpnCacheStack {
    private static RpnCacheStack rpnCacheStack = null;
    private static Stack<String> cacheStack = null;

    private RpnCacheStack() {}

    /**
     * 获取存储栈实例
     * @return 存储栈实例
     */
    public static RpnCacheStack getInstance() {
        if (rpnCacheStack == null) {
            rpnCacheStack = new RpnCacheStack();
            cacheStack = new Stack<>();
        }
        return rpnCacheStack;
    }

    /**
     * 出存储栈
     */
    public void cacheStackPop() {
        cacheStack.pop();
    }

    /**
     * 根据自定义的可撤销最大数进行存储
     * @param item 需要存储的项
     */
    public void cacheStackLimitPush(String item) {
        if (cacheStack.size() >= CommonConfiguration.getUndoMaxTimes()) {
            cacheStack.remove(0);
        }
        cacheStack.push(item);
    }

    /**
     * 获取将要出存储栈的项
     * @return 将要出存储栈的项
     */
    public String cacheStackPeek() {
        return cacheStack.peek();
    }

    /**
     * 获取存储栈大小
     * @return 存储栈大小
     */
    public int cacheStackSize() {
        return cacheStack.size();
    }
}
