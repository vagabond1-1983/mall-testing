package com.kong.mall.api.testing

import io.restassured.http.ContentType
import spock.lang.Unroll

/**
 * mall账户登陆测试
 */
class MallPermissionSpec extends BaseMallSpec{

    @Unroll
    def "login"(String username, String password, Integer actualCode) {
        given:
        final request =
                this.requestSpec
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body("{\"username\": \"$username\", \"password\": \"$password\"}")

        when:
        final response = request
                    .post("/admin/login")

        then:
        response.statusCode() == 200

        expect:
        response
                .then()
                .assertThat()
                .body("code", org.hamcrest.Matchers.equalTo(actualCode))

        where:
        username | password || actualCode
        "test"   | 123456   || 200
        "admin"  | "admin"  || 200

    }
}