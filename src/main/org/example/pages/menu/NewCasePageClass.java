package org.example.pages.menu;

import org.example.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class NewCasePageClass extends PageBase {
    private WebDriver webDriver;
    public NewCasePageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }
}
