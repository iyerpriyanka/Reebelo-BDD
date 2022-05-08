package com.au.reebelo.ui.automation.base;


import com.au.reebelo.ui.automation.enums.SupportedBrowsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait webDriverWait;
    public String screenshotLocation = System.getProperty("user.dir") + "/src/test/com/au/reebelo/ui/automation/screenshot";

    public BaseTest() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    "/src/test/resources/configuration.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void initialization(SupportedBrowsers browser) {
        switch (browser) {
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get(prop.getProperty("url"));

    }

    public void closeBrowser() {
        driver.close();
    }

    public void takeScreenshot(String fileName){
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(screenshotLocation + fileName + ".jpg"));
        }catch(IOException e){
            System.err.println(e.getMessage());
        }

    }
}
