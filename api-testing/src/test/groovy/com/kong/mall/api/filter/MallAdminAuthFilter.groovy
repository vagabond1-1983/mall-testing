package com.kong.mall.api.filter

import io.restassured.filter.FilterContext
import io.restassured.response.Response
import io.restassured.specification.FilterableRequestSpecification
import io.restassured.specification.FilterableResponseSpecification
import io.restassured.spi.AuthFilter
import com.kong.mall.api.util.MallUtils

/**
 * 请求前登陆获取最新的token
 */
class MallAdminAuthFilter implements AuthFilter {
    @Override
    Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        String adminToken = MallUtils.getToken("admin", "admin")
        requestSpec.given()
                .header("Authorization", adminToken)

        return ctx.next(requestSpec, responseSpec)
    }
}
