package Utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomUtils {
    public static String createPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random( 15, characters );
    }

    public static String createString() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random( (int) (3 + Math.random() * 10), characters );
    }

    public static void createInterests() {
        ArrayList list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
        int lit;
        ICheckBox checkBoxInterests;
        IElementFactory elementFactory = AqualityServices.getElementFactory();
        while (list.size() > 3) {
            lit = (int) (Math.random() * (21 - 1) + 1);
            if (list.contains(lit)){
                checkBoxInterests = elementFactory.getCheckBox(By.xpath("//div[@id='app']//div[@class='avatar-and-interests__interests-list']/div[" + lit + "]//span"), "Interests");
                checkBoxInterests.click();
                list.remove((Object) lit);
            }
        }
    }
}
