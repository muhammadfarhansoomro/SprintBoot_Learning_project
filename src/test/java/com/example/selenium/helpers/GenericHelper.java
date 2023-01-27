package com.example.selenium.helpers;

import com.example.selenium.runners.Hook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

public class GenericHelper {

    @Autowired
    private Hook hooks;

    WebDriver driver;

    public String loginName;
    public String password;

    Calendar cal;
    Alert alert;

    JavascriptExecutor js;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void scrollToElement(WebElement selector) {
        ((JavascriptExecutor) hooks.getDriver()).executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"center\"});", selector);
    }
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

    public void switchToActiveTab() {
        String currentHandle = hooks.getDriver().getWindowHandle();
        Set<String> handles = hooks.getDriver().getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
//Switch to the opened tab
                hooks.getDriver().switchTo().window(actual);
            }
        }
    }

    public String getPageTitle() {
        String pageTitle = hooks.getDriver().getTitle();
        return pageTitle;
    }

    public void switchTabs(int tabId) {
        ArrayList<String> newTab = new ArrayList<String>(hooks.getDriver().getWindowHandles());
        String oldTab = hooks.getDriver().getWindowHandle();
        newTab.remove(oldTab);
        hooks.getDriver().switchTo().window(newTab.get(tabId));
    }

    public String getElementText(String selector, String type) {
        String elementText = null;
        if (type.equals("XPATH")) {
            elementText = hooks.getDriver().findElement(By.xpath(selector)).getText();
        } else if (type.equals("CSS")) {
            elementText = hooks.getDriver().findElement(By.cssSelector(selector)).getText();
        } else if (type.equals("ID")) {
            elementText = hooks.getDriver().findElement(By.id(selector)).getText();
        } else if (type.equals("NAME")) {
            elementText = hooks.getDriver().findElement(By.name(selector)).getText();
        }
        return elementText;
    }

    public String getElementText(WebElement e) {
        String elementText = e.getText();
        return elementText;
    }

    /*
    public BooleanAssert assertThat(String expectedVal, String actualVal){
       BooleanAssert result = softAssertions.assertThat(actualVal.equals(expectedVal));
       softAssertions.assertAll();
       return result;
    }
    */
    public void DragDropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        if (WrapsElement.class.isAssignableFrom(target.getClass())) {
            driver = ((WrapsDriver) ((WrapsElement) target).getWrappedElement()).getWrappedDriver();
        } else
            driver = ((WrapsDriver) target).getWrappedDriver();

//        WebDriver driver = hooks.getDriver();//((org.openqa.selenium.remote.RemoteWebElement)target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));
    }

    public void inputText(WebElement e, String text) {
        e.sendKeys(text);
    }

    public void pressEnterKey(WebElement e) {
        e.sendKeys(Keys.ENTER);
    }

    public void pressTabKey(WebElement e) {
        e.sendKeys(Keys.TAB);
    }

    public void javascriptClicker(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) hooks.getDriver();
        js.executeScript("arguments[0].click();", e);
    }

    public void enterText(WebElement e, String text) {
        e.sendKeys(text);
    }

    public void selectDropDownValue(WebElement e, String text) {
        Select drpdn = new Select(e);
        drpdn.selectByValue(text);
    }

    public void selectDropDownId(WebElement e, String Id) {
        Select drpdn = new Select(e);
        drpdn.selectByIndex(Integer.parseInt(Id));
    }

    public void selectDropDownbyVisibleText(WebElement e, String text) {
        Select drpdn = new Select(e);
        drpdn.selectByVisibleText(text);
    }

    public int currentdateDay() {
        cal = Calendar.getInstance();
        cal.get(Calendar.DAY_OF_MONTH);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public int currentdateMonth() {
        cal = Calendar.getInstance();
        cal.get(Calendar.MONTH);
        return cal.get(Calendar.MONTH);
    }

    public int currentdateYear() {
        cal = Calendar.getInstance();
        cal.get(Calendar.YEAR);
        return cal.get(Calendar.YEAR);
    }

    public void deleteFieldData(WebElement e) {
        e.clear();
    }

    public void jsFocus() {
        js = (JavascriptExecutor) hooks.getDriver();
        js.executeScript("window.focus();");
    }

    public void focusedClick(WebElement element) {

        Actions action = new Actions(hooks.getDriver());
        hooks.getDriver().switchTo().activeElement();
        action.moveToElement(element).click().perform();
    }

    public void clickElementByClassName(WebElement e) {
        e.findElement(By.className("fp-select-confirm btn-primary btn")).getText();
    }

    public void acceptAlert() throws InterruptedException {
        alert = hooks.getDriver().switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
        Thread.sleep(5000);
        hooks.getDriver().switchTo().alert().accept();
    }

    public void dismissAlert() throws InterruptedException {
        alert = hooks.getDriver().switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
        Thread.sleep(5000);
        hooks.getDriver().switchTo().alert().dismiss();
    }


    public String selectNgReflectValue(String name) {
        return ("//*[@ng-reflect-value=\"" + name + "\"]");
    }


    public String selectNgReflectModel(String name) { //Farhan Starts here
        return ("//*[@ng-reflect-model=\"" + name + "\"]");
    }// Farhan Ends Here


    public void gotoURL(String URL) {
        hooks.getDriver().navigate().to(URL);
    }

    public void jsEnterKeys(WebElement e, String input) {
        js = (JavascriptExecutor) hooks.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + input + "')", e);
    }

    public void enterRepeatedCharacters(WebElement e, int noOfrepetition, String string) {
        for (noOfrepetition = 0; noOfrepetition < 100; noOfrepetition++) {
            e.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            e.sendKeys(Keys.chord(Keys.CONTROL, "c"));
            for (int i = 0; i < 10; i++) {
                e.sendKeys(Keys.chord(Keys.CONTROL, "v"));
            }
        }
    }

    public void verifyColor(WebElement e)
    {
        // Color Listing here: https://www.w3.org/TR/css-color-3/#html4
        final Color HEX_COLOUR = Color.fromString("#2F7ED8");
        final Color RGB_COLOUR = Color.fromString("rgb(255, 255, 255)");
        final Color RGB_COLOURPER = Color.fromString("rgb(40%, 20%, 40%)");
        final Color RGBA_COLOUR = Color.fromString("rgba(255, 255, 255, 0.5)");
        final Color RGBA_COLOURPER1 = Color.fromString("rgba(40%, 20%, 40%, 0.5)");
        final Color HSL_COLOUR = Color.fromString("hsl(100, 0%, 50%)");
        final Color HSLA_COLOUR = Color.fromString("hsla(100, 0%, 50%, 0.5)");
        final Color BLACK = Color.fromString("black");
        final Color CHOCOLATE = Color.fromString("chocolate");
        final Color HOTPINK = Color.fromString("hotpink");
        final Color TRANSPARENT = Color.fromString("transparent");

        Color ctrlColour = Color.fromString(e.getCssValue("color"));

        Color ctrlBackgroundColour = Color.fromString(e.getCssValue("background-color"));

        assert ctrlBackgroundColour.equals(HOTPINK);

        assert ctrlBackgroundColour.asHex().equals("#ff69b4");
        assert ctrlBackgroundColour.asRgba().equals("rgba(255, 105, 180, 1)");
        assert ctrlBackgroundColour.asRgb().equals("rgb(255, 105, 180)");
    }

}
