package com.qalegend.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
public class WebDriverUtility {
    public String getWindowHandleID(WebDriver driver){
        return driver.getWindowHandle();
    }
    public Set<String> getWindowHandleIDs(WebDriver driver){
        return driver.getWindowHandles();
    }
    public void switchToWindow(WebDriver driver,String handleID){
        driver.switchTo().window(handleID);
    }
    public void maximiseBrowserWindow(WebDriver driver){
        driver.manage().window().maximize();
    }
    public void deleteAllCookiesWindow(WebDriver driver){
        driver.manage().deleteAllCookies();
    }
    public String getTitleofWebpage(WebDriver driver){
        return driver.getTitle();
    }
    public String getCurrentUrlofWebpage(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getSourceCodeofWebpage(WebDriver driver){
        return driver.getPageSource();
    }
    public WebElement findWebElementByID(WebDriver driver,String id){
        return driver.findElement(By.id(id));
    }
    public WebElement findWebElementByXpath(WebDriver driver,String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement findWebElementByCSSSelector(WebDriver driver,String CSSselector){
        return driver.findElement(By.cssSelector(CSSselector));
    }
    public List<WebElement> findWebElementsByID(WebDriver driver, String id){
        return driver.findElements(By.id(id));
    }
    public List<WebElement> findWebElementsByXpath(WebDriver driver, String xpath){
        return driver.findElements(By.xpath(xpath));
    }
    public List<WebElement> findWebElementsByCSSSelector(WebDriver driver,String CSSselector){
        return driver.findElements(By.cssSelector(CSSselector));
    }
    public void closeBrowser(WebDriver driver){
        driver.close();
    }
    public void closeAllBrowser(WebDriver driver){
        driver.quit();
    }
    public void navigateToURL(WebDriver driver, String url){
        driver.navigate().to(url);
    }
    public void navigateForward(WebDriver driver){
        driver.navigate().forward();
    }
    public void navigateBackward(WebDriver driver){
        driver.navigate().back();
    }
    public void refreshWebPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public void switchToFrameIndex(WebDriver driver, int index){
        driver.switchTo().frame(index);
    }
    public void switchToFrameByNameorID(WebDriver driver, String id){
        driver.switchTo().frame(id);
    }
    public void switchToFrameByWebElement(WebDriver driver, WebElement element){
        driver.switchTo().frame(element);
    }




}
