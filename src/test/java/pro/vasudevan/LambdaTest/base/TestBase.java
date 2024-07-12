package pro.vasudevan.LambdaTest.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pro.vasudevan.base.ElementBase;
import static pro.vasudevan.config.IWebDriverConfig.*;

/*
Created By: Vasudevan Sampath

TestBase.java has methods to initialize WebDriver and also initializes object repository
 */
public class TestBase extends ElementBase {

    @BeforeSuite(alwaysRun = true)
    public void initSuite() throws Exception {
        initObjectRepo();
    }

    @BeforeTest(alwaysRun = true)
    public void initTest(ITestContext testContext) throws InterruptedException {
        initDriver(testContext);
    }

    @AfterTest(alwaysRun = true)
    public void cleanup() {
        tearDown();
    }
}
