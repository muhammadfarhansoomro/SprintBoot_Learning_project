package com.example.selenium.steps;

import com.example.selenium.helpers.GenericHelper;
import com.example.selenium.pages.ResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultsSteps {

    @Autowired
    private ResultsPage resultsPage;

    @Autowired
    private GenericHelper genericHelper;

    @Then("^the links are displayed on the results page$")
    public void theLinksAreDisplayedOnTheResultsPage() {
        resultsPage.assertLinksArea();
    }

    @And("I will verify if the Results Page contain {string}")
    public void iWillCheckIfTheResultsPageContain(String s) {
        assertTrue(genericHelper.verifyPageContent(s), "Verification status");
    }
}
