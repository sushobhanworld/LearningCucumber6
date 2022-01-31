package example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageClass extends example.pages.PageBase {
    private final WebDriver webDriver;

    public LoginPageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }

    @FindBy(how = How.ID,using = "Bugzilla_login")
    public WebElement username;
    @FindBy(how = How.ID,using = "Bugzilla_password")
    public WebElement password;
    @FindBy(how = How.ID,using = "log_in")
    public WebElement loginButton;

    public example.pages.PageBase login(String user, String pass){
        org.example.pages.EnterBugClass enterBugClass= new org.example.pages.EnterBugClass(webDriver);
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(enterBugClass.testnglink));
        return enterBugClass;
    }
}
