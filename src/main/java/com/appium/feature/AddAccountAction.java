package com.appium.feature;

import com.appium.pages.MailPage;
import com.appium.pages.PrePage;
import com.appium.params.TestParams;
import com.appium.utils.ActionUtils;
import com.appium.utils.ScreenUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AddAccountAction {

    public void testAdd(TestParams params, AndroidDriver driver){

        try {
            //设置全局隐性等待时间
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            PrePage.agreePolicyBtn(driver).click();
            TimeUnit.SECONDS.sleep(2);

            PrePage.addMailBoxBtn(driver).click();
            TimeUnit.SECONDS.sleep(2);

            PrePage.mailAddressInput(driver).sendKeys(params.getMailAddress());
            TimeUnit.SECONDS.sleep(1);
            PrePage.addBtn(driver).click();
            TimeUnit.SECONDS.sleep(1);
            ScreenUtils.shot(driver, params.getImagePath() + "未输入密码1.jpg");

            //此处输入错误的用户名和密码，验证错误提示信息
            PrePage.mailAddressInput(driver).sendKeys(params.getMailAddress());
            TimeUnit.SECONDS.sleep(2);
            PrePage.passwordInput(driver).click();
            //输入错误的密码
            PrePage.passwordInput(driver).sendKeys(params.getPassword()+"1");
            TimeUnit.SECONDS.sleep(2);
            PrePage.addBtn(driver).click();
            TimeUnit.SECONDS.sleep(2);
            Assert.assertEquals(PrePage.errorMsg_2(driver).getText(), "帐号或密码错误");
            PrePage.errorMsg_Confirm(driver).click();
            //截图
            ScreenUtils.shot(driver, params.getImagePath() + "帐号或密码错误2.jpg");

            PrePage.mailAddressInput(driver).sendKeys(params.getMailAddress());
            TimeUnit.SECONDS.sleep(2);
            PrePage.passwordInput(driver).click();
            PrePage.passwordInput(driver).sendKeys(params.getPassword());
            TimeUnit.SECONDS.sleep(2);
            //截图
            ScreenUtils.shot(driver, params.getImagePath() + "添加邮箱图片3.jpg");
            PrePage.addBtn(driver).click();

            TimeUnit.SECONDS.sleep(2);
            Assert.assertEquals(MailPage.doneMsg(driver).getText(), "邮箱添加成功");
            ScreenUtils.shot(driver, params.getImagePath() + "邮箱添加成功4.jpg");

            TimeUnit.SECONDS.sleep(2);
            MailPage.doneBtn(driver).click();
            TimeUnit.SECONDS.sleep(2);
            ActionUtils.swipeToDown(driver);
            TimeUnit.SECONDS.sleep(5);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


}
