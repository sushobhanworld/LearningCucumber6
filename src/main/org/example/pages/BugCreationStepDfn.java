package org.example.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Utilities.TestSettings;
import org.example.pages.factory.CustomFactory;
import org.example.pages.factory.PageName;
import org.example.services.DriverService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BugCreationStepDfn {
    private WebDriver driver;
    private DriverService driverService;
    private TestSettings testSettings;

    public BugCreationStepDfn(DriverService driverService, TestSettings testSettings){
        this.driverService= driverService;
        this.testSettings= testSettings;
        this.driver= driverService.getWebDriver();
    }
    @Given("Bugzilla_I am at the Bugzilla home page")
    public void bugzilla_iAmAtTheBugzillaHomePage() {
        driver.get(driverService.getiReader().getApplicationURL());
    }

    @Then("Bugzilla_I click on File a bug link and navigate to login page")
    public void bugzilla_iClickOnFileABugLinkAndNavigateToLoginPage() {
        testSettings.loginPage= (LoginPageClass) testSettings.homepage.navigateToLoginPage();
    }

    @And("Bugzilla_The title of login page should be {string}")
    public void bugzilla_theTitleOfLoginPageShouldBe(String expected) {
        Assert.assertEquals(driver.getTitle(),expected);
    }

    @Then("Bugzilla_I log into the application and navigate to enter bug page")
    public void bugzilla_iLogIntoTheApplicationAndNavigateToEnterBugPage() {
        testSettings.enterBug= (EnterBugClass) testSettings.loginPage.login(driverService.getiReader().getUsername(),driverService.getiReader().getPassword());
    }

    @Then("Bugzilla_I click on testng link and navigate to bug detail page")
    public void bugzilla_iClickOnTestngLinkAndNavigateToBugDetailPage() {
        testSettings.detailPage= (DetailPageClass) testSettings.enterBug.clickTestngLink();
    }

    @And("Bugzilla_I provide the details as component as {string} version as {string} severity as {string} hardware as {string}")
    public void bugzilla_iProvideTheDetailsAsComponentAsVersionAsSeverityAsHardwareAs(String comp, String ver, String sever, String hard) {
        testSettings.detailPage.provideDetails(comp, ver, sever, hard);
    }

    @And("Bugzilla_I provide other details operating system as {string} summary as {string} and description as {string}")
    public void bugzilla_iProvideOtherDetailsOperatingSystemAsSummaryAsAndDescriptionAs(String operatingsys, String shortSummary, String comment) {
        testSettings.detailPage.provideOtherDetails(operatingsys, shortSummary, comment);
    }

    @And("Bugzilla_I click on submit bug button")
    public void bugzilla_iClickOnSubmitBugButton() {
        testSettings.bugSummaryPage = (BugSummaryPage) testSettings.detailPage.clickSubmitBugButton();
    }

    @And("Bugzilla_I am at the summary page and I click the logout button")
    public void bugzilla_iAmAtTheSummaryPageAndIClickTheLogoutButton() {
        testSettings.bugSummaryPage.logoutFromApplication();
    }

    @Then("Testproduct_I click on testng link and navigate to bug detail page")
    public void testproduct_iClickOnTestngLinkAndNavigateToBugDetailPage() {
        testSettings.detailPage = (DetailPageClass) testSettings.enterBug.clickTestngLink();
    }

    @And("Testproduct_I provide the details as component as {string} version as {string} severity as {string} hardware as {string}")
    public void testproduct_iProvideTheDetailsAsComponentAsVersionAsSeverityAsHardwareAs(String comp, String ver, String sever, String hard) {
        testSettings.detailPage.provideDetails(comp, ver, sever, hard);
    }

    @And("Testproduct_I provide other details operating system as {string} summary as {string} and description as {string}")
    public void testproduct_iProvideOtherDetailsOperatingSystemAsSummaryAsAndDescriptionAs(String operatingsys, String shortSummary, String comment) {
        testSettings.detailPage.provideOtherDetails(operatingsys, shortSummary, comment);
    }

    @And("Testproduct_I click on submit bug button")
    public void testproduct_iClickOnSubmitBugButton() {
        testSettings.bugSummaryPage= (BugSummaryPage) testSettings.detailPage.clickSubmitBugButton();
    }

    @And("Testproduct_I am at the summary page and I click the logout button")
    public void testproduct_iAmAtTheSummaryPageAndIClickTheLogoutButton() {
        testSettings.bugSummaryPage.logoutFromApplication();
    }

    @Then("Bugzilla_I navigate to Home page")
    public void bugzilla_iNavigateToHomePage() {

    }

    @Then("Bugzilla_I navigate to enter bug page")
    public void bugzilla_iNavigateToEnterBugPage() {
        testSettings.enterBug.newLink.click();
    }
}
