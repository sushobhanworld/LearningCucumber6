package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterBugClass extends PageBase{

    private WebDriver webDriver;

    public EnterBugClass(WebDriver driver){
        super(driver);
        this.webDriver= driver;
    }

    @FindBy(how = How.XPATH,using = "//a[text()='Testng']")
    public WebElement testnglink;
    @FindBy(how = How.XPATH,using = "//a[text()='TestProduct']")
    public WebElement testproductlink;

    public PageBase clickTestngLink(){
        DetailPageClass detailPage = new DetailPageClass(webDriver);
        testnglink.click();
        new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(detailPage.submitbug));
        return detailPage;
    }
}
