package com.kong.mall.api.testing

import static com.kong.mall.api.constant.GlobalConstants.*
import io.restassured.specification.RequestSpecification
import spock.lang.Specification

import static io.restassured.RestAssured.*

/**
 * mall项目api测试基类
 * 1. setup：跳过https自签名验证，设置baseuri
 */
class BaseMallSpec extends Specification {
    protected RequestSpecification requestSpec

    void setup() {
        def site = MALL_SITE_URL
        println("mall site: $site")
        this.requestSpec = given()
                .relaxedHTTPSValidation()
                .baseUri(site)
    }
}
