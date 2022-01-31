package example.pages.factory;


import example.pages.HomePageClass;
import example.pages.LoginPageClass;
import example.pages.PageBase;
import org.example.pages.EnterBugClass;
import org.example.pages.menu.NewRunPageClass;
import org.example.pages.menu.ProductDashboardPageClass;
import org.example.pages.menu.SearchPageClass;
import org.openqa.selenium.WebDriver;

public class CustomFactory {
    /** Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class instance
	 * Super Class - PageBase -> HomePageClass, LoginPageClass, EnterBugClass so on
	 * Navigation --> Based on input we need to have intance of corr page class
	 * */
    public static PageBase getInstance(example.pages.factory.PageName pageName, WebDriver driver){
        switch (pageName){
            case HomePage:
                return new HomePageClass(driver);
            case LoginPage:
                return new LoginPageClass(driver);
            case NewCasePage:
                return new org.example.pages.menu.NewCasePageClass(driver);
            case NewRunPage:
                return new NewRunPageClass(driver);
            case ProductDashboardPage:
                return new ProductDashboardPageClass(driver);
            case SearchPage :
                return new SearchPageClass(driver);
            case EnterBugPage :
                return new EnterBugClass(driver);

            default:
                throw new RuntimeException("Invalid Page Name");
        }
    }
}
