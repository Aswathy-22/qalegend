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
    WebElement passWord;
    @FindBy(xpath ="//button[@class='btn btn-primary']")
    WebElement loginButton;
    @FindBy(xpath ="//button[@class='btn btn-default btn-sm']")
    WebElement endTourButton;
    @FindBy(xpath = "//div[@class='col-md-8 col-md-offset-4']//a")
    WebElement forgotPassword;
    @FindBy(xpath = "//span[@class='help-block']//strong")
    WebElement loginErrorMessage;
    public String getLoginPageTitle(){
        return webDriver.getTitleofWebpage(driver);
    }
    public void enterUserName(String uName){
        webElement.enterText(userName,uName);
    }
    public void enterPassword(String pWord){
        webElement.enterText(passWord,pWord);
    }
    public HomePage clickOnLoginButton(){
        webElement.clickOnElement(loginButton);
        return new HomePage(driver);
    }
    public void clickOnEndTour(){
        webElement.clickOnElement(endTourButton);
    }
    public HomePage loginToApplication(String uName,String pWord){
        enterUserName(uName);
        enterPassword(pWord);
        clickOnLoginButton();
        clickOnEndTour();
        return new HomePage(driver);
    }
    public ResetPage clickOnForgotPasswordLink(){
        webElement.clickOnElement(forgotPassword);
        return new ResetPage(driver);
    }
    public String verifyLoginErrorMessage(){
        return webElement.getElementText(loginErrorMessage);
    }
}
