package com.qalegend.testscripts;
import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ResetPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class ResetPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(groups = {"Smoke","Regression"})
    public void verifyResetPageInvalidEmailErrorMessage(){
        extentTest.get().assignCategory("Regression");
        String email=RandomDataUtility.getEmail();
        List<List<String>> data = ExcelUtility.excelDataReader("ResetPage");
        String resetErrorMessage = data.get(0).get(1);
        LoginPage login=new LoginPage(driver);
        ResetPage reset=login.clickOnForgotPasswordLink();
        reset.enterEmailAddress(email);
        reset.clickResetButton();
        String actualResetErrorMessage=reset.getResetErrorMessage();
        Assert.assertEquals(actualResetErrorMessage,resetErrorMessage, "Reset Password Failed");
    }
}
