package com.example.classschedule.result;

/**
 * 系统错误码
 * @auther fmh
 * @date 2023/8/1
 */
public enum ResultCodeEnum implements ResultCode {
    SUCCESS(0, "success"),

    API_IS_STUB(-1, "该接口尚未实现"),

    //=================系统==============
    ERROR_EXCEPTION(1000, "系统繁忙，请稍后再试"),
    UNKNOWN_EXCEPTION(1001,"系统未知异常"),
    VALID_EXCEPTION(1002,"参数格式校验失败"),
    REQUEST_BODY_IS_MISSING(1005, "缺少请求参数"),
    IS_REPEAT_REQUEST(1010, "重复请求，请稍后再试"),


    //=================身份认证=============
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "用户或密码错误"),
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    USER_ACCOUNT_DISABLE(2005, "账号已禁用，请联系管理员处理"),
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在，请先注册账号"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
    CAPTCHA_VERIFY_EXCEPTION(2010,"图形验证错误"),
    SMS_CODE_EXCEPTION(2011,"短信验证码获取频率太高，请稍后再试"),
    SMS_CODE_ERROR(2011,"短信验证码错误，请重新输入"),
    USER_THIRD_PARTY_GRANT_FAILED(2012,"获得第三方授权失败，请重试"),
    USER_PHONE_ALREADY_REGISTERED(2013, "手机号已注册"),
    USER_NOT_EXIST(2014, "用户不存在"),
    REDEEM_CODE_ERROR(2015,"兑换码错误"),
    EXCHANGE_ERROR(2016,"兑换失败，积分不足或用户不存在"),

    //===============
    OPERATION_FAIL(9000, "请求操作失败"),

    //===============
    UPDATE_FAIL(3001, "数据更新失败"),


    ;


    public final int code;
    public final String message;
    ResultCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
