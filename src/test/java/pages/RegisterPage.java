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
    public SelenideElement email = $(By.id("email"));
    public SelenideElement password = $(By.id("password"));
    public SelenideElement verifyPassword = $(By.id("verifypassword"));
    public SelenideElement captchaInput = $(By.id("captcha"));
    public SelenideElement acceptTerms = $(By.id("accept_terms"));
    public SelenideElement submitButton = $(By.className("submit"));

    // error description elements
    public SelenideElement errorLabelEmail = $(By.xpath("//form[@id='passwordform']/fieldset[@class='form_label']/label[@for='email']"));
    public SelenideElement errorLabelPassword = $(By.xpath("//form[@id='passwordform']/fieldset[@class='form_label']/label[@for='password']"));
    public SelenideElement errorLabelVerifyPassword = $(By.xpath("//form[@id='passwordform']/fieldset[@class='form_label']/label[@for='verifypassword']"));

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
}
