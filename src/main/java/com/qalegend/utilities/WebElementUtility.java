package com.qalegend.utilities;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementUtility {
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void enterText(WebElement element,String valueToEnter){
        element.sendKeys("Enter Value");
    }
    public String getElementText(WebElement element){
       return element.getText();
    }
    public String getAttributeValue(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }
    public String getHtmlTag(WebElement element){
        return element.getTagName();
    }
    public Point locationOfWebElement(WebElement element){
        return element.getLocation();
    }
    public Dimension sizeOfWebElement(WebElement element){
        return element.getSize();
    }
    public String getCssValueOfWebElement(WebElement element, String CssValue){
        return element.getCssValue(CssValue);
    }
    public boolean webElementIsDisplayedOrNot(WebElement element){
        return element.isDisplayed();
    }
    public boolean webElementIsEnabledOrNot(WebElement element){
        return element.isEnabled();
    }
    public boolean webElementIsSelectedOrNot(WebElement element){
        return element.isSelected();
    }
    public void submitElement(WebElement element){
        element.submit();
    }
    public void getRightClickAction(WebElement rightClick, WebDriver driver){
        Actions action=new Actions(driver);
        action.contextClick(rightClick).build().perform();
    }
    public void getDoubleClickAction(WebElement element, WebDriver driver){
        Actions action=new Actions(driver);
        action.contextClick(element).build().perform();
    }
    public void getDragAndDropAction(WebElement drag,WebElement drop, WebDriver driver){
        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).build().perform();
    }
    public void getDragAndDropActionByOffset(WebElement element, WebDriver driver){
        Actions action=new Actions(driver);
        action.dragAndDropBy(element,100,100).build().perform();
    }
    public void getMoveToElement(WebElement targetElement, WebDriver driver){
        Actions action=new Actions(driver);
        action.moveToElement(targetElement).build().perform();
    }
    public void getProgressBar(WebElement targetElement, WebDriver driver){
        Actions action=new Actions(driver);
        action.moveToElement(targetElement).clickAndHold().moveToElement(targetElement,100,100).release().build().perform();
    }
}
