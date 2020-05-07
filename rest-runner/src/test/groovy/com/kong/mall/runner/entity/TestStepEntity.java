package com.kong.mall.runner.entity;

import lombok.Data;

/**
 * @description 步骤实体
 * @author vaga
 * @version 2020/5/2 11:59 上午
 */
@Data
public class TestStepEntity extends BaseEntity {
    private Config config;
    private RequestEntity request;
    private ValidateEntity validate;

}
