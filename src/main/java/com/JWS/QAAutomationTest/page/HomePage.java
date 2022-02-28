package com.JWS.QAAutomationTest.page;

import com.JWS.QAAutomationTest.AbstractBasePage;
import com.JWS.QAAutomationTest.util.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractBasePage {

    @Autowired
    private BrowserActions browserActions;

    @FindBy(id = "header_logo")
    private WebElement headerLogo;

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    private WebElement signInBtn;

    @Value("${application.url}")
    private String url;

    public void goTo(){
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    public void clickSignIn(){
        browserActions.clickElement(signInBtn);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> this.headerLogo.isDisplayed());
    }
}
