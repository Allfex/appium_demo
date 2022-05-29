package com.appium.feature;

import com.appium.pages.InboxPage;
import com.appium.pages.MailDetailPage;
import com.appium.params.TestParams;
import com.appium.utils.ActionUtils;
import com.appium.utils.ScreenUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;
import org.testng.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DeleteMailAction {

    public void deleteInDetailPage(TestParams params, AndroidDriver driver){
        try {
            MailDetailPage.deleteMailBtn(driver).click();
            TimeUnit.SECONDS.sleep(1);
            Assert.assertEquals(InboxPage.deletedMailToast(driver).getText(), "邮件移至[已删除]");
            ScreenUtils.shot(driver, params.getImagePath() + "删除邮件1.jpg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteInboxPage(TestParams params, AndroidDriver driver){
        try {
            TouchAction touchAction = new TouchAction(driver);
            ActionUtils.longPress(touchAction, (AndroidElement) InboxPage.subjectContent(driver, params.getSubject()), 2);
            ScreenUtils.shot(driver, params.getImagePath() + "长按选中邮件1.jpg");
            InboxPage.deleteMailBtn(driver).click();
            TimeUnit.SECONDS.sleep(1);
            Assert.assertEquals(InboxPage.deletedMailToast(driver).getText(), "邮件移至[已删除]");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
