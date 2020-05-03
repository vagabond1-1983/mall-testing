package com.kong.mall.runner

import com.kong.mall.runner.entity.RunnerContext
import io.restassured.specification.RequestSpecification
import org.testng.annotations.BeforeTest

import static io.restassured.RestAssured.given

/**
 * @description 基类继承
 * @author vaga
 * @version 2020/5/2 10:48 上午
 */
abstract class BaseSpec {
    protected RequestSpecification requestSpec
    protected RunnerContext runnerCtx

    @BeforeTest
    void setup() {
        runnerCtx = RunnerContext.getInstance()
        this.requestSpec = given()
            .baseUri(runnerCtx.getBaseUrl())
    }
}
