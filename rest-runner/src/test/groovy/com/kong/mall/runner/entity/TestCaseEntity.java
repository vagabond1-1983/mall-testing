package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.List;

/**
 * @description 用例
 * @author vaga
 * @version 2020/5/2 11:24 上午
 */
@Data
class TestCaseEntity implements BaseEntity {
    private Config config;
    private List<TestStepEntity> stepEntities;
}
