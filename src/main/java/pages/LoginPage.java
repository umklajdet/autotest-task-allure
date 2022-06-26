package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    private WebElement loginInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(id = "_submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement loginError;

    @Step("Вход в систему")
    public StartPage logIn(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
//        if (loginError.isDisplayed()) {
//            Assert.fail("Некорректные логин / пароль: " + loginError.getText());
//            return pageManager.getStartPage();
//        }
        return pageManager.getStartPage();
    }
}
