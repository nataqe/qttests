package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.RegisterPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

@Owner("Natalia")
public class RegisterPageTests {

    public static final String URL = "https://login.qt.io/register";

    public RegisterPage registerPage = new RegisterPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(URL);
    }

    @Feature("Register form")
    @ParameterizedTest
    @MethodSource("incorrectEmailDataProvider")
    @DisplayName("Check email with incorrect format")
    public void testErrorForIncorrectEmailAddress_shouldContainCorrectText(String incorrectEmail) {
        registerPage.addEmail(incorrectEmail);
        registerPage.email.pressEnter();
        Assertions.assertEquals("Please enter a valid email address.", registerPage.getErrorLabelEmailText(), "Error description for email is incorrect.");
    }

    @Feature("Register form")
    @Test
    @DisplayName("Check empty email")
    public void testErrorForEmptyEmail_shouldContainCorrectText() {
        registerPage.addEmail("");
        registerPage.email.pressEnter();
        Assertions.assertEquals("This field is required.", registerPage.getErrorLabelEmailText(), "Error description for empty email is incorrect.");
    }

    @Feature("Register form")
    @Test
    @DisplayName("Check short password")
    public void testErrorForShortPassword_shouldContainCorrectText() {
        registerPage.addPassword("pass");
        registerPage.password.pressEnter();
        Assertions.assertEquals("Please enter at least 7 characters.", registerPage.getErrorLabelPasswordText(), "Error description for short password is incorrect.");
    }

    @Feature("Register form")
    @Test
    @DisplayName("Check empty password")
    public void testErrorForEmptyPassword_shouldContainCorrectText() {
        registerPage.addPassword("");
        registerPage.password.pressEnter();
        Assertions.assertEquals("This field is required.", registerPage.getErrorLabelPasswordText(), "Error description for empty password is incorrect.");
    }

    @Feature("Register form")
    @Test
    @DisplayName("Check password which is equal to email address")
    public void testErrorForPasswordEqualsToEmail_shouldContainCorrectText() {
        String email = "user.name1@domain.com";
        registerPage.addEmail(email);
        registerPage.addPassword(email);
        registerPage.password.pressEnter();
        Assertions.assertEquals("Please see password requirements", registerPage.getErrorLabelPasswordText(), "Error description for password is incorrect.");
    }

    @Feature("Register form")
    @Test
    @DisplayName("Check repeated password verification")
    public void testErrorForIncorrectVerifyPassword_shouldContainCorrectText() {
        registerPage.addVerifyPassword("mypass");
        registerPage.verifyPassword.pressEnter();
        Assertions.assertEquals("Please enter the same value again.", registerPage.getErrorLabelVerifyPasswordText(), "Error description for incorrect repeated password is incorrect.");
    }

    public static Stream<String> incorrectEmailDataProvider() {
        return Stream.of(
                "username.@domain.com",
                ".user.name@domain.com",
                "user-name@domain.com.",
                "username@.com",
                "[username]@domain.com",
                "user!name@domain.com",
                "user*name@domain.com",
                "user&name@domain.com",
                "user?name@domain.com",
                "user+name@domain.com"
        );
    }
}
