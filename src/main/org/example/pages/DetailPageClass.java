package org.example.pages;

import org.example.helper.DropdownHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailPageClass extends PageBase {
    private WebDriver webDriver;
    public DetailPageClass(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }

    @FindBy(how = How.ID,using = "component")
    public WebElement componenet;
    @FindBy(how = How.ID,using = "version")
    public WebElement version;
    @FindBy(how = How.ID,using = "bug_severity")
    public WebElement severity;
    @FindBy(how = How.ID,using = "rep_platform")
    public WebElement hardware;

    @FindBy(how = How.ID,using = "op_sys")
    public WebElement os;
    @FindBy(how = How.ID,using = "short_desc")
    public WebElement summary;
    @FindBy(how = How.ID,using = "comment")
    public WebElement description;
    @FindBy(how = How.ID,using = "commit")
    public WebElement submitbug;

    public void provideDetails(String comp,String ver,String sever,String hard){
        DropdownHelper helper = DropdownHelper.getInstance(webDriver);
        helper.selectByValue(componenet, comp);
        helper.selectByValue(version, ver);
        helper.selectByValue(severity, sever);
        helper.selectByValue(hardware, hard);
    }

    public void provideOtherDetails(String operatingsys,String shortSummary,String comment){
        DropdownHelper helper = DropdownHelper.getInstance(webDriver);
        helper.selectByValue(os, operatingsys);
        summary.sendKeys(shortSummary);
        description.sendKeys(comment);
    }

    public PageBase clickSubmitBugButton(){
        BugSummaryPage summaryPage = new BugSummaryPage(webDriver);
        submitbug.click();
        new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(summaryPage.saveChanges));
        return summaryPage;
    }
}
