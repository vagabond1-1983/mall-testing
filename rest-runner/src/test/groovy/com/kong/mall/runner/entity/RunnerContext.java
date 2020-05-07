package com.kong.mall.runner.entity;


import com.kong.mall.runner.util.VarHandlerUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description 运行时上下文，主要是配置加载
 * @author vaga
 * @version 2020/5/2 11:07 上午
 */
@Slf4j
public class RunnerContext extends BaseEntity implements Iterator<TestStepEntity> {
    private static volatile RunnerContext instance;
    private RunnerContext() {}


    private String baseUrl;
    private Map<String, String> env;
    private TestSuiteEntity suiteEntity;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Map<String, String> getEnv() {
        return env;
    }

    public void setEnv(Map<String, String> env) {
        this.env = env;
    }

    public TestSuiteEntity getSuiteEntity() {
        return suiteEntity;
    }

    public void setSuiteEntity(TestSuiteEntity suiteEntity) {
        this.suiteEntity = suiteEntity;
    }

    public static RunnerContext getInstance() {
        if (null == instance) {
            synchronized (RunnerContext.class) {
                if (null == instance) {
                    instance = new RunnerContext();
                }
            }
        }
        return instance;
    }


    public boolean hasNext() {
        if (null == suiteEntity) {
            return false;
        }

        if (null == suiteEntity.getCaseEntities()) {
            return false;
        }

        if (suiteEntity.getCurrentIndex().get() >= suiteEntity.getCaseEntities().size()) {
            log.info("用例已经运行完成");
            return false;
        }

        TestCaseEntity caseEntity = suiteEntity.getCaseEntities().get(suiteEntity.getCurrentIndex().get());
        log.debug("当前运行用例为：{}", caseEntity);

        if (caseEntity.getCurrentIndex().get() >= caseEntity.getStepEntities().size()) {
            log.info("步骤已经运行完成");
            return false;
        }

        return true;
    }

    public TestStepEntity next() {
        if (!hasNext()) {
            log.error("已经没有步骤可以运行了");
            return null;
        }

        TestCaseEntity caseEntity = suiteEntity.getCaseEntities().get(suiteEntity.getCurrentIndex().get());

        TestStepEntity stepEntity = caseEntity.getStepEntities().get(caseEntity.getCurrentIndex().get());
        // 变量替换
        VarHandlerUtil.replace(stepEntity);

//        Map<String, String> map = match(vars);
//        stepEntity.fill(map);


        caseEntity.getCurrentIndex().incrementAndGet();
        if (caseEntity.getCurrentIndex().get() == caseEntity.getStepEntities().size() &&
            suiteEntity.getCurrentIndex().get() < suiteEntity.getCaseEntities().size()) {
            suiteEntity.getCurrentIndex().incrementAndGet();
        }
        return stepEntity;
    }

    public void remove() {

    }
}
