package com.dmakarau.mobileAutomation.steps;

import com.dmakarau.mobileAutomation.screens.LoginScreen;
import com.dmakarau.mobileAutomation.screens.WelcomeScreen;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginSteps extends ScenarioSteps {
    WelcomeScreen welcomeScreen;
    LoginScreen loginScreen;

    @Step("Navigate to the login screen by clicking the log in button")
    public void navigateToLoginScreen() {
        welcomeScreen.clickLogIn();
    }

    @Step ("Wait for Welcome screen is loading")
    public void waitForLoading() {
        if (welcomeScreen.isLoadingMessagePresent())
            welcomeScreen.waitForLoading();
    }

    @Step("Verify that the logo, sign up button and the login button are present on the Welcome screen")
    public void verifyTheWelcomeScreen() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(welcomeScreen.isLogoDisplayed(), "ERROR-> The logo is not displayed");
        softAssert.assertTrue(welcomeScreen.isSignUpButtonPresent(), "ERROR-> The Sign up button is not present");
        softAssert.assertTrue(welcomeScreen.isLoginButtonPresent(), "ERROR-> The login button is not present");
        softAssert.assertAll();
    }

    @Step("Verify that the login with Email button, email field and password field are present on the Login screen")
    public void verifyTheLoginScreen() {
        SoftAssert softAssertions = new SoftAssert();
        softAssertions.assertTrue(loginScreen.isEmailFieldDisplayed(), "ERROR-> The email field is not displayed");
        softAssertions.assertTrue(loginScreen.isPasswordFieldDisplayed(), "ERROR-> The password field is not displayed");
        softAssertions.assertTrue(loginScreen.isLoginButtonDisplayed(), "ERROR-> The login button is not displayed");
        softAssertions.assertAll();
    }

    @Step("Enter the credentials, click login and verify that no errors are present")
    public void loginWithCredentials(String email, String password) {
        loginScreen.enterEmailAddress(email);
        loginScreen.enterPassword(password);
        loginScreen.clickLoginButton();

        Assert.assertEquals(loginScreen.isErrorMessagePresent() == false, "ERROR-> The error message " + loginScreen.getErrorMessage() + " is present");
    }
}
