package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.*;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddUserTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ManageUserPage manageUser;
    AddUserPage addUser;
    SignOutPage signOut;

    @Test(groups = {"Smoke"})
    public void verifyUserCreation() {
        extentTest.get().assignCategory("Smoke");
        String prefix = RandomDataUtility.getPrefix();
        String firstName = RandomDataUtility.getFirstname();
        String lastName = RandomDataUtility.getLastname();
        String email = RandomDataUtility.getEmail();
        String uName = firstName.toLowerCase() + lastName.toLowerCase();
        String pWord = RandomDataUtility.getPassword();
        String salesCommissionPercentage = RandomDataUtility.getRandomNumber();
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String passWord = data.get(2).get(1);
        login = new LoginPage(driver);
        home = login.loginToApplication(userName, passWord);
        userManagement = home.clickOnUserManagement();
        manageUser = userManagement.clickOnUsers();
        addUser = manageUser.clickOnAddButton();
        manageUser = addUser.addUserDetails(prefix, firstName, lastName, email, uName, pWord, pWord, salesCommissionPercentage);
        manageUser.enterSearchValue(email);
        List<List<String>> actualUserDetails = manageUser.getUserDetails(email);
        List<List<String>> expectedUserData = manageUser.getUserDetails(prefix, firstName, lastName, uName, email, "Admin");
        Assert.assertEquals(actualUserDetails, expectedUserData, "User creation failed");
    }

    @Test(groups = "Regression")
    public void verifyUserLoginForNewlyCreatedUser() {
        extentTest.get().assignCategory("Regression");
        String prefix = RandomDataUtility.getPrefix();
        String firstName = RandomDataUtility.getFirstname();
        String lastName = RandomDataUtility.getLastname();
        String email = RandomDataUtility.getEmail();
        String uName = firstName.toLowerCase() + lastName.toLowerCase();
        String pWord = RandomDataUtility.getPassword();
        String salesCommissionPercentage = RandomDataUtility.getRandomNumber();
        List<List<String>> data= ExcelUtility.excelDataReader("LoginPage");
        String userName=data.get(1).get(1);
        String password=data.get(2).get(1);
        String expectedUserAccountName=firstName+" "+lastName;
        String userAccountName=data.get(3).get(1);
        login=new LoginPage(driver);
        home=login.loginToApplication(userName,password);
        userManagement=home.clickOnUserManagement();
        manageUser=userManagement.clickOnUsers();
        addUser=manageUser.clickOnAddButton();
        manageUser=addUser.addUserDetails(prefix,firstName,lastName,email,uName,pWord,pWord,salesCommissionPercentage);
        signOut=manageUser.clickOnUserAccountId();
        login=signOut.clickOnSignOutButton();
        login.enterUserName(uName);
        login.enterPassword(pWord);
        home=login.clickOnLoginButton();
        String actualUserAccountName = home.getUserAccountName();
        Assert.assertEquals(actualUserAccountName,expectedUserAccountName, "user login failed");
    }
}

