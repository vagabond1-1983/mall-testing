package com.kong.mall.runner.entity;

import lombok.Data;

/**
 * @description 请求实体
 * @author vaga
 * @version 2020/5/2 6:06 下午
 */
@Data
public class RequestEntity implements BaseEntity {
    private String method;
    private String url;

}
