package com.qalegend.testscripts;
import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.HomePage;
import com.qalegend.pages.LoginPage;
import com.qalegend.pages.ResetPage;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class ResetPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(groups = {"smoke","Regression"})
    public void verifyResetPageInvalidEmailErrorMessage(){
        extentTest.get().assignCategory("Regression");
        List<List<String>> data = ExcelUtility.excelDataReader("ResetPage");
        LoginPage login=new LoginPage(driver);
        ResetPage reset=login.forgotPasswordLink();
        reset.verifyEmailAddress();
        reset.verifyResetButton();
        String resetErrorMessage = data.get(0).get(1);
        String actualResetErrorMessage=reset.getResetErrorMessage();
        Assert.assertEquals(actualResetErrorMessage,resetErrorMessage, "Reset Password Failed");
    }
}
