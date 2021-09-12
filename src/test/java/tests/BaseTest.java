package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private Browser browser;

    @BeforeMethod
    protected void beforeMethod() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo("https://userinyerface.com/game.html%20target=");
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void afterTest() {
        if (browser.isStarted()){
            browser.quit();
        }
    }

}
