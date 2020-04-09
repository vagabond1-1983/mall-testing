package com.kong.mall.api.testing

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
        String mallSite = System.getProperty("mall.site") == null ? "https://mall.kongs.info" : System.getProperty("mall.site")
        println("mall site: $mallSite")
        this.requestSpec = given()
                .relaxedHTTPSValidation()
                .baseUri(mallSites)
    }
}
