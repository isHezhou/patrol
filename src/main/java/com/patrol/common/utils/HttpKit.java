package com.patrol.common.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * Http工具类
 *
 * @author WangSheng/2019-10-12
 *
 */
public class HttpKit {

    /***
     * 获取请求HttpServletRequest
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /***
     * 获取响应HttpServletResponse
     *
     * @author WangSheng/2019-08-27
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }


    /***
     * 获取IP地址
     *
     * @param request
     *
     * @author WangSheng/2019-10-12
     *
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ips = request.getHeader("x-forwarded-for");
        if(StringUtils.isEmpty(ips)){
            ips = request.getHeader("Proxy-Client-IP");
        }
        if(StringUtils.isEmpty(ips)){
            ips = request.getHeader("WL-Proxy-Client-IP");
        }
        if(StringUtils.isEmpty(ips)){
            ips = request.getRemoteAddr();
        }
        String[] ipArray = ips.split(",");
        String currentIp = null;
        for(int i = 0; i < ipArray.length; ++i) {
            String ip = ipArray[i];
            if(!"unknown".equalsIgnoreCase(ip)) {
                currentIp = ip;
                break;
            }
        }
        return currentIp;
    }


}
