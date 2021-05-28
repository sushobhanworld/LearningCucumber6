package org.example.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHelper {
    private static WebDriver webDriver;
    private static DropdownHelper dropdownHelper;

    private DropdownHelper(WebDriver driver){
        webDriver=driver;
    }

    public static DropdownHelper getInstance(WebDriver driver){
        if(dropdownHelper==null || driver.hashCode() != webDriver.hashCode())
            dropdownHelper= new DropdownHelper(driver);
        return dropdownHelper;
    }

    public void selectByVisibleText(By locator,String visibleValue){
        Select select = new Select(webDriver.findElement(locator));
        select.selectByVisibleText(visibleValue);
    }

    public void selectByIndex(By locator,int index){
        Select select = new Select(webDriver.findElement(locator));
        select.selectByIndex(index);

    }

    public void selectByValue(By locator, String valueAttribute){
        Select select = new Select(webDriver.findElement(locator));
        select.selectByValue(valueAttribute);
    }

    public void selectByValue(WebElement element, String valueAttribute){
        Select select = new Select(element);
        select.selectByValue(valueAttribute);
    }

    public List<WebElement> getAllValues(By locator){
        Select select = new Select(webDriver.findElement(locator));
        return select.getOptions();
    }
}
