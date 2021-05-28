package org.example.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CustomFireFoxDriver implements BrowserConfiguration{

    private FirefoxOptions getFirefoxOptions(){
        FirefoxOptions firefoxOptions= new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        return firefoxOptions;
    }

    public WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions= getFirefoxOptions();
        FirefoxDriver firefoxDriver= new FirefoxDriver(firefoxOptions);
        return firefoxDriver;
    }
    @Override
    public WebDriver getBrowserDriver() {
        return getFirefoxDriver();
    }
}
