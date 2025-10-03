package com.learnautomation.utilities;

import com.learnautomation.pages.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerForScreenshots extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
//This is a new comment
        if(BaseClass.driver != null) {
            ScreenshotsHelper.takeScreenshot(BaseClass.driver, result.getName());
        } else {
            System.out.println("Driver is null. Screenshot not captured.");
        }
    }

}

