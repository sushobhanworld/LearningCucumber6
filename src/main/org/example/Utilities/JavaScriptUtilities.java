package org.example.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities
{
    public static JavascriptExecutor javascriptExecutor;

    public static void ChangeColorByJavaScript(String color, WebElement element, WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '"+color+ "'", element);
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //Highlight element by javascript
    public static void HighLightElementByJavaScript(WebElement element, WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        String backgroundColor= element.getCssValue("backgroundColor");
        for(int i=0; i<10;i++)
        {
            ChangeColorByJavaScript("rgb(0,200,0)", element, driver);
            ChangeColorByJavaScript(backgroundColor, element, driver);
        }
    }

    //To Draw a Border for WebElement using JavaScript Executor.
    public static void drawElementBorderByJavaScript(WebElement element, WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    //To Generate an Alert using JavaScript Executor.
    public static void generateAlertByJavaScript(WebDriver driver, String alertMessage)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("alert('" + alertMessage + "')");
    }

    //To Click on WebElement using JavaScript Executor.
    public static void clickElementByJavaScript(WebElement element, WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    //To Refresh Browser using JavaScript Executor.
    public static void refreshBrowserByJavaScript(WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("history.go(0)");
    }

    //To get Page title using JavaScript Executor
    public static void getPageTitleByJavaScript(WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        String pageTitle= javascriptExecutor.executeScript("return document.title;").toString();
        System.out.println("The title of the page is ::: "+pageTitle);
    }

    //To scroll down using JavaScript Executor
    public static void scrollDownPageByJavaScript(WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight");
    }

    //To Scroll into WebElement View using JavaScript Executor
    public static void scrollIntoElementByJavaScript(WebDriver driver, WebElement element)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //To Send Input Data to Text Field using JavaScript Executor
    public static void inputToTextFieldByJavaScript(WebDriver driver, WebElement element, String text)
    {
        javascriptExecutor= (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].value= '"+text+"'",element);
    }

    //To Get Page Inner Text using JavaScript Executor
    public static void getPageInnerTextByJavaScript(WebDriver driver)
    {
        javascriptExecutor= (JavascriptExecutor) driver;
        String pageText = javascriptExecutor.executeScript("return document.documentElement.innerText;").toString();
        System.out.println("The Text of the Page is ::: " +pageText);
    }
}
