package pro.vasudevan.LambdaTest.pages;

import pro.vasudevan.LambdaTest.base.TestBase;
import pro.vasudevan.misc.Common;

/*
Created By: Vasudevan Sampath

LoginPage.java has login page specific methods. Uses POM (Page object model) test design pattern
 */
public class LoginPage extends TestBase {

    public void doLogin(String userid, String password) throws InterruptedException {
        findElement("homepage.myAccountLink").click();
        Common.sleep(2000);
        findElement("loginpage.userName").sendKeys(userid);
        findElement("loginpage.password").sendKeys(password);
        findElement("loginpage.loginButton").click();
    }

    public boolean isLoginSuccessful() throws InterruptedException {
        Common.sleep(2000);
        return findElement("welcomepage.editYourAccountInfo").isDisplayed();
    }

    public String getActualFailedLoginMessage() throws InterruptedException {
        Common.sleep(2000);
        return findElement("loginpage.failedLogin").getText().trim();
    }
}
