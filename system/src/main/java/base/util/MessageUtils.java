/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package base.util;

import org.springframework.context.MessageSource;

/**
 * <p>User: gzy
 * <p>Date: 2017-1-10 11:08:42
 * <p>Version: 1.0
 */
public class MessageUtils {

    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringUtils.getBean(MessageSource.class);
        }
        String resMessage = messageSource.getMessage(code, args, null);
        return resMessage;
    }

}
