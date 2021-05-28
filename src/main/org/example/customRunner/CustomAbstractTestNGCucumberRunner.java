package org.example.customRunner;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomAbstractTestNGCucumberRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        Object[][] data= testNGCucumberRunner.provideScenarios();
        PickleWrapper pickleWrappers= (PickleWrapper) data[0][0];
        FeatureWrapper featureWrapper= (FeatureWrapper) data[0][1];
        return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
    }

    //data[0][0] ->> PickleWrapper    (scenarios)
    //data[0][1] ->> FeatureWrapper   (feature files)

    private void filterTheFeature(Object[][] data){
        List<String> featureList= Arrays.asList("Web Element Function");
        ArrayList<Object[]> modifiedListToExecute= new ArrayList<>();


    }

    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }
}
