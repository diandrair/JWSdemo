package com.JWS.QAAutomationTest.util;

import com.JWS.QAAutomationTest.AbstractBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

@Component
public class BrowserActions extends AbstractBasePage {

    public String getAttribute(WebElement element){
       return element.getAttribute("value");
    }

    public void select(WebElement element, String value){
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public void clickElement(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysToElement(WebElement element, String keys) {
        this.wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    }

    public void setKeyboardKey(WebElement element, Keys key) {
        this.wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
    }

    public void printElementText(WebElement element) {
        String text = this.wait.until(ExpectedConditions.visibilityOf(element)).getText();
        System.out.println("I am on '"+text+"' page");
    }

    public String getElementText(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void performRightClick(WebElement element) {
        Actions mouseAction = new Actions(driver);
        mouseAction.contextClick(element).perform();
    }

    public void switchDriver(int index) {
        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<String>(windows);
        driver.switchTo().window(windowsList.get(index));
    }

    public void scrollIntoView(WebElement element){
        this.wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void windowScroll () {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 500);");
    }
    public void clickJSE(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", element);
    }

    public void executeJS(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
