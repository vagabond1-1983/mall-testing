package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.List;

/**
 * @description 步骤实体
 * @author vaga
 * @version 2020/5/2 11:59 上午
 */
@Data
class TestStepEntity implements BaseEntity {
    private Config config;
    private RequestEntity requestEntity;
    private List<String> validates;
}
