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
public class HomePage implements BasePage {
    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private GenericHelper genericHelper;

    @FindBy(how = How.ID, using = ConstantsHelper.searchInput) //"#search_form_input_homepage")
    private WebElement searchInput;

    @FindBy(how = How.ID, using = ConstantsHelper.searchButton)
    private WebElement searchButton;

    public HomePage() {
    }


    public void inputSearch(String search) {
        visibilityHelper.waitForVisibilityOf(searchInput);
        genericHelper.getPageResponseTime();
//        genericHelper.inputText = search;
//        searchInput.sendKeys(genericHelper.inputText);
        searchInput.sendKeys(search);
    }

    public void executeSearch() {
        if (TRUE.equals(genericHelper.checkIfElementExists(ConstantsHelper.searchButton))) {
            searchButton.click();}else{genericHelper.pressEnter(searchInput);}
    }
}