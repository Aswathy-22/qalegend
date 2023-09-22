package com.qalegend.automationcore;

import com.qalegend.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.TestNGException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class Base {
    public WebDriver driver;
    public Properties prop;
    public FileInputStream fs;
    public Base()  {
        try {
        prop=new Properties();
        fs=new FileInputStream(System.getProperty("user.dir") + Constants.PROPERTIES_FILE);
        prop.load(fs);
        } catch (IOException e) {
            throw new IllegalArgumentException("GIVEN PROPERTY FILE PATH NOT FOUND."+e.getMessage());
        }
    }
    public void initializeTest(String browser) {
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }
        else throw new RuntimeException("Invalid Browser");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browserName) {
        String baseUrl= prop.getProperty("url");
        initializeTest(browserName);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            takeScreenShot(result);
        }
        driver.close();
    }
    public void takeScreenShot(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File screenshot=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("./Screenshots/"+result.getName()+".png"));//converting file to png using fileutils and we have to mention where we have to store
    }
}
