package com.kong.mall.api.constant

/**
 * @description 全局常量
 * @author vaga
 * @version 2020/4/9 9:50 下午
 */
class GlobalConstants {
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
