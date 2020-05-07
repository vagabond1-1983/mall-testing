package com.kong.mall.runner.entity;

import com.kong.mall.runner.constant.GlobalConstants;

/**
 * @description 基础实体
 * @author vaga
 * @version 2020/5/2 11:39 上午
 */
abstract class BaseEntity implements IEntity {
    boolean isVarValue(String value) {
        return value.startsWith(GlobalConstants.VARIABLE_PREFIX);
    }

    String extract(String value) {
        if (isVarValue(value)) {
            return value.substring(GlobalConstants.VARIABLE_PREFIX.length());
        }
        return value;
    }
}