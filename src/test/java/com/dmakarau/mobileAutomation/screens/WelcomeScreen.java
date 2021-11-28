package com.dmakarau.mobileAutomation.screens;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeScreen extends PageObject {
    public WelcomeScreen(WebDriver driver) {
        super(driver);
    }

//    @FindBy(id = "com.kaiahealth.msk.eu:id/sign_in")
    @FindBy(id = "sign_in")
    @iOSXCUITFindBy(id = "com.kaiahealth.msk.eu:id/sign_in")
    private WebElementFacade loginButton;

    @FindBy(id = "com.kaiahealth.msk.eu:id/sign_up")
    @iOSXCUITFindBy(id = "com.kaiahealth.msk.eu:id/sign_up")
    private WebElementFacade signUpButton;

    @FindBy(partialLinkText = "Configuring app")
    @iOSXCUITFindBy(accessibility = "loadingMessage")
    private WebElementFacade loadingMessage;

    @FindBy(id = "logo")
    @iOSXCUITFindBy(accessibility = "logo")
    private WebElementFacade kaiaLogo;

    public void clickLogIn() {
        (new WebDriverWait(getDriver(), 15))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public boolean isSignUpButtonPresent() {
        return signUpButton.isDisplayed();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isDisplayed();
    }

    public boolean isLogoDisplayed() {
        return kaiaLogo.isDisplayed();
    }

    public boolean isLoadingMessagePresent() {
        return loadingMessage.isPresent();
    }

    public void waitForLoading() {
        (new WebDriverWait(getDriver(), 15))
                .until(ExpectedConditions.invisibilityOf(loadingMessage));
    }
}
