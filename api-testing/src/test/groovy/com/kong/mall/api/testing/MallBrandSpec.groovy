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
                .body("data.list.id", hasItems(actualIds))
                .body("data.list", hasSize(listSize))

        where:
        pageNum | pageSize || actualIds || listSize
        1       | 5        || 2         || 5
    }
}
