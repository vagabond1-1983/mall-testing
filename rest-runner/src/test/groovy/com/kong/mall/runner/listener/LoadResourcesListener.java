package com.kong.mall.runner.listener;

import com.kong.mall.runner.entity.RunnerContext;
import com.kong.mall.runner.util.ResourcesUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * @author vaga
 * @version 2020/5/3 9:32 上午
 * @description 加载资源监听
 */
public class LoadResourcesListener implements ISuiteListener {
    public void onStart(ISuite iSuite) {
        RunnerContext rctx = ResourcesUtil.loadResources(iSuite.getParameter("project"),
                    iSuite.getAllMethods());
        // 动态加载监听策略
        iSuite.addListener(new CaseStrategyListener());
    }

    public void onFinish(ISuite iSuite) {

    }
}
