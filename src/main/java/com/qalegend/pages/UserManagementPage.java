package com.qalegend.pages;

import com.qalegend.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class UserManagementPage extends TestHelperUtility {
    WebDriver driver;
    public UserManagementPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@class='treeview  active']//li//span[@class='title']")
    List<WebElement> userManagementPanelValues;
    @FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
    WebElement usersPanel;
    public List<String> getUserManagementPanelValues(){
        return page.getValuesAsText(userManagementPanelValues);
    }
    public List<String> getSplittedPanelValues(String panelValue){
        return page.splitString(panelValue,";");
    }
    public ManageUserPage clickOnUsers(){
        webElement.clickOnElement(usersPanel);
        return new ManageUserPage(driver);
    }
}
