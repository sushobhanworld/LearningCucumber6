package org.example.helper;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WindowHelper {
    private static WindowHelper windowHelper;
    private static WebDriver webDriver;

    private WindowHelper(WebDriver driver) {
        webDriver= driver;
    }

    public static WindowHelper getInstance(WebDriver driver){
        if(windowHelper==null || webDriver.hashCode() != driver.hashCode())
            windowHelper= new WindowHelper(driver);
        return windowHelper;
    }

    private List<String> getWindowIds(){
        ArrayList<String> windowIds= new ArrayList<>(webDriver.getWindowHandles());
        return Collections.unmodifiableList(windowIds);
    }

    public void switchToWindow(int index){
        if(index<0 || index> getWindowIds().size())
            throw new IllegalArgumentException("Index is not valid : "+index);
        webDriver.switchTo().window(getWindowIds().get(index));
    }

    public void switchToParent(){
        ArrayList<String> windowIds= new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(windowIds.get(0));
    }

    public void switchToParentWithClose(){
        ArrayList<String> windowIds= new ArrayList<>(webDriver.getWindowHandles());
        windowIds.forEach(w ->{
            webDriver.switchTo().window(w);
            webDriver.close();
        });
        switchToParent();
    }
}
