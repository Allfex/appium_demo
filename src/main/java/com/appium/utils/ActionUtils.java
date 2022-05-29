package com.appium.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;

import java.time.Duration;

public class ActionUtils {
    public static Duration duration=Duration.ofMillis(300);//滑动 300ms


    /**
     * 向上滑动
     * @param driver
     */
    public static void swipeToUp(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        try {
            new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).
                    waitAction(WaitOptions.waitOptions(duration)).
                    moveTo(PointOption.point(width / 2, height / 4)).release().perform();
            //滑动以后最好是等待一点时间，方便元素加载之类的
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向下滑动
     * @param driver
     */
    public static void swipeToDown(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        try {
            new TouchAction(driver).press(PointOption.point(width / 2, height / 4)).
                    waitAction(WaitOptions.waitOptions(duration)).
                    moveTo(PointOption.point(width / 2, height * 3 / 4)).release().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向左滑动
     * @param driver
     */
    public static void swipeToLeft(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        try {
            new TouchAction(driver).press(PointOption.point(width * 3/ 4, height / 2))
                    .waitAction(WaitOptions.waitOptions(duration)).
                    moveTo(PointOption.point(width / 4, height / 2)).release().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向右滑动
     * @param driver
     */
    public static void swipeToRight(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        try {
            new TouchAction(driver).press(PointOption.point(width / 4, height / 2)).
                    waitAction(WaitOptions.waitOptions(duration)).
                    moveTo(PointOption.point(width * 3/ 4, height / 2)).release().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







    //根据控件坐标实行点击操作
    public static void press(TouchAction action, int x, int y) {
        action.press(PointOption.point(x, y))
                .release()
                .perform();
    }
    //根据控件element实行点击操作
    public static void press(TouchAction action , AndroidElement element){
        press(action,element.getLocation().getX(),element.getLocation().getY());
    }
    //根据控件坐标实行长按操作
    public static void longPress(TouchAction action, int x, int y, long seconds) {
        action.longPress(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds-1)))
                .release()
                .perform();
    }

    //根据控件element实行长按操作
    public static void longPress(TouchAction action, AndroidElement element, long seconds){
        action.longPress(PointOption.point(element.getLocation().getX(),element.getLocation().getY())).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds-1)))
                .release()
                .perform();
    }
    //轻敲
    public static void tap(TouchAction action, int x, int y) {
        action.tap(PointOption.point(x, y))
                .release()
                .perform();
    }

    public static void tap(TouchAction action , AndroidElement element){
        tap(action,element.getLocation().getX(),element.getLocation().getY());
    }

    public void refresh(AndroidDriver androidDriver){

    }
}
