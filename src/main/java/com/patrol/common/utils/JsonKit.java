package com.patrol.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Json工具类
 *
 * @author WangSheng/2019-10-12
 *
 */
public class JsonKit {

    private static final Logger logger = LoggerFactory.getLogger(JsonKit.class);

    private ObjectMapper objMapper;
    private static JsonKit jsonKit = null;

    /***
     * 关闭默认无参构造
     *
     * @author WangSheng/2019-10-12
     */
    private JsonKit(){}

    /***
     * 增加构造方法
     *
     * @param objectMapper
     *
     * @author WangSheng/2019-10-12
     */
    private JsonKit(ObjectMapper objectMapper) {
        objMapper = objectMapper;
    }

    /***
     * 单例模式实例化
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static JsonKit instance() {
        if(jsonKit==null){
            jsonKit = new JsonKit(new ObjectMapper());
        }
        return jsonKit;
    }

    /***
     * 将Json字符串转成指定对象
     *
     * @param json      Json字符串
     * @param clazz     指定类
     * @param <T>       泛型，返回指定类型
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public <T> T readValue(String json, Class<T> clazz) {
        try {
            if(StringKit.isEmpty(json)){
                return null;
            }
            return this.objMapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("Json读取[对象]失败，错误信息：{}",e.getMessage());
            return null;
        }
    }

    /***
     * 将Json字符串转成指定集合
     *
     * @param json          Json字符串
     * @param valueType     指定集合类型
     * @param <T>           泛型，返回指定类型
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public <T> T readValue(String json, TypeReference<?> valueType) {
        try {
            if(StringKit.isEmpty(json)){
                return null;
            }
            return this.objMapper.readValue(json, valueType);
        } catch (Exception e) {
            logger.error("Json读取[集合]失败，错误信息：{}",e.getMessage());
            return null;
        }
    }

    /***
     * 将对象转成Json字符串
     *
     * @param object    任意对象
     *
     * @author WangSheng/2018-10-12
     *
     * @return
     */
    public String writeValue(Object object) {
        try {
            return this.objMapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("对象转成Json失败，错误信息：{}",e.getMessage());
            return null;
        }
    }

}
