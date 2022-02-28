package com.JWS.QAAutomationTest.page;

import com.JWS.QAAutomationTest.AbstractBasePage;
import com.JWS.QAAutomationTest.util.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyAccountPage extends AbstractBasePage {

    @Autowired
    private BrowserActions browserActions;

    @FindBy(xpath = "//h1[normalize-space()='My account']")
    private WebElement myAccountText;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement accountName;

    @FindBy(xpath = "//a[@title='Log me out']")
    private WebElement signOutBtn;

    public String getAccountName(){
       return browserActions.getElementText(accountName);
    }

    public void logOut(){
        browserActions.clickElement(signOutBtn);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> this.myAccountText.isDisplayed());
    }
}
