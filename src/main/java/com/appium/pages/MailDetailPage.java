package com.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MailDetailPage {

    //删除邮件按钮
    public static MobileElement deleteMailBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/conversation_titlebar_delete");
    }
}
