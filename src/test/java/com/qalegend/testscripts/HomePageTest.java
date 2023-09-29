package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(groups = {"Smoke","Regression"})
    public  void verifyHomePageTitle(){
        extentTest.get().assignCategory("Regression");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String passWord = data.get(2).get(1);
        String userAccountName = data.get(3).get(1);
        LoginPage login = new LoginPage(driver);
        HomePage home = login.loginToApplication(userName, passWord);
        String expectedtitle="Home - ABC";
        String actualresult= home.getHomePageTitle();
        Assert.assertEquals(actualresult,expectedtitle,"Invalid Home");
    }
}
