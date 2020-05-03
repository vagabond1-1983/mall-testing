package com.kong.mall.runner.listener;

import com.kong.mall.runner.constant.GlobalConstants;
import com.kong.mall.runner.entity.RunnerContext;
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
    private RunnerContext rctx;
    public CaseStrategyListener(RunnerContext rctx) {
        this.rctx = rctx;
    }

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {
        // prepare running data of current step
        if (rctx.hasNext()) {
            iTestContext.setAttribute(GlobalConstants.CURRENT_STEP_KEY, rctx.next());
        }
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
