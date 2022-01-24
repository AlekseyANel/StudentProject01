package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Selenide.$x;

//Конкретный Гуугл-класс для работы с конкретной Гуугл-сраницей
public class GooglePageSelenide { //extends ParentPage - не надо
//Прописуем все селенидЭлементы
public SelenideElement
    logoPageGoogle = $x("//img[@class='lnXdpd']"),
    inputSearchText = $x("//input[@class='gLFyf gsfi']"),
    buttonSubmit = $x("//div[@jsname='VlcLAe']/center/input[@class='gNO89b']"),
    checkUrl = $x("//a[@href='https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java']");

    /*//Конструктор не нужен
    public GooglePageSelenide(WebDriver webDriver) {
        super(webDriver);
    }*/


    public void openGooglePageWithSelenide(String url) {
    Selenide.open(url);
    }
    public void shouldPresentOnGooglePage() {
        logoPageGoogle.shouldHave(Condition.visible);
    }
    public void inputTextForSearching (String text) {
        inputSearchText.setValue(text);
    }
    public void clickOnSubmitForSearch() {
        buttonSubmit.waitUntil(Condition.visible, 10000).click();
    }
    public void shouldHaveSearchUrl(String url) {
        checkUrl.shouldHave(Condition.href(url));
    }

}
