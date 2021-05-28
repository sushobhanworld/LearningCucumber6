package org.example.runner;

import io.cucumber.testng.CucumberOptions;
import org.example.customRunner.CustomAbstractTestNGCucumberRunner;

@CucumberOptions(
        features = {"src/main/org/example/pages"},
        glue = {"org.example.pages"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","json:target/customgenericrunner.json"}
)
public class CustomGenericRunner extends CustomAbstractTestNGCucumberRunner {

}
