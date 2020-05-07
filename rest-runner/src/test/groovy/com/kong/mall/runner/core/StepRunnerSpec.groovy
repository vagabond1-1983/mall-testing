package com.kong.mall.runner.core

import com.kong.mall.runner.BaseSpec
import com.kong.mall.runner.constant.GlobalConstants
import com.kong.mall.runner.entity.RequestEntity
import com.kong.mall.runner.entity.TestStepEntity
import com.kong.mall.runner.entity.ValidateEntity
import com.kong.mall.runner.util.VarHandlerUtil
import org.testng.ITestContext
import org.testng.annotations.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*

/**
 * @description 步骤运行器
 * @author vaga
 * @version 2020/5/2 6:35 下午
 */

class StepRunnerSpec extends BaseSpec{
    @Test
    public void execute(ITestContext context) {
        TestStepEntity stepEntity = context.getAttribute(GlobalConstants.CURRENT_STEP_KEY)
        // setup hooks

        // request
        given:
        final request = this.requestSpec
                .when()

        RequestEntity requestEntity = stepEntity.getRequest()

        // send request and get response
        when:
        final response
        if (requestEntity.getMethod().equalsIgnoreCase("get")) {
            response = request
                    .get(requestEntity.getUrl())
        }

        // tear down

        // extract

        // validate
        then:
        ValidateEntity validateEntity = stepEntity.getValidate()
        for (Map<String, Object> vm : validateEntity.getEq()) {
            for (String key : vm.keySet()) {
                def value = vm.get(key)
                if (VarHandlerUtil.isVarBuildIn(value)) {
                    value = VarHandlerUtil.replace(value, stepEntity.getConfig().getVariables())
                }
                assertThat(response[key], equalTo(value))
            }
        }
    }
}
