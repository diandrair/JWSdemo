package com.JWS.QAAutomationTest.StepDefinitions;

import com.JWS.QAAutomationTest.page.AuthenticationPage;
import com.JWS.QAAutomationTest.page.CreateAccountPage;
import com.JWS.QAAutomationTest.page.HomePage;
import com.JWS.QAAutomationTest.page.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.Random;

@SpringBootTest
public class authenticationSteps {

    @Autowired
    private CreateAccountPage createAccountPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private AuthenticationPage authenticationPage;

    @Autowired
    private MyAccountPage myAccountPage;


    public String randomEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "JWSexam"+randomInt+"@gmail.com";
    }

    public String randomPass(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "Password"+randomInt;
    }

    @Given("I am on homepage")
    public void iAmOnHomepage() {
        homePage.goTo();
        Assert.assertTrue(homePage.isAt());
    }

    @And("I input email to create account and click create account")
    public void iInputEmailToCreateAccountAndClickCreateAccount() {
        Assert.assertTrue(authenticationPage.isAt());
        authenticationPage.createAccount(randomEmail());
    }

    @When("I go to authentication page")
    public void iGoToAuthenticationPage() {
        homePage.clickSignIn();
        Assert.assertTrue(authenticationPage.isAt());
    }

    @And("I select {string}")
    public void iSelectGender(String gender) {
        createAccountPage.selectGender(gender);
    }

    @And("I enter my name as {string} and {string}")
    public void iEnterMyName(String firstName, String lastName) {
        createAccountPage.enterName(firstName, lastName);
    }


    @And("Verify entered email and enter my password")
    public void verifyEnteredEmailAndEnterMyPassword() {
        String pass = randomPass();
        System.out.println("email ::"+ createAccountPage.getEnteredEmail());
        System.out.println("password ::"+pass);
        createAccountPage.enterPass(pass);
    }

    @And("I enter my dob as {string}, {string}, {string}")
    public void iEnterMyDobAs(String date, String month, String year) {
        createAccountPage.enterDOB(date, month, year);
    }

    @And("I enter {string}")
    public void iEnterCompany(String company) {
        createAccountPage.enterCompany(company);
    }

    @And("I enter my address as {string}, {string}, {string}, {string}, {string}")
    public void iEnterMyAddressAs(String address, String city, String state, String postalCode, String country) {
        createAccountPage.enterAddress(address, city, state, postalCode, country);
    }

    @And("I enter my contact as {string} and {string}")
    public void iEnterMyContactAsAnd(String phone, String mobile) {
        createAccountPage.enterContact(phone, mobile);
    }

    @Then("I can see my name as {string} and {string} on my account page then sign out")
    public void iCanSeeMyNameAsAndOnMyAccountPage(String firstName, String lastName) {
        String actualName = myAccountPage.getAccountName();
        String expectedName = firstName+" "+lastName;
        Assert.assertEquals(actualName, expectedName);
        myAccountPage.logOut();
    }

    @Given("I am on authentication page")
    public void iAmOnAuthenticationPage() {
        Assert.assertTrue(authenticationPage.isAt());
    }

    @And("I enter {string} and {string} to login")
    public void iEnterAndToLogin(String userName, String password) {
        authenticationPage.signIn(userName, password);
    }

    @Then("I can see my name on my account page then sign out")
    public void iCanSeeMyNameOnMyAccountPage() {
        System.out.println(myAccountPage.getAccountName());
        myAccountPage.logOut();
    }
}
