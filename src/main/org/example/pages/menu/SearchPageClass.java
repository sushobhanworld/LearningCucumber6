package example.pages.menu;

import example.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class SearchPageClass extends PageBase {
    private WebDriver webDriver;
    public SearchPageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }
}
