package example.gerichook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import example.services.DriverService;
import org.openqa.selenium.WebDriver;

public class GeneralHook {
    //Inject driver service here in constructor
    private final WebDriver webDriver;
    private final DriverService driverService;

    public GeneralHook(DriverService driverService){
        this.driverService=driverService;
        webDriver= driverService.getWebDriver();
    }

    @Before(value = "@smoke")
    public void setUpForSmoke(){
        System.out.println("Smoke suite");
    }

    @Before(value = "@regression")
    public void setUpForRegression(){
        System.out.println("Regression suite");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed())
            captureScreenShot(scenario);
        if(webDriver!=null)
            webDriver.quit();
    }

    private void captureScreenShot(Scenario scenario) {
        int random = (int)(Math.random() * 1000);
        driverService.getGenericHelper().takeScreenshot("Screenshot", "src" + random +".png");
        scenario.attach(driverService.getGenericHelper().takeScreenshot(),"Snapshot","image.png");
    }
}
