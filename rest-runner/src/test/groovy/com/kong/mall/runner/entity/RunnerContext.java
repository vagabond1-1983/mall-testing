package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.Map;

/**
 * @description 运行时上下文，主要是配置加载
 * @author vaga
 * @version 2020/5/2 11:07 上午
 */
@Data
public class RunnerContext implements BaseEntity {
    private static volatile RunnerContext instance;
    private RunnerContext() {}


    private String baseUrl;
    private Map<String, String> env;
    private TestSuiteEntity suiteEntity;

    private TestStepEntity currentStep;

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
}
