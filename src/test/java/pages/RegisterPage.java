package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/*
Password requirements:
 - Minimum 7 characters
 - Cannot contain your email address or name
 - Must include at least three of these four types: lowercase letters, uppercase letters, digits, symbols
 - Accepted characters: a-z, A-Z, 0-9, space and symbols !"#/()=?@${[]}\,.-_<>|;:'*^~+
 */
public class RegisterPage {

    // register form elements
    private SelenideElement email = $(By.id("email"));
    private SelenideElement password = $(By.id("password"));
    private SelenideElement verifyPassword = $(By.id("verifypassword"));
    private SelenideElement captchaInput = $(By.id("captcha"));
    private SelenideElement acceptTerms = $(By.id("accept_terms"));
    private SelenideElement submitButton = $(By.className("submit"));

    // error description elements
    private SelenideElement errorLabelEmail = $(By.xpath("//label[@for='email']"));
    private SelenideElement errorLabelPassword = $(By.xpath("//label[@for='password']"));
    private SelenideElement errorLabelVerifyPassword = $(By.xpath("//label[@for='verifypassword']"));

    public void addEmail(String emailString) {
        email.clear();
        email.sendKeys(emailString);
    }

    public void addPassword(String passwordString) {
        password.clear();
        password.sendKeys(passwordString);
    }

    public void addVerifyPassword(String verifyPasswordString) {
        verifyPassword.clear();
        verifyPassword.sendKeys(verifyPasswordString);
    }

    public void addCaptchaInput(String captchaInputString) {
        captchaInput.sendKeys(captchaInputString);
    }

    public void checkAcceptTerms(boolean check) {
        acceptTerms.setSelected(check);
    }

    public String getErrorLabelEmailText() {
       return errorLabelEmail.getText();
    }

    public String getErrorLabelPasswordText() {
        return errorLabelPassword.getText();
    }

    public String getErrorLabelVerifyPasswordText() {
        return errorLabelVerifyPassword.getText();
    }


    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getVerifyPassword() {
        return verifyPassword;
    }

    public SelenideElement getCaptchaInput() {
        return captchaInput;
    }

    public SelenideElement getAcceptTerms() {
        return acceptTerms;
    }
}
