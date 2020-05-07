package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 用例
 * @author vaga
 * @version 2020/5/2 11:24 上午
 */
@Data
public class TestCaseEntity extends BaseEntity {
    private Config config;
    private List<TestStepEntity> stepEntities;
    private AtomicInteger currentIndex = new AtomicInteger(0);
}
