package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.UserManagementPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserManagementTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(groups = {"Smoke","Regression"})
    public void verifyUserManagementPanelData(){
        extentTest.get().assignCategory("Regression");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String passWord = data.get(2).get(1);
        List<List<String>> panelData = ExcelUtility.excelDataReader("UserManagement");
        String panelValue=panelData.get(0).get(1);
        LoginPage login=new LoginPage(driver);
        HomePage home=login.loginToApplication(userName,passWord);
        UserManagementPage userManagement=home.clickOnUserManagement();
        List<String> expectedPanelValues=userManagement.getSplittedPanelValues(panelValue);
        List<String> actualPanelValues=userManagement.getUserManagementPanelValues();
        Assert.assertEquals(actualPanelValues,expectedPanelValues,"Required panel values is not in usermanagement panel");
    }
}
