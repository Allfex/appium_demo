package com.appium;

import com.appium.feature.*;
import com.appium.pages.InboxPage;
import com.appium.pages.PrePage;
import com.appium.params.TestParams;
import com.appium.utils.ActionUtils;
import com.appium.utils.XpathUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.xpath.XPathConstants;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Main {

    public static AndroidDriver driver;
    TestParams params = new TestParams();

    /**
     * 动作：配置手机参数，组织测试数据
     */
    @BeforeClass
    public void preparation() {
        //设置图片存储路径，发送测试报告
        String imagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File file = null;
        if(isWindows()){
            file = new File(imagePath + File.separator+"images");
        }else {
            file = new File(imagePath+".."+File.separator+"images");
        }
        file.mkdirs();
        imagePath = file.getPath()+File.separator;

        //工作中我感到最有成就的事
        String content = "I have self-developed web-based automated test platform through constant" +
                " hardworking and technology research, and solved the problems that resulted in " +
                "testing bottlenecks and insufficient manpower due to corporate business expansion," +
                " which significantly improved testing efficiency and secured the smooth running of " +
                "the software.";
        params.setImagePath(imagePath);
        String apkPath = Main.class.getClassLoader().getResource("apk/mail.apk").getPath();
        File apkFile = new File(apkPath);
        params.setApkPath(apkFile.getAbsolutePath());
        params.setMailAddress("automatic_test2022@163.com");
        params.setMailContent(content);
        params.setUsername("automatic_test2022");
        params.setPassword("I_love_fidelity");
        params.setMailTo("automatic_test2022@163.com");
        params.setSubject("自动化测试邮件serial="+ System.currentTimeMillis());

        PreAction preAction = new PreAction();
       driver =  preAction.setUp(params);

    }

    /**
     * 动作：添加邮箱账户
     * 验证：未输入密码错误提示
     * 验证：用户名密码不正确错误提示
     */
    @Test(priority = 1,enabled = true)
    public void addAccount(){
        AddAccountAction addAction = new AddAccountAction();
        addAction.testAdd(params, driver);
    }

    /**
     * 动作：第一次发送邮件
     */
    @Test(priority = 2,enabled = true)
    public void sendMail_1(){
        SendMailAction sendMailAction = new SendMailAction();
        sendMailAction.testDoSend(params, driver);
    }

    /**
     * 动作：在收件箱列表中，通过长按选中邮件，并删除
     * 验证：邮件删除成功
     */
    @Test(priority = 3, enabled = true)
    public void deleteMailInbox(){
        DeleteMailAction deleteMailAction = new DeleteMailAction();;
        deleteMailAction.deleteInboxPage(params, driver);
    }

    /**
     * 动作：再次发送新邮件
     */
    @Test(priority = 4,enabled = true)
    public void sendMail_2(){
        SendMailAction sendMailAction = new SendMailAction();
        sendMailAction.testDoSend(params, driver);
    }

    /**
     * 动作：在收件箱中，通过已发送的邮件标题，查找到邮件，并打开
     * 验证：截图验证邮件内容
     */
    @Test(priority = 5,enabled = true)
    public void checkMail(){
        CheckMailAction checkMailAction = new CheckMailAction();
        checkMailAction.testCheck(params, driver);

    }

    /**
     * 动作：在查看邮件内容的详情页面，点击删除按钮，删除邮件
     * 验证：邮件删除成功
     */
    @Test(priority = 6, enabled = true)
    public void deleteMail(){
            DeleteMailAction deleteMailAction = new DeleteMailAction();
            deleteMailAction.deleteInDetailPage(params, driver);
    }

    /**
     * 退出App，测试结束
     */
    @AfterClass
    public void cleanUp(){
        driver.quit();
        System.out.println("『测试结束』!!");
    }



    public static boolean isWindows() {
        return System.getProperty("os.name").toUpperCase().indexOf("WINDOWS")>=0?true:false;
    }




}
