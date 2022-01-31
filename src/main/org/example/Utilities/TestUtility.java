package example.Utilities;

import example.init.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class TestUtility extends BaseClass {
    //Set Date For Log4J.
    public static void setDateForLog4j() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
        System.setProperty("current_date", dateFormat.format(new Date()));
        //PropertyConfigurator.configure("./src/main/resources/log4j.properties");
        // Property
    }

    //Take screenshot
    public static String TakeScreeshotForFailedTestCases(String name, WebDriver driver) throws IOException {
        String date = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fileSRC = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File fileDestination = new File(System.getProperty("user.dir") + "/FailedTest/" + name + date + ".png");
        FileUtils.copyFile(fileSRC, fileDestination);
        return System.getProperty("user.dir") + "/FailedTest/" + name + date + ".png";
    }

    //To Take Screenshot at End Of Test
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
    }

    //Click on element
    public static void ClickOn(WebDriver driver, WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //Explicit Wait to Send Data to WebElement.
    public static void SendKeys(WebDriver driver, WebElement element, int timeout, String value) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    //Explicit Wait for Element To Be Visible.
    public static void WaitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Switch to window
    public static void SwitchWindow(WebDriver driver) {
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        for (String childWindow : windows) {
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    //To Check Element is Displayed or No.
    public static void isElementDisplayed(WebElement element) {
        boolean elementDisplayed = element.isDisplayed();
        if (elementDisplayed) {
            System.out.println("Element is Displayed");
        } else {
            System.out.println("Element is not Displayed");
        }
    }

    //To Check Element is Enabled or No.
    public static void isElementEnabled(WebElement element) {
        boolean elementEnabled = element.isEnabled();
        if (elementEnabled) {
            System.out.println("Element is Enabled");
        } else {
            System.out.println("Element is not Enabled");
        }
    }

    //To Select a value from Drop Down by using SelectByVisibleText Method
    public static void SelectValueFromDropDownByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}
