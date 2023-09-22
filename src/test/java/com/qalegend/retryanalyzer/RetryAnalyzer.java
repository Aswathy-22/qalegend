package com.qalegend.retryanalyzer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
    public class RetryAnalyzer implements IRetryAnalyzer {
        int count=0;
        int retryCount=2;
        @Override
        public boolean retry(ITestResult iTestResult) {
            if(count<retryCount){
                count++;
                return true;
            }
            return false;
        }
}