package com.JWS.QAAutomationTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        strict = true,
        features = "classpath:feature",
        glue = "com.JWS.QAAutomationTest.StepDefinitions",
        tags = { "@auth"},
        plugin = {
                "pretty",
                "html:/Users/diandrair/Documents/JWSExam/"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
