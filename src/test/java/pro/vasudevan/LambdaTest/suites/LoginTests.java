package pro.vasudevan.LambdaTest.suites;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pro.vasudevan.LambdaTest.base.TestBase;
import pro.vasudevan.LambdaTest.pages.LoginPage;
import pro.vasudevan.testdataframework.interfaces.TestData;
import pro.vasudevan.testdataframework.util.CSVTestDataProvider;

import java.util.Map;
import java.util.UUID;

/*
Created By: Vasudevan Sampath

LoginTests.java has login page specific test methods
 */
public class LoginTests extends TestBase {

    private LoginPage loginPage = null;
    private String loginId, password;

    @BeforeClass(alwaysRun = true)
    public void initClass(ITestContext testContext) {
        loginPage = new LoginPage();
        loginId = testContext.getCurrentXmlTest().getLocalParameters().get("loginId");
        password = testContext.getCurrentXmlTest().getLocalParameters().get("password");
    }

    @Test(priority = 2, dataProvider = "TestDataProvider", dataProviderClass = CSVTestDataProvider.class)
    @TestData(file = "FailedLogin.csv")
    public void verifyFailedLoginTest(Map<String, Object> map) throws InterruptedException {
        loginPage.doLogin(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        Assert.assertEquals(loginPage.getActualFailedLoginMessage(), map.get("failedLoginMessage"));
    }

    @Test(priority = 3)
    public void verifyValidLoginTest() throws InterruptedException {
        loginPage.doLogin(loginId, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed with User Id: " + loginId + " and Password: " + password);
    }
}
