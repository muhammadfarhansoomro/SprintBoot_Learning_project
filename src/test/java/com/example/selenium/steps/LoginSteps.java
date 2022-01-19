package com.example.selenium.steps;

import com.example.selenium.pages.DealerCockpit_Login;
import com.example.selenium.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Autowired
    private DealerCockpit_Login loginPage;

    @Given("a valid User with username \"([^\"]*)\" and password  \"([^\"]*)\" logs into Dealercockpit application$")
    public void ilogintotheapplication(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.pressLoginButton();
    }

    @Given("a valid User with username <User> and password <Password> logs into Dealercockpit application")
    public void aValidUserWithUsernameUserAndPasswordPasswordLogsIntoDealercockpitApplication() {
    }
}
