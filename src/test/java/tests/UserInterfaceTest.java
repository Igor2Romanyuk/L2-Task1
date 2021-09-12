package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import forms.WelcomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInterfaceTest extends BaseTest {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private WelcomePage welcomePage = new WelcomePage(By.xpath("//div[@id='app']//a[@class='start__link']"), "Welcome page");

    @Test
    public void testCase1() {
        Assert.assertTrue(elementFactory.getButton(welcomePage.getLocator(), "Unique element").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.clickNext();

        Assert.assertTrue(elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Choose Password']"), "Password").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.sendLoginForm();

        Assert.assertTrue(elementFactory.getLabel(By.xpath("//div[@id='app']//div[@class='avatar-and-interests']"), "Avatar and interests form").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.sendInterestsForm();
    }

    @Test
    public void testCase2() {
        Assert.assertTrue(elementFactory.getButton(welcomePage.getLocator(), "Unique element").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.clickNext();

        Assert.assertTrue(elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Choose Password']"), "Password").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.hideHelpWindow();

        Assert.assertFalse(elementFactory.getTextBox(By.xpath("//div[@id='app']//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "Hide the Help window button").state().isDisplayed(), "The Help window is not hidden");
    }

    @Test
    public void testCase3() {
        Assert.assertTrue(elementFactory.getButton(welcomePage.getLocator(), "Unique element").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.clickNext();

        Assert.assertTrue(elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Choose Password']"), "Password").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.acceptTheTermsOfUseCookies();

        Assert.assertFalse(elementFactory.getTextBox(By.xpath("//div[@id='app']//button[@class='button button--solid button--transparent']"), "Hide the Help window button").state().isDisplayed(), "The Help window is not hidden");
    }

    @Test
    public void testCase4() {
        Assert.assertTrue(elementFactory.getButton(welcomePage.getLocator(), "Unique element").state().isExist(), "The page is not loaded or another page is loaded");

        welcomePage.clickNext();

        Assert.assertTrue(elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Choose Password']"), "Password").state().isExist(), "The page is not loaded or another page is loaded");
        
        Assert.assertEquals(welcomePage.getCounter(), "00:00:00");
    }
}
