package GoogleTests;

import org.junit.Assert;

import org.testng.annotations.Test;
import parentTest.ParentTest;


//Junit documentation
//https://docs.google.com/document/d/1DbsocJZJCZctl2k7mTrH30xbTpMvLoo6e76tkqzGfKI/edit
public class GoogleTest extends ParentTest {

    @Test  (enabled = false)       //Первое тестирование простым способом, игнорим
    public void googleTest() {

//        webDriver.get("https://google.com");
//        webDriver.findElement(By.xpath("//div[@id='hplogo']")).sendKeys("maven Selenium Java");////input[@class='gLFyf gsfi']
//        webDriver.findElement(By.xpath("//div[@jsname='VlcLAe']/center/input[@value='Поиск в Google']")).click();
//        Assert.assertThat(//h3[contains(text(),'org.seleniumhq.selenium » selenium-java - Maven Repository')]);
    }

    @Test        //Второе тестирование способом Селениумом через паттерн PageObject
    public void googleTestPageObj() {
        googlePage.openGooglePage();//открываем Google страницу
        Assert.assertTrue(googlePage.isElementPresentOnGooglePage());//проверяем, появилась ли иконка ГУГЛА на странице, т.е. загрузилась ли страница
        googlePage.enterTextForGooglePage("maven Selenium Java"); //в поле поиска вводим тестовые данные, такой вот текст для поиска
        googlePage.clickOnSubmit();//и кликаем для поиска
    }

    //Третье тестирование через Selenide см. на GoogleSelenideTest


}
