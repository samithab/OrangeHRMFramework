package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver ldriver){
        this.driver=ldriver;

    }

    @FindBy(name = "username")
    WebElement uname;
    @FindBy(name = "password")
    WebElement pwd;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void loginToHrm(String usernameApplication,String passwordApplication){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        uname.sendKeys(usernameApplication);
        pwd.sendKeys(passwordApplication);
        loginBtn.click();
    }
}
