package com.example.selenium.steps;

import com.example.selenium.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;

import static org.junit.Assert.assertEquals;

public class HomeSteps {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Autowired
    private HomePage homePage;

    @Given("^I search \"([^\"]*)\" in the search input of the home page$")
    public void iSearchInTheSearchInputOfTheHomePage(String search) throws InterruptedException {
//        assertEquals("Assertion Results", search, "Farhan");
        homePage.inputSearch(search);
    }

    @When("^I press the search button in the home page$")
    public void iPressTheSearchButtonInTheHomePage() {
        homePage.pressEnter();
    }
}
