package com.kong.mall.api.testing

import com.kong.mall.api.filter.MallAdminAuthFilter
import org.springframework.http.HttpStatus

import static org.hamcrest.Matchers.*

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
        response.statusCode() == HttpStatus.OK.value()

        expect:
        response
                .then()
                .assertThat()
                .body("data.list.id", hasItems(actualIds))
                .body("data.list", hasSize(listSize))

        where:
        pageNum | pageSize || actualIds | listSize
        1       | 5        || 2         | 5
    }
}
