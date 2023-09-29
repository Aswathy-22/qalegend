package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.dataprovider.dataProviderManager;
import com.qalegend.pages.*;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.CommandUtility;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class ManageUserTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ManageUserPage manageUser;
    AddUserPage addUser;
    String prefix=RandomDataUtility.getPrefix();
    String firstName=RandomDataUtility.getFirstname();
    String lastName=RandomDataUtility.getLastname();
    String email=RandomDataUtility.getEmail();
    String uName=firstName.toLowerCase()+lastName.toLowerCase();
    String passWord=RandomDataUtility.getPassword();
    String salesCommissionPercentage=RandomDataUtility.getRandomNumber();

    @Test(groups = {"Smoke", "Regression"})
    public void verifyInvalidUserSearch() {
        extentTest.get().assignCategory("Smoke");
        String email = RandomDataUtility.getEmail();
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String passWord = data.get(2).get(1);
        login = new LoginPage(driver);
        home = login.loginToApplication(userName, passWord);
        userManagement = home.clickOnUserManagement();
        manageUser = userManagement.clickOnUsers();
        manageUser.enterSearchValue(email);
        String expectedErrorMessage = data.get(5).get(1);
        String actualErrorMessage = manageUser.verifySearchFieldErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Search");
    }

    @Test(groups = "Regression")
    public void verifyUserDelete() {
        extentTest.get().assignCategory("Regression");
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String password = data.get(2).get(1);
        List<List<String>> invalidEmailErrorMessage = ExcelUtility.excelDataReader("ManageUsers");
        String errorMessage = invalidEmailErrorMessage.get(0).get(1);
        login = new LoginPage(driver);
        home = login.loginToApplication(userName, password);
        userManagement = home.clickOnUserManagement();
        manageUser = userManagement.clickOnUsers();
        addUser = manageUser.clickOnAddButton();
        manageUser = addUser.addUserDetails(prefix, firstName, lastName, email, uName, passWord, passWord, salesCommissionPercentage);
        manageUser.enterSearchValue(email);
        manageUser.clickOnDeleteButton();
        manageUser.acceptUserDeletionPopup();
        manageUser.enterSearchValue(email);
        String actualErrorMessage = manageUser.verifySearchFieldErrorMessage();
        Assert.assertEquals(actualErrorMessage, errorMessage, "Unable to delete");
    }
}

