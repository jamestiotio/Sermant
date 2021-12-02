/*
 * Copyright (C) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.javamesh.core.exception;

import java.util.Locale;

/**
 * 元数据错误异常
 *
 * @author HapThorin
 * @version 1.0.0
 * @since 2021/11/4
 */
public class SchemaException extends RuntimeException {
    /**
     * 无法找到版本
     */
    public static final MsgParser MISSING_VERSION = new MsgParser() {
        @Override
        public String parse(Object... args) {
            return String.format(Locale.ROOT, "Unable to find version of %s. ", args);
        }
    };

    /**
     * 查找到的名称和希望的不一致
     */
    public static final MsgParser UNEXPECTED_NAME = new MsgParser() {
        @Override
        public String parse(Object... args) {
            return String.format(Locale.ROOT, "Name of plugin is wrong, giving %s but expecting %s. ", args);
        }
    };

    /**
     * 查找到的版本和希望的不一致
     */
    public static final MsgParser UNEXPECTED_VERSION = new MsgParser() {
        @Override
        public String parse(Object... args) {
            return String.format(Locale.ROOT, "Version of %s is wrong, giving %s but expecting %s. ", args);
        }
    };

    /**
     * 不接受外部依赖包
     */
    public static final MsgParser UNEXPECTED_EXT_JAR = new MsgParser() {
        @Override
        public String parse(Object... args) {
            return String.format(Locale.ROOT, "External jar %s is not allowed. ", args);
        }
    };

    public SchemaException(MsgParser parser, Object... args) {
        super(parser.parse(args));
    }

    /**
     * 信息转换器
     */
    public interface MsgParser {
        String parse(Object... args);
    }
}