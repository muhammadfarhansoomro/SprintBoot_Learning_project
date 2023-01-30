package com.example.selenium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "html:results/cucumber-reports.html", "json:results/cucumber.json", "junit:results/cucumber.xml"},
        glue = "com.example.selenium"
        ,tags = "@Int")
public class TestRunner {
//Farhan
}

//https://cucumber.io/docs/cucumber/api/?lang=java
//@CucumberOptions(tags = {"@foo and not @bar"})
//@CucumberOptions(tags = "@smoke and @fast")
//(@smoke or @ui) and (not @slow)
//@gui or @database
//@smoke and @fast
//@wip and not @slow
/*
mvn exec:java                                  \
    -Dexec.classpathScope=test                 \
    -Dexec.mainClass=io.cucumber.core.cli.Main \
    -Dexec.args="/path/to/your/feature/files --glue hellocucumber --glue anotherpackage"
 */
