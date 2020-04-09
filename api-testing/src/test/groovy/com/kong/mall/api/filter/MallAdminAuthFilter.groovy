package com.kong.mall.api.filter

import io.restassured.filter.FilterContext
import io.restassured.response.Response
import io.restassured.specification.FilterableRequestSpecification
import io.restassured.specification.FilterableResponseSpecification
import io.restassured.spi.AuthFilter
import com.kong.mall.api.util.MallUtils

import static com.kong.mall.api.constant.GlobalConstant.*

/**
 * 请求前登陆获取最新的token
 */
class MallAdminAuthFilter implements AuthFilter {
    @Override
    Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        String adminToken = MallUtils.getToken(MALL_SITE_URL, ADMIN_USERNAME, ADMIN_PASSWORD)
        requestSpec.given()
                .header(AUTHORIZATION_HEADER_KEY, adminToken)

        return ctx.next(requestSpec, responseSpec)
    }
}
