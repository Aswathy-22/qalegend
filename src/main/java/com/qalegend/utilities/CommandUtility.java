package com.qalegend.utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class CommandUtility {
    public void acceptAlert(Alert alert){
        alert.accept();
    }
    public void dismissAlert(Alert alert){
        alert.dismiss();
    }
    public void switchToAlert(WebDriver driver,Alert alert){
        driver.switchTo().alert();
    }
    public String getTextAlert(Alert alert){
        return alert.getText();
    }
    public void sendValuesAlert(Alert alert,String valueToPass){
        alert.sendKeys(valueToPass);
    }
    public void selectDropDownUsingText(Select select, String dropdownvaluetoselect){
        select.selectByVisibleText(dropdownvaluetoselect);
    }
    public void selectDropdownusingValueAttribute(Select select, String dropdownvaluetoselect){
        select.selectByValue(dropdownvaluetoselect);
    }
    public void selectDropdownusingIndex(Select select,int index){
        select.selectByIndex(index);
    }
    public List<WebElement> getAllDropDownValues(Select select){
        return select.getOptions();
    }
    public boolean multiSelect(Select select){
        return select.isMultiple();
    }
}
