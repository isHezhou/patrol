package com.patrol.controller;

import com.patrol.common.utils.HttpKit;
import com.patrol.common.utils.JsonKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/***
 * 基础控制层
 *
 * @author WangSheng/2019-10-12
 *
 * @return
 */
public class BaseController {


    HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

    HttpSession getSession() {
        return HttpKit.getRequest().getSession();
    }

    String getIpAddress() {
        return HttpKit.getIp(getHttpServletRequest());
    }

    /***
     * 请求参数反射成指定类型
     *
     * @param clazz
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public <T> T getModel(Class<T> clazz){
        Map<String, String> param = getParamMap(HttpKit.getRequest().getParameterMap());
        return JsonKit.instance().readValue(JsonKit.instance().writeValue(param),clazz);
    }


    /***
     * 默认Request请求参数Map处理
     *
     * @param map
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public Map<String, String> getParamMap(Map<String, String[]> map) {
        try {
            Map<String,String> convert = new HashMap<String,String>();
            if ((map != null) && (map.size() > 0)) {
                for (Map.Entry<String,String[]> entry : map.entrySet()) {
                    convert.put(entry.getKey(), (entry.getValue())[0] + "");
                }
            }
            return convert.size() == 0 ? null : convert;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
