package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;

import java.util.List;

public class PrePage{

    //系统安装同意
    public static MobileElement agreeInstallBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("android:id/button2");
    }

    //引导页-同意条款政策
    public static MobileElement agreePolicyBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/btn_agree");
    }

    //引导页-登陆大师号
    public static MobileElement loginBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/tv_dashi_login");
    }

    //引导页-添加邮箱
    public static MobileElement addMailBoxBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/tv_add_mail");
    }

    //添加邮箱地址
    public static MobileElement mailAddressInput(AndroidDriver driver){
        return (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='1']");
    }

    //添加邮箱密码
    public static MobileElement passwordInput(AndroidDriver driver){
        return (MobileElement) driver.findElementByXPath("//android.widget.EditText[@index='2']");
    }

    //添加按钮
    public static MobileElement addBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc='添加']");
    }

    //未输入邮箱和密码错误提示toast
    public static MobileElement errorMsg_1(AndroidDriver driver){
        return (MobileElement) driver.findElementByClassName("android.widget.Toast");
    }

    //账号或密码错误提示
    public static MobileElement errorMsg_2(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/tv_title");
    }

    //账号密码错误窗口--确定
    public static  MobileElement errorMsg_Confirm(AndroidDriver driver){
        return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='确定']");
    }




}
