package com.dmakarau.mobileAutomation.screens;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class LoginScreen extends PageObject {
    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[@resource-id='com.kaiahealth.msk.eu:id/edit_text'])[1]")
    @iOSXCUITFindBy(accessibility = "email")
    private WebElementFacade emailField;

    @FindBy(xpath = "(//*[@resource-id='com.kaiahealth.msk.eu:id/edit_text'])[2]")
    @iOSXCUITFindBy(accessibility = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "com.kaiahealth.msk.eu:id/button_text")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private WebElementFacade loginWithEmailButton;

    @FindBy(id = "com.kaiahealth.msk.eu:id/error")
    @iOSXCUITFindBy(accessibility = "errorMessage")
    private WebElementFacade error;

    public void enterEmailAddress(String email) {
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public String getErrorMessage() {
        return error.getText();
    }

    public void clickLoginButton() {
        loginWithEmailButton.click();
    }

    public boolean isEmailFieldDisplayed() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginWithEmailButton.isDisplayed();
    }

    public boolean isErrorMessagePresent() {
        return error.isPresent();
    }
}
