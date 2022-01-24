package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//Эта библиотека для работы с вебэлементами на любой странице с логированием и
//предусмотрели возможность ошибки
//Например: - ввод текста в любое поле; - кликнуть на кликабельный элемент;
// - проверить наличие какого-либо вебэлемента на странице; - можно расширить ...
//Сюда будем заносить все веб элементы страницы
public class WebElements {
    WebDriver webDriver;
    Logger logger;

    public WebElements(WebDriver webDriver) {//Конструктор
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());

    }
    //Метод ввода текста в вебэлемент
    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text );
            logger.info(text + " was inputted");
        } catch (Exception e) {
            logger.error("Can't work with element "+element);
            Assert.fail("Can't work with element "+element);
        }
    }
    //Метод клика на вебэлемент
    public void clickElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was inputted");
        } catch (Exception e) {
            logger.error("Can't work with element "+element);
            Assert.fail("Can't work with element "+element);
        }
    }
    //Метод проверки наличия требуемого вебэлемента на странице
    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
