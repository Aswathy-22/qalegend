package com.qalegend.utilities;
import org.openqa.selenium.WebElement;
import java.util.List;
public class PageUtility {
    public void selectValue(List<WebElement> dropdownvalues, String valueToSelect){
        for(int i=0;i<dropdownvalues.size();i++){
            String value=dropdownvalues.get(i).getText();
            if(value.equals(valueToSelect)){
                dropdownvalues.get(i).click();
                break;
            }
        }
    }
}
