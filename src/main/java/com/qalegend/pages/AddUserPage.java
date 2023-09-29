package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends TestHelperUtility {
    WebDriver driver;
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="surname")
    WebElement prefix;
    @FindBy(id="first_name")
    WebElement firstName;
    @FindBy(id="last_name")
    WebElement lastName;
    @FindBy(id="email")
    WebElement emailId;
    @FindBy(id="select2-role-container")
    WebElement roleSelect;
    @FindBy(id="username")
    WebElement userName;
    @FindBy(id="password")
    WebElement passWord;
    @FindBy(id="confirm_password")
    WebElement confirmPassword;
    @FindBy(id="cmmsn_percent")
    WebElement salesCommissionPercentage;
    @FindBy(id="submit_user_button")
    WebElement saveButton;
    public void enterPrefix(String prefixName){
        webElement.enterText(prefix,prefixName);
    }
    public void enterFirstName(String fName){
        webElement.enterText(firstName,fName);
    }
    public void enterLastName(String lName){
        webElement.enterText(lastName,lName);
    }
    public void enterEmail(String email){
        webElement.enterText(emailId,email);
    }
    public void enterRole(String role){
        webElement.enterText(roleSelect,role);
    }
    public void enterUserName(String uName){
        webElement.enterText(userName,uName);
    }
    public void enterPassword(String pWord){
        webElement.enterText(passWord,pWord);
    }
    public void enterConfirmPassword(String confirmPWord){
        webElement.enterText(confirmPassword,confirmPWord);
    }
    public void enterSalesCommissionPercentage(String salesPercentage){
        webElement.enterText(salesCommissionPercentage,salesPercentage);
    }
    public void clickOnSaveButton(){
        webElement.clickOnElement(saveButton);
    }
    public ManageUserPage addUserDetails(String prefixName,String fName,String lName,String email,String uName,String pWord,String confirmPword,String salesPercentage ){
        enterPrefix(prefixName);
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterUserName(uName);
        enterPassword(pWord);
        enterConfirmPassword(confirmPword);
        enterSalesCommissionPercentage(salesPercentage);
        clickOnSaveButton();
        wait.hardWait();
        return new ManageUserPage(driver);
    }
}
