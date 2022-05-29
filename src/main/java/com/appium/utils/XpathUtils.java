package com.appium.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class XpathUtils {
    //根据类名获取元素集合，然后返回指定位置的元素
    public static MobileElement getElementByClassName(AndroidDriver driver, String className, int index){
        List<MobileElement> list = driver.findElementsByClassName(className);
        return list.get(index);
    }

    //判断元素是否存在
    public static boolean isElementExsit(AndroidDriver driver, By locator) {
        boolean flag = false;
        try {
            MobileElement element= (MobileElement) driver.findElement(locator);
            flag=null!=element;
        } catch (NoSuchElementException e) {
            System.out.println("Element:" + locator.toString()
                    + " is not exsit!");
        }
        return flag;
    }


    public static boolean byElementIsExist(AndroidDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public static boolean waitForTextAppear(AndroidDriver driver, String text, int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[@text='%s']", text))));
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
