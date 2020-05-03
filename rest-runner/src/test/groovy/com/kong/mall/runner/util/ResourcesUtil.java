package com.kong.mall.runner.util;

import com.kong.mall.runner.entity.RunnerContext;
import org.testng.ITestNGMethod;

import java.util.List;

/**
 * @author vaga
 * @version 2020/5/3 10:17 上午
 * @description 资源工具类
 */
public class ResourcesUtil {

    /**
     * 根据项目和用例信息封装成运行时上下文
     * @param project
     * @param allMethods
     * @return
     */
    public static RunnerContext loadResources(String project, List<ITestNGMethod> allMethods) {
        RunnerContext context = mock();
        return context;
    }

    private static RunnerContext mock() {
        RunnerContext ctx = RunnerContext.getInstance();
        ctx.setBaseUrl("http://httpbin.org");
        return ctx;
    }
}
