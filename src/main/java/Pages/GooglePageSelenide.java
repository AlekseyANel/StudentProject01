package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

//Конкретный Гуугл-класс для работы с конкретной Гуугл-сраницей
public class GooglePageSelenide { //extends ParentPage - не надо
private final Logger logger = Logger.getLogger(getClass());

//Прописуем все селенидЭлементы
public SelenideElement
    logoPageGoogle = $x("//*[contains(text(),'Google')]"),///html/head/title[contains(text(),'Google')]"), //div[@id='hplogo']"),
    inputSearchText = $x("//input[@class='gLFyf gsfi']"),
    buttonSubmit = $x("//div[@jsname='VlcLAe']/center/input[@class='gNO89b']"),
    checkUrl = $x("//a[@href='https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java']");

    /*Конструктор не нужен
    public GooglePageSelenide(WebDriver webDriver) {
        super(webDriver);
    }*/


    public void openGooglePageWithSelenide(String url) {
    Selenide.open(url);
    logger.info("Was opened " + url);
    }
    public void shouldPresentOnGooglePage() {
        logoPageGoogle.shouldHave(Condition.enabled);
        logger.info("Element should condition - VISIBLE and present" );
    }
    public void inputTextForSearching (String text) {
        inputSearchText.setValue(text);
        logger.info("Text inputed \"" + text + "\"");
    }
    public void clickOnSubmitForSearch() {
        buttonSubmit.waitUntil(Condition.visible, 10000).click();
    }
    public void shouldHaveSearchUrl(String url) {
        checkUrl.shouldHave(Condition.href(url));
    }

}
