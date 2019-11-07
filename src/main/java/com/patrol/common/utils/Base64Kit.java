package com.patrol.common.utils;

import com.patrol.common.Constants;
import org.apache.commons.codec.binary.Base64;

public class Base64Kit {

    /**
     * 加密字符串
     * @param inputData
     * @return
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(Constants.CHARSET)), Constants.CHARSET);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 解密加密后的字符串
     * @param inputData
     * @return
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(Constants.CHARSET)), Constants.CHARSET);
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Base64Kit.encodeData("我是中文"));
        String enStr = Base64Kit.encodeData("我是中文");
        System.out.println(Base64Kit.decodeData(enStr));
    }
}
