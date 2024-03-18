package com.example.selenium.pages;

import com.example.selenium.helpers.VisibilityHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage{

    private static final String LINKS_AREA_LOCATOR = "#links_wrapper";

    @Autowired
    private VisibilityHelper visibilityHelper;

    public void assertLinksArea(){
        visibilityHelper.waitForPresenceOf(By.cssSelector(LINKS_AREA_LOCATOR));
    }
}