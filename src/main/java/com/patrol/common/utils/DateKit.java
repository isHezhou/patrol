package com.patrol.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 时间工具类
 *
 * @author WangSheng/2019-10-29
 *
 */
public class DateKit {

    public static final String FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_NORMAL_CN = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String FORMAT_SHORT = "yyyy-MM-dd";
    public static final String FORMAT_SHORT_CN = "yyyy年MM月dd日";

    /***
     * 获取当前时间
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static Date getDate(){
        return new Date();
    }

    /***
     * 获取当前时间
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static Timestamp getSqlDate(){
        return new Timestamp(getDateLong());
    }

    /***
     * 获取当前时间
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static Timestamp getTimestamp(){
        return getTimestamp(getDate());
    }

    /***
     * 获取时间
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static Timestamp getTimestamp(Date date){
        return date==null ? null : new Timestamp(date.getTime());
    }

    /***
     * 将固定格式的时间字符串转成时间格式
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static Date getDate(String date){
        return new Date(date);
    }

    /***
     * 获取当前时间
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static Long getDateLong(){
        return System.currentTimeMillis();
    }

    /***
     * 获取当前时间默认格式
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static String getDateFormat(){
        return new SimpleDateFormat(DateKit.FORMAT_NORMAL).format(getDate());
    }

    /***
     * 将获取前时间指定格式
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static String getDateFormat(String format){
        return StringKit.isEmpty(format) ? null : new SimpleDateFormat(format).format(getDate());
    }

    /***
     * 获取指定时间默认格式
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static String getDateFormat(Date date){
        return date == null ? null : new SimpleDateFormat(DateKit.FORMAT_NORMAL).format(date);
    }

    /***
     * 获取指定时间指定格式
     *
     * @author WangSheng/2019-10-29
     *
     * @return
     */
    public static String getDateFormat(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }



}
