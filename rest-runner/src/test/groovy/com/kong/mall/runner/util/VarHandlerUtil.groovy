package com.kong.mall.runner.util

import cn.hutool.core.convert.Convert
import com.kong.mall.runner.constant.GlobalConstants
import groovy.text.SimpleTemplateEngine
import groovy.util.logging.Slf4j

/**
 * @description 变量处理工具类
 * @author vaga
 * @version 2020/5/6 4:06 下午
 */
@Slf4j
class VarHandlerUtil {
    static boolean isVarBuildIn(Object obj) {
        if (obj.toString().startsWith(GlobalConstants.VARIABLE_PREFIX)) {
            return true
        }
        return false
    }

    static Object replace(Object value, Map<String, Object> binding) {
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(value).make(binding)
        Class targetClazz = binding.get(value.substring(GlobalConstants.VARIABLE_PREFIX.length())).class
        Object target = Convert.convert(targetClazz, template.toString())
        log.debug("将表达式${value} 替换为${target}")
        return target
    }
}
