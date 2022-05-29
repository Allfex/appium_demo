package com.appium.utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class ScreenUtils {

    /**
     * 截屏
     * @param driver
     * @param path
     */
    public static void shot(AndroidDriver driver, String path){
        try {
            File file = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(path));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }








}
