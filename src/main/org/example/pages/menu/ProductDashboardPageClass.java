package example.pages.menu;

import example.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class ProductDashboardPageClass extends PageBase {
    private WebDriver webDriver;
    public ProductDashboardPageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }
}
