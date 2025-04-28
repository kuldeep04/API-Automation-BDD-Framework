package org.fancode.utilities.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtils {

    private static Logger logger;

    private LoggingUtils() {} // private constructor

    public static Logger getLogger(Class<?> clazz) {
        if (logger == null) {
            synchronized (LoggingUtils.class) {
                if (logger == null) {
                    logger = LoggerFactory.getLogger(clazz);
                }
            }
        }
        return logger;
    }
}
