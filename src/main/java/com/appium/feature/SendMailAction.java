package com.appium.feature;

import com.appium.pages.InboxPage;
import com.appium.pages.MailEditPage;
import com.appium.params.TestParams;
import com.appium.utils.ActionUtils;
import com.appium.utils.ScreenUtils;
import com.appium.utils.XpathUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class SendMailAction {

    public void testDoSend(TestParams params, AndroidDriver driver){

        try {
            InboxPage.editMailBtn(driver).click();
            TimeUnit.SECONDS.sleep(3);
            ScreenUtils.shot(driver, params.getImagePath() + "编辑邮件页面1.jpg");

            MailEditPage.mailToInput(driver).sendKeys(params.getMailTo());
            TimeUnit.SECONDS.sleep(2);
            if(XpathUtils.isElementExsit(driver, By.id("com.netease.mail:id/layout_shortcut_contact"))){
                MailEditPage.shortCutMailBtn(driver).click();
            }

            MailEditPage.mailSubjectInput(driver).click();
            MailEditPage.mailSubjectInput(driver).sendKeys(params.getSubject());
            TimeUnit.SECONDS.sleep(2);
            MailEditPage.mailContentInput(driver).click();
            MailEditPage.mailContentInput(driver).sendKeys(params.getMailContent());
            TimeUnit.SECONDS.sleep(2);
            ScreenUtils.shot(driver, params.getImagePath() + "编辑邮件页面2.jpg");
            MailEditPage.sendBtn(driver).click();
            TimeUnit.SECONDS.sleep(5);
            ActionUtils.swipeToDown(driver);
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
