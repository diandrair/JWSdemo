package com.JWS.QAAutomationTest.page;

import com.JWS.QAAutomationTest.AbstractBasePage;
import com.JWS.QAAutomationTest.util.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationPage extends AbstractBasePage {

    @Autowired
    private BrowserActions browserActions;

    @FindBy(xpath = "//h1[normalize-space()='Authentication']")
    private WebElement authenticationText;

//    CREATE AN ACCOUNT section

    @FindBy(id = "email_create")
    private WebElement emailToCreateInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

//    SIGN IN section

    @FindBy(id = "email")
    private WebElement emailToLoginInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    public void createAccount(String email){
        browserActions.sendKeysToElement(emailToCreateInput, email);
        browserActions.clickElement(createAccountBtn);
    }

    public void signIn(String email, String pass){
        browserActions.sendKeysToElement(emailToLoginInput, email);
        browserActions.sendKeysToElement(passwordInput, pass);
        browserActions.clickElement(signInBtn);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.authenticationText.isDisplayed());
    }
}
