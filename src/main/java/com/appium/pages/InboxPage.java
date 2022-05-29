package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InboxPage {

    //根据文本内容查找邮件主题
    public static MobileElement subjectContent(AndroidDriver driver, String content){
        return (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='"+content+"']");

    }

    //通讯录和设置移到“我的页面”里了
    public static MobileElement IvMsg_1(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/iv_flag");
    }

    //编写邮件按钮
    public static MobileElement editMailBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/fab_compose");
    }

    //邮件已删除toast
    public static MobileElement deletedMailToast(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/snackbar_text");
    }

    //删除邮件按钮
    public static MobileElement deleteMailBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/tv_delete");
    }
}
