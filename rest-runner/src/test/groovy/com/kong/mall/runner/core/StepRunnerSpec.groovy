package com.kong.mall.runner.core

import com.kong.mall.runner.BaseSpec
import com.kong.mall.runner.constant.GlobalConstants
import com.kong.mall.runner.entity.RequestEntity
import com.kong.mall.runner.entity.TestStepEntity
import org.testng.ITestContext
import org.testng.annotations.Test

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import static org.hamcrest.Matchers.hasSize

/**
 * @description 步骤运行器
 * @author vaga
 * @version 2020/5/2 6:35 下午
 */

class StepRunnerSpec extends BaseSpec{
    @Test
    public void execute(ITestContext context) {
        TestStepEntity stepEntity = context.getAttribute(GlobalConstants.CURRENT_STEP_KEY)
        given:
        final request = this.requestSpec
                .when()

        RequestEntity requestEntity = stepEntity.getRequestEntity()
        when:
        final response
        if (requestEntity.getMethod().equalsIgnoreCase("get")) {
            response = request
                    .get(requestEntity.getUrl())
        }


        then:
        response.statusCode() == 200
    }
}
