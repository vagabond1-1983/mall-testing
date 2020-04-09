package com.kong.mall.api.testing

import io.restassured.specification.RequestSpecification
import spock.lang.Specification

import static io.restassured.RestAssured.*
import static com.kong.mall.api.constant.GlobalConstant.*

/**
 * mall项目api测试基类
 * 1. setup：跳过https自签名验证，设置baseuri
 */
class BaseMallSpec extends Specification {
    protected RequestSpecification requestSpec

    void setup() {
        println("mall site: $MALL_SITE_URL")
        this.requestSpec = given()
                .relaxedHTTPSValidation()
                .baseUri("$MALL_SITE_URL")
    }
}
