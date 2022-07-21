package com.itheima.reggie.common;

import lombok.extern.java.Log;

/**
 * 基于 ThreadLocal封装的工具类，用于保存和获取当前登录 Id
 *
 * @author wy
 * @version 1.0
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
