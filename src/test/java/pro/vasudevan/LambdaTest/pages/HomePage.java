package pro.vasudevan.LambdaTest.pages;

import pro.vasudevan.base.ElementBase;
import pro.vasudevan.misc.Common;

import java.util.List;

/*
Created By: Vasudevan Sampath

HomePage.java has home page specific methods. Uses POM (Page object model) test design pattern
 */
public class HomePage extends ElementBase {

    public List<String> getHomePageLinks() throws InterruptedException {
        Common.sleep(2000);
        return findElements("homepage.horizontalLinks")
                .parallelStream()
                .map(e -> e.getText().split("\n")[0].trim()).toList();
    }

    public List<String> getHomePageVerticalLinks() throws InterruptedException {
        Common.sleep(2000);
        findElement("homepage.myAccountLink").click();
        Common.sleep(2000);
        return findElements("homepage.verticalLinks")
                .parallelStream()
                .map(e -> e.getText().trim()).toList();
    }
}
