package org.example.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Utilities.IReader;
import org.example.Utilities.ReadConfigProperties;
import org.example.browser.BrowserConfiguration;
import org.example.browser.CustomChromeDriver;
import org.example.browser.CustomFireFoxDriver;
import org.example.helper.ButtonHelper;
import org.example.helper.DropdownHelper;
import org.example.helper.GenericHelper;
import org.example.helper.WindowHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverService {
    private WebDriver webDriver;
    private BrowserConfiguration browserConfiguration;
    private ButtonHelper buttonHelper;
    private WindowHelper windowHelper;
    private IReader iReader;
    private GenericHelper genericHelper;
    private DropdownHelper dropdownHelper;

    public GenericHelper getGenericHelper() {
        return genericHelper;
    }

    public BrowserConfiguration getBrowserConfiguration() {
        return browserConfiguration;
    }

    public IReader getiReader() {
        return iReader;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public ButtonHelper getButtonHelper() {
        return buttonHelper;
    }

    public WindowHelper getWindowHelper() {
        return windowHelper;
    }

    public DropdownHelper getDropdownHelper(){
        return dropdownHelper;
    }

    public void launchBrowser(){
        iReader= new ReadConfigProperties();
        webDriver= getBrowserSpecificDriver();
        buttonHelper= ButtonHelper.getInstance(webDriver);
        windowHelper= WindowHelper.getInstance(webDriver);
        dropdownHelper= DropdownHelper.getInstance(webDriver);
        webDriver.get("https://www.google.com");
        genericHelper= GenericHelper.getInstance(webDriver);
        genericHelper.takeScreenshot("ScreenShots","abc");
    }

    public DriverService(){
        launchBrowser();
    }

    private WebDriver getBrowserSpecificDriver() {
        switch (iReader.getBrowserType()){
            case BrowserType.CHROME:
                browserConfiguration= new CustomChromeDriver();
                return browserConfiguration.getBrowserDriver();
            case BrowserType.FIREFOX:
               WebDriverManager.firefoxdriver().setup();
               browserConfiguration= new CustomFireFoxDriver();
               return browserConfiguration.getBrowserDriver();
            default:
                throw new RuntimeException("Invalid browser type: "+iReader.getBrowserType());
        }
    }

    public static void main(String[] args) {
        new DriverService();
    }
}
