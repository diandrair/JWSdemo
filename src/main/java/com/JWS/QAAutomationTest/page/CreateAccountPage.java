package com.JWS.QAAutomationTest.page;

import com.JWS.QAAutomationTest.AbstractBasePage;
import com.JWS.QAAutomationTest.util.BrowserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountPage extends AbstractBasePage {

    @Autowired
    private BrowserActions browserActions;

    @FindBy(xpath = "//h1[normalize-space()='Create an account']")
    private WebElement createAccountText;

//    YOUR PERSONAL INFORMATION section

    @FindBy(id = "id_gender1")
    private WebElement MrRadioBtn;

    @FindBy(id = "id_gender2")
    private WebElement MrsRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passInput;

    @FindBy(id = "days")
    private WebElement selectDays;

    @FindBy(id = "months")
    private WebElement selectMonths;

    @FindBy(id = "years")
    private WebElement selectYears;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckBox;


//    YOUR ADDRESS section

    @FindBy(id = "firstname")
    private WebElement firstNameAddressInput;

    @FindBy(id = "lastname")
    private WebElement lastNameAddressInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "address2")
    private WebElement addressLine2Input;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "postcode")
    private WebElement postCodeInput;

    @FindBy(id = "id_country")
    private WebElement selectCountry;

    @FindBy(id = "other")
    private WebElement additionalInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    private WebElement submitBtn;


    public void selectGender(String gender){
        switch (gender){
            case "FEMALE": browserActions.clickElement(MrsRadioBtn); break;
            default: browserActions.clickElement(MrRadioBtn); break;
        }
    }

    public void enterName(String fname, String lname){
        browserActions.sendKeysToElement(firstNameInput, fname);
        browserActions.sendKeysToElement(lastNameInput, lname);
    }

    public String getEnteredEmail(){
        return browserActions.getAttribute(emailInput);
    }

    public void enterPass(String pass){
        browserActions.sendKeysToElement(passInput, pass);
    }

    public void enterDOB( String date, String month, String year){
        browserActions.select(selectDays,date);
        browserActions.select(selectMonths,month);
        browserActions.select(selectYears,year);
    }

    public void enterCompany(String company){
        browserActions.sendKeysToElement(companyInput,company);
    }

    public void enterAddress( String address, String city,
                                String state, String postalCode, String country){
        browserActions.sendKeysToElement(addressInput, address);
        browserActions.sendKeysToElement(cityInput, city);
        browserActions.select(selectState, state);
        browserActions.sendKeysToElement(postCodeInput, postalCode);
        browserActions.select(selectCountry,country);
    }

    public void enterContact(String phone, String mobile){
        browserActions.sendKeysToElement(homePhoneInput, phone);
        browserActions.sendKeysToElement(mobilePhoneInput, mobile);
        browserActions.clickJSE(submitBtn);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)-> this.createAccountText.isDisplayed());
    }
}
