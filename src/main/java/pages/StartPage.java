package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StartPage extends BasePage {
    @FindBy(xpath = "//h1[contains(@class, 'oro-subtitle')]")
    private WebElement title;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li")
    private List<WebElement> mainMenuElements;

    @FindBy(xpath = "//li[contains(@class, 'single')]/a/span")
    private List<WebElement> subMenuElements;

    @Step("Проверка названия страницы")
    public StartPage checkPageTitle(String expectedTitle) {
        assertEquals("Название страницы не соответствует ожидаемому",
                expectedTitle,
                title.getText());
        return this;
    }

    @Step("Выбор пункта главного меню")
    public StartPage selectMainMenuElement(String elementName) {
        for (WebElement menuElement : mainMenuElements) {
            if (menuElement.getText().contains(elementName)) {
                menuElement.click();
                return this;
            }
        }
        Assert.fail("В главном меню не найден пункт " + elementName);
        return this;
    }

    @Step("Выбор пункта подменю")
    public BusinessTripsPage selectSubMenuElement(String subElementName) {
        for (WebElement menuElement : subMenuElements) {
            if (menuElement.getText().contains(subElementName)) {
                menuElement.click();
                return pageManager.getBusinessTripsPage();
            }
        }
        Assert.fail("В подменю не найден пункт " + subElementName);
        return pageManager.getBusinessTripsPage();
    }
}
