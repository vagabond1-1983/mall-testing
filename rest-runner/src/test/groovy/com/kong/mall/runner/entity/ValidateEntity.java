package com.kong.mall.runner.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author vaga
 * @version 2020/5/4 11:57 上午
 * @description 验证实体
 */
@Data
public class ValidateEntity {
    private List<Map<String, Object>> eq;

}
