package GoogleTests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentSelenideTest;
import parentTest.ParentTest;


//Junit documentation
//https://docs.google.com/document/d/1DbsocJZJCZctl2k7mTrH30xbTpMvLoo6e76tkqzGfKI/edit
public class GoogleSelenideTest extends ParentSelenideTest {

    //Третье тестирование через Selenide
    @Test
    public void googleTestWithSelenide() {
        /** Все это надо упростить и перенести в GooglePageSelenide
        Selenide.open("https://google.com");
        //захват и сразу проверка наявность элемента на странице по локатору + сразу вейтер
        $(By.xpath("//img[@id='Google']")).shouldHave(Condition.visible);
        //захват элемента по локатору и ввод текста в него
        $(By.xpath("//input[@class='gLFyf gsfi']")).setValue("maven Selenium Java");
        //захват и сразу проверка видимости элемента на странице + сразу вейтер на ожидание появления
        $(By.xpath("//div[@jsname='VlcLAe']/center/input[@value='Поиск в Google']")).waitUntil(Condition.visible, 10000).click();
        $(By.xpath("//a[@href='https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java']"))
                .shouldHave(Condition.href("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java"));
         */
        googlePageSelenide.openGooglePageWithSelenide("https://google.com");
        googlePageSelenide.shouldPresentOnGooglePage();
        googlePageSelenide.inputTextForSearching("maven Selenium Java");
        googlePageSelenide.clickOnSubmitForSearch();
        //проверяем результат поиска
        googlePageSelenide.shouldHaveSearchUrl(
                "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java");
    }

}
