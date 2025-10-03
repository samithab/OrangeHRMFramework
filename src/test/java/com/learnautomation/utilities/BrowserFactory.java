package com.learnautomation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {
    private static  WebDriver driver;


    public static WebDriver startApplication( WebDriver driver,String browserName, String appURL) {

        if(browserName.equals("Chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    
        } else if (browserName.equals("Firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    
        } else if (browserName.equals("IE")) {
        System.out.println("We do not support this browser");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;


    }

    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }
}
