package example.pages.menu;

import example.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class NewCasePageClass extends PageBase {
    private final WebDriver webDriver;
    public NewCasePageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }
}
