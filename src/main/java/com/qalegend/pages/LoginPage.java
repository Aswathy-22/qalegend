package com.qalegend.pages;
import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelperUtility {
    WebDriver driver;//driver instance
    public LoginPage(WebDriver driver){//constructor
        this.driver=driver;
        //for initializing webelement using pagefactory
        PageFactory.initElements(driver,this);
    }
    //creating webelement using page factoring
    @FindBy(id="username")
    WebElement userName;
    @FindBy(id="password")
    WebElement password;
    @FindBy(xpath ="//button[@class='btn btn-primary']")
    WebElement loginButton;
    @FindBy(xpath ="//button[@class='btn btn-default btn-sm']")
    WebElement endTourButton;
    @FindBy(xpath = "//div[@class='col-md-8 col-md-offset-4']//a")
    WebElement forgotPassword;
    public String getLoginPageTitle(){
        return webDriver.getTitleofWebpage(driver);
    }
    public void enterUserName(String uName){
        webElement.enterText(userName,uName);
    }
    public void enterPassword(String pWord){
        webElement.enterText(password,pWord);
    }
    public void clickOnLoginButton(){
        webElement.clickOnElement(loginButton);
    }
    public void clickOnEndTour(){
        webElement.clickOnElement(endTourButton);
    }
    public void clickOnForgotPasswordLink(){
        webElement.clickOnElement(forgotPassword);
    }
    public HomePage loginToApplication(String uName,String pWord){
        enterUserName(uName);
        enterPassword(pWord);
        clickOnLoginButton();
        clickOnEndTour();
        return new HomePage(driver);
    }
    public ResetPage forgotPasswordLink(){
        clickOnForgotPasswordLink();
        return new ResetPage(driver);
    }
}
