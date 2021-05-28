package org.example.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.helper.ButtonHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MultipleWindowHandling {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        ButtonHelper buttonHelper= ButtonHelper.getInstance(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://www.w3schools.com/html/default.asp");
        WebDriverWait wait= new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div[4]/a")));
        buttonHelper.click(By.xpath("//*[@id='main']/div[4]/a"));

        WebDriverWait wait1= new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> windowIds= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowIds.get(1));

        WebDriverWait wait2= new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome")));
        buttonHelper.click(By.id("tryhome"));
        System.out.println("done");
    }
}
