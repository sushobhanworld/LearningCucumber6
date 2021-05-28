package org.example.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonHelper {
    private static ButtonHelper buttonHelper;
    private static WebDriver webDriver;

    public ButtonHelper(WebDriver driver) {
        webDriver= driver;
    }

    public static ButtonHelper getInstance(WebDriver driver){
        if((buttonHelper==null) || webDriver.hashCode()!=driver.hashCode())
                buttonHelper= new ButtonHelper(driver);
        return buttonHelper;
    }
    public void click(By locator){
        webDriver.findElement(locator).click();
    }
}
