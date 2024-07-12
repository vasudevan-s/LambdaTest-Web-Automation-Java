package pro.vasudevan.LambdaTest.suites;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pro.vasudevan.LambdaTest.base.TestBase;
import pro.vasudevan.LambdaTest.pages.HomePage;
import pro.vasudevan.testdataframework.interfaces.TestData;
import pro.vasudevan.testdataframework.util.CSVTestDataProvider;

import java.util.*;

/*
Created By: Vasudevan Sampath

HomePageTests.java has home page specific test methods
 */
public class HomePageTests extends TestBase {

    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void initClass(ITestContext testContext) {
        homePage = new HomePage();
    }

    @Test(priority = 0, dataProvider = "TestDataProvider", dataProviderClass = CSVTestDataProvider.class)
    @TestData(file="HomePageHorizontalLinks.csv", rowDataDelimiter = ";")
    public void verifyForThePresenceOfHomePageLinksTest(Map<String, Object> map) throws InterruptedException {
        Assert.assertEquals(homePage.getHomePageLinks(), map.values());
    }

    @Test(priority = 1, dataProvider = "TestDataProvider", dataProviderClass = CSVTestDataProvider.class)
    @TestData(file="HomePageVerticalLinks.csv", firstRowColumnNames = false)
    public void verifyForThePresenceOfHomePageVerticalLinksTest(Map<String, Object> map) throws InterruptedException {
        Assert.assertEquals(homePage.getHomePageVerticalLinks(), map.values());
    }
}