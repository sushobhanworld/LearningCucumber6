package example.pages;

import org.example.pages.factory.CustomFactory;
import org.example.pages.factory.PageName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    private final WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH,using = "//div[@id='header']/ul[1]/li[11]/a")
    public WebElement logout;
    @FindBy(how = How.XPATH,using = "//a[text()='Home']")
    public WebElement home;
    @FindBy(how = How.XPATH,using = "//a[text()='New']")
    public WebElement newLink;

    public PageBase logoutFromApplication(){
        logout.click();
        org.example.pages.HomePageClass homePageClass= new org.example.pages.HomePageClass(driver);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(homePageClass.fileABuglink));
        return homePageClass;
    }

    public PageBase navigateTo(PageName pageName, WebDriver driver1, WebElement element){
        new WebDriverWait(driver1, 30).until(ExpectedConditions.visibilityOf(element));
        return CustomFactory.getInstance(pageName, driver1);
    }
}
