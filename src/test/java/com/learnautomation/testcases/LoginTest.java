package com.learnautomation.testcases;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.ConfigsDataProvider;
import com.learnautomation.utilities.ListenerForScreenshots;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerForScreenshots.class)
public class LoginTest extends BaseClass {

    @Test
    public void LoginTestApp(){

        ConfigsDataProvider config = new ConfigsDataProvider();

        String username = config.getDataFromConfig("username");
        String password = config.getDataFromConfig("password");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToHrm(username,password);
    }

}
