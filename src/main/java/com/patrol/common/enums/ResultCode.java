package com.patrol.common.enums;

import java.util.Arrays;
import java.util.Optional;

/***
 * 错误码枚举类
 *
 * @author WangSheng/2019-10-12
 */
public enum ResultCode {

    CODE_0(0, "操作成功"),
    CODE_1(1, "操作失败"),
    CODE_2(2, "参数异常"),
    CODE_3(3, "用户名或密码有误"),
    CODE_4(4, "访问受限"),
    CODE_5(5, "会话超时，请重新登录"),
    CODE_6(6, "文件不存在"),
    CODE_7(7, "文件类型不支持"),
    CODE_8(8, "数据异常"),

    /*作品相关 100~500*/
    CODE_100(100, "标题不能为空"),
    CODE_101(101, "描述不能为空"),
    CODE_102(102, "内容不能为空");

    public static final Integer SUCCESS = 0;
    public static final Integer FAIL = 1;

    public final Integer code;
    public final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCode codeOf(Integer code){
        Optional optional = Arrays.stream(values()).filter(em -> code.equals(em.code)).findFirst();
        return optional.isPresent() ? (ResultCode)optional.get() : null;
    }
}
