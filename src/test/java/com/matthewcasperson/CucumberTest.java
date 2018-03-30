package com.matthewcasperson;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.matthewcasperson.decoratorbase")
public class CucumberTest {
}
