package com.example.selenium.pages;

import com.example.selenium.helpers.ConstantsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;


@Component
public class HomePage implements BasePage {


    @FindBy(how = How.CSS, using = ConstantsHelper.searchInput) //"#search_form_input_homepage")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = ConstantsHelper.searchButton)
    private WebElement searchButton;

    public HomePage() {
    }

    public void inputSearch(String search) {
        searchInput.sendKeys(search);
    }

    public void pressSearchButton() {
        if (TRUE.equals(searchButton.isEnabled())) searchButton.click();
    }
}