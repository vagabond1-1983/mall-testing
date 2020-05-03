package com.kong.mall.runner.util;

import cn.hutool.core.collection.CollUtil;
import com.kong.mall.runner.entity.*;
import org.testng.ITestNGMethod;

import java.util.List;

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
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setMethod("get");
        requestEntity.setUrl("/headers");
        stepEntity.setRequestEntity(requestEntity);
        caseEntity.setStepEntities(CollUtil.newArrayList(stepEntity));
        suiteEntity.setCaseEntities(CollUtil.newArrayList(caseEntity));
        ctx.setSuiteEntity(suiteEntity);
        return ctx;
    }
}
