package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.List;

/**
 * @description 测试套件
 * @author vaga
 * @version 2020/5/2 11:23 上午
 */
@Data
class TestSuiteEntity implements BaseEntity {
    private List<TestCaseEntity> caseEntities;
}
