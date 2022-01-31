package example.pages;

import example.init.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Register extends BaseClass
{
    @FindBy(how = How.ID, using = "email")
    public WebElement EmailElement;

    @FindBy(how = How.ID, using = "phone_number")
    public WebElement PhoneNumberElement;

    public Register()
    {
        super();
        PageFactory.initElements(driver, this);
    }

    public void RegisterCRM(String email, String phoneNumber)
    {
        EmailElement.sendKeys(email);
        PhoneNumberElement.sendKeys(phoneNumber);
    }
}
