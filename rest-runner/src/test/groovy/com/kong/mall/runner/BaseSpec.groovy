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
    protected RunnerContext context

    @BeforeTest
    void setup() {
        context = loadPlan()
        this.requestSpec = given()
            .relaxedHTTPSValidation()
            .baseUri(context)
    }
}
