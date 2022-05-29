package com.appium.feature;

import com.appium.pages.InboxPage;
import com.appium.params.TestParams;
import com.appium.utils.ScreenUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class CheckMailAction {

    public void testCheck(TestParams params, AndroidDriver driver){
        try {
            InboxPage.subjectContent(driver, params.getSubject()).click();
            TimeUnit.SECONDS.sleep(3);
            ScreenUtils.shot(driver, params.getImagePath() + "查看邮件1.jpg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
