package com.kong.mall.runner.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author vaga
 * @version 2020/5/3 11:45 上午
 * @description 用例运行策略
 */
public class CaseStrategyListener implements IInvokedMethodListener2 {
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {
        // check if skip
        // prepare running data of current step
        // setup hook
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {
        // set next running step
        // teardown hook
    }

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
