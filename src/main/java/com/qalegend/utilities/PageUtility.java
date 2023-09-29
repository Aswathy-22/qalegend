package com.qalegend.utilities;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<String> getValuesAsText(List<WebElement> elements) {
        List<String>values=new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            values.add(elements.get(i).getText());
        }
        return values;
    }
    public List<String> splitString(String valueToSplit,String condition){
        String[] valuesArray=valueToSplit.split(condition);
        List<String> data=new ArrayList<>();
        for(String value: valuesArray){
            data.add(value);
        }
        return data;
    }
    public List<List<String>>getUserDataIntoList(String prefix,String firstName,String lastName,String userName,String email,String role ){
        List<List<String>>data=new ArrayList<>();
        String name=prefix+" "+firstName+" "+lastName;
        List<String>userData=Arrays.asList(userName,name,role,email);
        data.add(userData);
        return  data;
    }
}
