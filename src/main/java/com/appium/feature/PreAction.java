package com.appium.feature;

import com.appium.params.TestParams;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class PreAction {

    public AndroidDriver setUp(TestParams params) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            //设置Appium测试引擎:
            capabilities.setCapability("device", "uiautomator2");
            capabilities.setCapability("automationName", "uiautomator2");
            //指定测试设备系统及系统版本:
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "11");
            //指定测试设备名称及设备ID:小米手机
            capabilities.setCapability("deviceName", "bqu8mnbm5pv4oju4");
            capabilities.setCapability("udid", "bqu8mnbm5pv4oju4");

        //华为手机
//        capabilities.setCapability("deviceName", "SNJ4C19524002474");
//        capabilities.setCapability("udid", "SNJ4C19524002474");

            //无线连接指定测试设备名称及设备ID:
//            capabilities.setCapability("deviceName", "192.168.31.35:44503");
//            capabilities.setCapability("udid", "192.168.31.35:44503");
            capabilities.setCapability("newCommandTimeout", 60000);
            capabilities.setCapability("noSign", true);
            //已安装后启动APP
            capabilities.setCapability("app", params.getApkPath());

            //初始化AndroidDriver
            AndroidDriver driver = null;
        try {
            System.out.println("启动app！");
            driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
         return driver;

    }
}
