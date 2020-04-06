package com.kong.mall.api.testing

import com.kong.mall.api.filter.MallAdminAuthFilter

import static org.hamcrest.Matchers.*
import static io.restassured.matcher.RestAssuredMatchers.*
import static io.restassured.module.jsv.JsonSchemaValidator.*

/**
 * 品牌API测试
 */
class MallBrandSpec extends BaseMallSpec{

    void "brand list test"() {
        given:
        final request = this.requestSpec
                .filter(new MallAdminAuthFilter())
                .when()

        when:
        final response = request
                .get("/brand/list?pageNum={pageNum}&pageSize={pageSize}", ["pageNum":pageNum,"pageSize":pageSize])

        then:
        response.statusCode() == 200

        expect:
        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("brand-list-schema.json"))
                .body("data.list.id", matchIds)
                .body("data.list", hasSize(listSize))

        where:
        pageNum | pageSize || matchIds || listSize
        1       | 5        || hasItems(2) || 5
        1       | 5        || not(3) || 5
        2       | 5        || hasItems(3) || 5
        1       | 10       || hasItems(2,3) || 10
    }
}
