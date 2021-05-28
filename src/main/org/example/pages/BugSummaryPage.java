package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BugSummaryPage extends PageBase{
    private WebDriver webDriver;
    public BugSummaryPage(WebDriver driver) {
        super(driver);
        this.webDriver=driver;
    }

    @FindBy(how = How.ID,using = "commit")
    public WebElement saveChanges;
    @FindBy(how=How.ID,using= "comment")
    public WebElement additionalcomments;
    @FindBy(how=How.ID,using = "bug_status")
    public WebElement bugstatus;
}
