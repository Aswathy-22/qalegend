package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage extends TestHelperUtility {
    WebDriver driver;
    public SignOutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='Sign Out']")
    WebElement signOutButton;
    public LoginPage clickOnSignOutButton(){
        webElement.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
}
