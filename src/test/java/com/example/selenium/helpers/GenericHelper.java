package com.example.selenium.helpers;

import org.openqa.selenium.WebElement;

public class GenericHelper {
    public String inputText;

    public String getInputText()
    {
        return inputText;
    }
    public void setInputText(String inputText)
    {
        this.inputText = inputText;
    }

    public void clickElement(WebElement e)
    {
        e.click();
    }
}
