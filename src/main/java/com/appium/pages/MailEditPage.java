package com.appium.pages;

import com.appium.utils.XpathUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MailEditPage {

    //收件人地址
    public static MobileElement mailToInput(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/input");
    }

    //邮件主题
    public static MobileElement mailSubjectInput(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/et_subject");
    }

    //邮件正文
    public static MobileElement mailContentInput(AndroidDriver driver){
        return XpathUtils.getElementByClassName(driver, "android.widget.EditText", 1);
    }

    //shortCut
    public static MobileElement shortCutMailBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/layout_shortcut_contact");
    }

    //发送按钮
    public static MobileElement sendBtn(AndroidDriver driver){
        return (MobileElement) driver.findElementById("com.netease.mail:id/tv_send");
    }
}
