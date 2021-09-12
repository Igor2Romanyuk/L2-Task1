package forms;

import Utils.RandomUtils;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.awt.*;
import java.awt.event.KeyEvent;

public class WelcomePage extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private Browser browser = AqualityServices.getBrowser();

    public WelcomePage(By locator, String name) {
        super(locator, name);
    }

    public void clickNext() {
        ILink link = elementFactory.getLink(By.xpath("//div[@id='app']//a[@class='start__link']"), "Click HERE");
        link.click();
    }

    public void sendLoginForm() {
        ITextBox password = elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Choose Password']"), "Password");
        password.clearAndType(RandomUtils.createPassword());

        ITextBox email = elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Your email']"), "Email");
        email.clearAndType(RandomUtils.createString());

        ITextBox domain = elementFactory.getTextBox(By.xpath("//div[@id='app']//input[@placeholder='Domain']"), "Domain");
        domain.clearAndType(RandomUtils.createString());

        IButton dropdownList = elementFactory.getButton(By.xpath("//div[@id='app']//div[@class='dropdown__header']"), "Com");
        dropdownList.click();
        IButton dropdownList2 = elementFactory.getButton(By.xpath("//div[@id='app']//div[@class='dropdown__list']/div[" + (int) (1 + Math.random() * 10) + "]"), "Dropdown");
        dropdownList2.click();

        ICheckBox conditions = elementFactory.getCheckBox(By.xpath("//div[@id='app']//span[@class='checkbox__box']"), "Conditions");
        conditions.click();

        IButton secondary = elementFactory.getButton(By.xpath("//div[@id='app']//a[@class='button--secondary']"), "Secondary");
        secondary.click();
        browser.waitForPageToLoad();
    }

    public void sendInterestsForm() {
        RandomUtils.createInterests();

        ILink uploadImage = elementFactory.getLink(By.xpath("//div[@id='app']/div/div[2]/div[4]/div/div[1]/div/div[2]/div/div[2]/p/a"), "Link \"Upload image\"");
        uploadImage.click();

        try {
            uploadImage.state().waitForNotDisplayed();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void hideHelpWindow() {
        IButton hideHelpWindowButton = elementFactory.getButton(By.xpath("//div[@id='app']//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "Hide the Help window button");
        hideHelpWindowButton.click();
        hideHelpWindowButton.state().waitForNotDisplayed();
    }

    public void acceptTheTermsOfUseCookies() {
        IButton acceptCookies = elementFactory.getButton(By.xpath("//div[@id='app']//button[@class='button button--solid button--transparent']"), "Accept the terms of use of Cookies Button");
        acceptCookies.click();
    }

    public String getCounter() {
        ILabel counter = elementFactory.getLabel(By.xpath("//div[@id='app']//div[@class='timer timer--white timer--center']"), "Accept the terms of use of Cookies Button");
        return counter.getText();
    }
}
