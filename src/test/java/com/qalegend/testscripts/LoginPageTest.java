package com.qalegend.testscripts;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qalegend.automationcore.Base;
import com.qalegend.dataprovider.dataProviderManager;
import com.qalegend.dataprovider.dataProviderManager;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ResetPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.TestNGException;
import java.util.List;
public class LoginPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(groups = {"Smoke"})
    public void verifyLoginPageTitle(){
        extentTest.get().assignCategory("Smoke");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        LoginPage login = new LoginPage(driver);
        String actualTitle = login.getLoginPageTitle();
        extentTest.get().log(Status.PASS,"LoginPage Title received as "+actualTitle);
        String expectedTitle = data.get(0).get(1);
        Assert.assertEquals(actualTitle, expectedTitle, "LoginPage Title mismatch found");
        extentTest.get().log(Status.PASS,"Expected LoginPage Title "+expectedTitle+" matched with actual title "+actualTitle);
    }
    @Test(groups = {"Smoke", "Regression"})
    public void verifyUserLogin() {
        extentTest.get().assignCategory("Regression");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String passWord = data.get(2).get(1);
        String userAccountName = data.get(3).get(1);
        LoginPage login = new LoginPage(driver);
        HomePage home = login.loginToApplication(userName, passWord);
        String actualUserAccountName = home.getUserAccountName();
        Assert.assertEquals(actualUserAccountName, userAccountName, "user login failed");
    }
    @Test(groups = {"Smoke", "Regression"},dataProvider ="invalidUserCredentialsFromExcel",dataProviderClass = dataProviderManager.class)
    public void verifyLoginErrorMessageWithInvalidCredentials(String uName,String pWord) {
        extentTest.get().assignCategory("Regression");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String expectedErrorMessage =data.get(4).get(1);
        LoginPage login = new LoginPage(driver);
        login.enterUserName(uName);
        login.enterPassword(pWord);
        login.clickOnLoginButton();
        String actualErrorMessage=login.verifyLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage, "Error message mismatch: Actual error message does not match the expected error message.");
   }
}
