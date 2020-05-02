package com.kong.mall.runner.entity

import lombok.Data

/**
 * @description 运行时上下文，主要是配置加载
 * @author vaga
 * @version 2020/5/2 11:07 上午
 */
@Data
class RunnerContext implements BaseEntity {
    private String baseUrl
    private Map<String, String> env
    private TestSuiteEntity suiteEntity
}
