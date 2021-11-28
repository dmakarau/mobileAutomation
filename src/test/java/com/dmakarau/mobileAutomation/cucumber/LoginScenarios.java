package com.dmakarau.mobileAutomation.cucumber;

import com.dmakarau.mobileAutomation.TestData;
import com.dmakarau.mobileAutomation.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginScenarios {

    @Steps
    LoginSteps loginSteps;

    @Given("The app is launched on the Welcome screen")
    public void welcomeScreenIsLaunched() {
        loginSteps.waitForLoading();
        loginSteps.verifyTheWelcomeScreen();
    }

    @Then("The login screen is opened")
    public void loginScreenIsLaunched() {
        loginSteps.verifyTheLoginScreen();
    }

    @Given("The user is on the login screen")
    public void goToLoginScreen() {
        loginSteps.navigateToLoginScreen();
    }

    @When("I login with the valid credentials")
    public void loginWithValidCredentials() {
        loginSteps.loginWithCredentials(TestData.email, TestData.password);
    }

    @When("I tap the login button")
    public void tapLoginButton() {
        goToLoginScreen();
    }
}
