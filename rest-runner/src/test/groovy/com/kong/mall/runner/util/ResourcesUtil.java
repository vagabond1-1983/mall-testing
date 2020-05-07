package com.kong.mall.runner.util;

import cn.hutool.core.collection.CollUtil;
import com.kong.mall.runner.entity.*;
import org.testng.ITestNGMethod;
import org.testng.collections.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author vaga
 * @version 2020/5/3 10:17 上午
 * @description 资源工具类
 */
public class ResourcesUtil {

    /**
     * 根据项目和用例信息封装成运行时上下文
     * @param project
     * @param allMethods
     * @return
     */
    public static RunnerContext loadResources(String project, List<ITestNGMethod> allMethods) {
        RunnerContext context = mock();
        return context;
    }

    private static RunnerContext mock() {
        RunnerContext ctx = RunnerContext.getInstance();
        ctx.setBaseUrl("http://httpbin.org");

        TestSuiteEntity suiteEntity = new TestSuiteEntity();
        TestCaseEntity caseEntity = new TestCaseEntity();
        TestStepEntity stepEntity = new TestStepEntity();
        Config stepConfig = new Config();
        Map<String, Object> vars = Maps.newHashMap();
        vars.put("expected_status_code", 200);
        stepConfig.setVariables(vars);
        stepEntity.setConfig(stepConfig);
        RequestEntity requestEntity = new RequestEntity();
        ValidateEntity validateEntity = new ValidateEntity();
        requestEntity.setMethod("get");
        requestEntity.setUrl("/headers");
        stepEntity.setRequest(requestEntity);

        Map<String, Object> val = CollUtil.newHashMap();
        val.put("statusCode", "$expected_status_code");
        validateEntity.setEq(CollUtil.newArrayList(val));
        stepEntity.setValidate(validateEntity);

        caseEntity.setStepEntities(CollUtil.newArrayList(stepEntity));
        suiteEntity.setCaseEntities(CollUtil.newArrayList(caseEntity));
        ctx.setSuiteEntity(suiteEntity);
        return ctx;
    }
}
