package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.Map;

/**
 * @description 配置实体
 * @author vaga
 * @version 2020/5/2 11:57 上午
 */
@Data
public class Config extends BaseEntity{
    private String name;
    private String baseUrl;
    private Map<String, String> variables;
}
