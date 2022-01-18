package GoogleTests;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;


//Junit documentation
//https://docs.google.com/document/d/1DbsocJZJCZctl2k7mTrH30xbTpMvLoo6e76tkqzGfKI/edit
public class GoogleTest extends ParentTest {
    WebDriver webDriver;

    @Test
    public void googleTest() {
//        webDriver.get("https://google.com");
//        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("maven Selenium Java");
//        webDriver.findElement(By.xpath("//div[@jsname='VlcLAe']/center/input[@value='Поиск в Google']")).click();
//        Assert.assertThat(//h3[contains(text(),'org.seleniumhq.selenium » selenium-java - Maven Repository')]);
        googlePage.openGooglePage();//открываем Google страницу
        Assert.assertTrue(googlePage.isElementPresentOnGooglePage());//проверяем, появилась ли иконка ГУГЛА на странице, т.е. загрузилась ли страница
        googlePage.enterTextForGooglePage("maven Selenium Java"); //в поле поиска вводим тестовые данные, такой вот текст для поиска
        googlePage.clickOnSubmit();//и кликаем для поиска
    }
}
