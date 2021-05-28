package org.example.pages;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = {"src/main/org/example/pages/BugCreation.feature"},
        glue = {"org.example.pages","org.example.generichook"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","junit:target/junitReport/junitreport.xml"}
)
public class BugCreationRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

}

