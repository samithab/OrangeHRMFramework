package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsDataProvider {

    Properties pro;

    public ConfigsDataProvider(){
        File src = new File("Configs/Configs.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pro = new Properties();

        try {
            pro.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDataFromConfig(String KeyToSearch){
        return pro.getProperty(KeyToSearch);
    }

    public String getBrowser(){
        return pro.getProperty("Browser");
    }

    public String getUrl(){
         return pro.getProperty("qaUrl");
    }
}
