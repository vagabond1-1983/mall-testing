package com.kong.mall.runner.entity;

import cn.hutool.core.collection.CollUtil;
import lombok.Data;

import java.util.List;
import java.util.Map;

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

    public List<String> extract() {
        List<String> vars = CollUtil.newArrayList();
        for (Map<String, Object> item : validate.getEq()) {
            for (String key : item.keySet()) {
                if (isVarValue(item.get(key).toString())) {
                    vars.add(extract(item.get(key).toString()));
                }
            }
        }
        return vars;
    }
}
