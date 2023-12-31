package com.qalegend.pages;
import com.qalegend.utilities.ExcelUtility;
import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResetPage extends TestHelperUtility {
    WebDriver driver;
    public ResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="email")
    WebElement email;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement resetButton;
    @FindBy(xpath = "//span[@class='help-block']//strong")
    WebElement errorMessage;
    public void enterEmailAddress(String emailId){
        webElement.enterText(email,emailId);
    }
    public void clickResetButton(){
        webElement.clickOnElement(resetButton);
    }
    public String getResetErrorMessage(){
        return webElement.getElementText(errorMessage);
    }
}
