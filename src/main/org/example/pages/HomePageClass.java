package example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends PageBase {
    private final WebDriver webDriver;

    public HomePageClass(WebDriver driver){
        super(driver);
        this.webDriver=driver;
    }

    @FindBy(how = How.ID,using = "enter_bug")
    public WebElement fileABuglink;
    @FindBy(how = How.ID,using = "quicksearch_main")
    public WebElement quickSearchTextBox;

    public PageBase navigateToLoginPage(){
        LoginPageClass loginPageClass= new LoginPageClass(webDriver);
        fileABuglink.click();
        new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(loginPageClass.loginButton));
        return loginPageClass;
    }
}
