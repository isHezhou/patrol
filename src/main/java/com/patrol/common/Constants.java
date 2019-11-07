package com.patrol.common;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/***
 * 项目统一常量类
 *
 * @author WangSheng/2019-10-12
 */
@Component
public class Constants {

    public static final Charset CHARSET = StandardCharsets.UTF_8;
    public static final Integer DEFAULT_PAGE_SIZE = 5;
    public static final Integer APP_PAGE_SIZE = 8;

    public static String system = "dev";
    public static String imgUrl = null;
    public static String webUrl = null;
    public static String staticUrl = null;

}
