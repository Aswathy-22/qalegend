package com.qalegend.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.qalegend.automationcore.Base;
import com.qalegend.pages.*;
import com.qalegend.reports.TestListener;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.RandomDataUtility;
import org.testng.annotations.Test;

import java.util.List;

public class AddUserTest extends Base {
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    LoginPage login;
    HomePage home;
    UserManagementPage userManagement;
    ManageUserPage manageUser;
    AddUserPage addUser;
    @Test(groups = "smoke")
    public void verifyUserCreation(){
        extentTest.get().assignCategory("smoke");
        String prefix=RandomDataUtility.getPrefix();
        String firstName=RandomDataUtility.getFirstname();
        String lastName=RandomDataUtility.getLastname();
        String email=RandomDataUtility.getEmail();
        String uName=firstName.toLowerCase()+lastName.toLowerCase();
        String pWord=RandomDataUtility.getPassword();
        String salesCommissionPercentage=RandomDataUtility.getRandomNumber();
        List<List<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userName = data.get(1).get(1);
        String passWord = data.get(2).get(1);
        login = new LoginPage(driver);
        home = login.loginToApplication(userName, passWord);
        userManagement= home.clickOnUserManagement();
        manageUser=userManagement.clickOnUsers();
        addUser=manageUser.clickOnAddButton();
        manageUser=addUser.addUserDetails(prefix,firstName,lastName,email,uName,pWord,pWord,salesCommissionPercentage);
        manageUser.enterSearchValue(email);

    }
}
