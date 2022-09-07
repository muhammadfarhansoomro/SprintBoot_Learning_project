package com.example.selenium.pages;


import com.example.selenium.helpers.ConstantsHelper;
import com.example.selenium.helpers.GenericHelper;
import com.example.selenium.helpers.VisibilityHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;

@Component
public class DealerCockpit_Login_1 implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;
    private GenericHelper genericHelper;

    @FindBy(how = How.ID, using = ConstantsHelper.usernameInput) //"#search_form_input_homepage")
    private WebElement usernameInput;

    @FindBy(how = How.ID, using = ConstantsHelper.passwordInput) //"#search_form_input_homepage")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = ConstantsHelper.loginButton)
    private WebElement loginButton;


    public void inputUsername(String username) {
        visibilityHelper.waitForVisibilityOf(usernameInput);
        genericHelper.inputText = username;
        usernameInput.sendKeys(genericHelper.inputText);
    }

    public void inputPassword(String password) {
        visibilityHelper.waitForVisibilityOf(passwordInput);
        genericHelper.inputText = password;
        passwordInput.sendKeys(genericHelper.inputText);
    }

    public void pressLoginButton() {
        visibilityHelper.waitForVisibilityOf(loginButton);
        if (TRUE.equals(loginButton.isEnabled())) genericHelper.clickElement(loginButton);
    }
}
