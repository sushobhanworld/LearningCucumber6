package org.example.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class GenericHelper {
    private static GenericHelper genericHelper;
    private static WebDriver webDriver;

    private GenericHelper(WebDriver driver){
        webDriver=driver;
    }

    public static GenericHelper getInstance(WebDriver driver){
        if(genericHelper==null || webDriver.hashCode() != driver.hashCode())
            genericHelper= new GenericHelper(driver);
        return genericHelper;
    }

    public void takeScreenshot(String aDir, String bFileName){
        File directory= new File(aDir);
        if(!directory.exists())
            directory.mkdirs();

        File screenshot= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir")+File.separator+aDir+File.separator+bFileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] takeScreenshot(){
        byte[] screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
