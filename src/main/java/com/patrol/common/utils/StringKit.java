package com.patrol.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/***
 * 字符串工具类
 *
 * @author WangSheng/2019-10-12
 */
public class StringKit {

    private static final Logger logger = LoggerFactory.getLogger(StringKit.class);

    /***
     * 判断内容是否为空
     *
     * @param content    内容
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static boolean isEmpty(String content){
        return StringUtils.isEmpty(content);
    }

    /***
     * 特定字符拼接
     *
     * @param collection    集合
     * @param suffix        固定字符
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static String join(List<?> collection, String suffix){
        return StringUtils.join(collection,suffix);
    }

    /***
     * 特定字符分隔
     *
     * @param content       集合
     * @param suffix        固定字符
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static String[] split(String content, String suffix){
        return StringUtils.split(content,suffix);
    }

    /***
     * 获取UUID
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static String uuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }

    /***
     * 获取1-10的随机数
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static Integer random(){
        return (int)(1+Math.random()*10-1);
    }

    /***
     * 获取指定长度的随机数
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static String random(int size){
        StringBuffer buffer = new StringBuffer();
        do {
            buffer.append((int)(1+Math.random()*10)-1);
            --size;
        }while (size>0);
        return buffer.toString();
    }

    /***
     * 值拼接
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static String concat(Object... value){
        StringBuffer stringBuffer = new StringBuffer();
        if(value!=null){
            Arrays.asList(value).forEach(stringBuffer::append);
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        Integer number = (int)(1+Math.random()*(10-1+1));
        System.err.println(number);
    }


}
