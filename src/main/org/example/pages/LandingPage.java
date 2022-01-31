package example.pages;

import example.Utilities.TestUtility;
import example.init.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseClass
{
    @FindBy(how = How.XPATH, using = "//*[@id='navbar-collapse']/ul/li[2]/a")
    public WebElement signUp;

    public LandingPage()
    {
        super();
        PageFactory.initElements(driver, this);
    }
    public Register SignUP() {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        org.example.Utilities.JavaScriptUtilities.HighLightElementByJavaScript(signUp, driver);
        TestUtility.ClickOn(driver, signUp, 20);
        return new Register();
    }
}
