package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 测试套件
 * @author vaga
 * @version 2020/5/2 11:23 上午
 */
@Data
public class TestSuiteEntity extends BaseEntity {
    private List<TestCaseEntity> caseEntities;
    private AtomicInteger currentIndex = new AtomicInteger(0);
}
