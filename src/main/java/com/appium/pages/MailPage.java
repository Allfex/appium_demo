package com.appium.pages;

import com.appium.utils.XpathUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import javax.xml.xpath.XPathConstants;
import java.util.List;

public class MailPage{

    //邮箱添加之后的完成按钮
    public static MobileElement doneBtn(AndroidDriver driver){
        return XpathUtils.getElementByClassName(driver, "android.widget.TextView", 0);
    }

    //邮箱添加成功验证信息
    public static MobileElement doneMsg(AndroidDriver driver){
        return XpathUtils.getElementByClassName(driver, "android.widget.TextView", 1);
    }

}
