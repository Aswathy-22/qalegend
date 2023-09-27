package com.qalegend.dataprovider;

import com.qalegend.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;
public class dataProviderManager {
    @DataProvider(name="invalidUserCredentialsFromExcel")
    public Object[][] invalidUserCredentialsFromExcel(){
        ExcelUtility excel=new ExcelUtility();
        Object[][] data= excel.dataProviderRead("InvalidLoginCredentials");
        return data;
    }
}
