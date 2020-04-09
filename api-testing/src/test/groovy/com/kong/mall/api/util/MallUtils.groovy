package com.kong.mall.api.util

import io.restassured.http.ContentType
import io.restassured.response.ResponseBody

class MallUtils {

    /**
     * 根据账户获取token
     * @param username
     * @param password
     * @return token = <tokenHead> <token>
     */
    public static String getToken(String site, String username, String password) {
        ResponseBody body = io.restassured.RestAssured.given()
                .when()
                .relaxedHTTPSValidation()
                .baseUri(site)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"username\": \"$username\", \"password\": \"$password\"}")
                .post("/admin/login")
                .body()
        return body.jsonPath().getString("data.tokenHead") + " " + body.jsonPath().getString("data.token")
    }
}
