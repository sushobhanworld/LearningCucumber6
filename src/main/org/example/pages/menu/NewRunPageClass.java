package example.pages.menu;

import example.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class NewRunPageClass extends PageBase {
    private WebDriver webDriver;
    public NewRunPageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }
}
