package com.kong.mall.api.constant;

/**
 * @author vaga
 * @version 2020/4/9 7:26 下午
 * @description 全局常量
 */
public class GlobalConstant {
    /**
     * mall api访问地址
     */
    public static String MALL_SITE_URL = System.getProperty("mall.site") == null ? "https://mall.kongs.info" : System.getProperty("mall.site");

    /**
     * admin用户名
     */
    public static final String ADMIN_USERNAME = "admin";

    /**
     * admin密码
     */
    public static final String ADMIN_PASSWORD = "admin";

    /**
     * header认证key
     */
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
}
