package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Конкретный Гуугл-класс для работы с конкретной Гуугл-сраницей
public class GooglePage extends ParentPage{

    @FindBy(xpath = "//img[@alt='Google']")
    private WebElement imagePageGoogle;
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement inputSearch;
    @FindBy(xpath = "//div[@jsname='VlcLAe']/center/input[@value='Поиск в Google']")
    private WebElement buttonSubmit;

    //Конструктор, чтоб принимать вебДрайвер и передовать родительскому
    public GooglePage(WebDriver webDriver) {
        super(webDriver);
    }
    //Вызываем родительский метод open()
    public void openGooglePage() {
    open("https://google.com");
    }
    public boolean  isElementPresentOnGooglePage() {
        return webElements.isElementPresent(imagePageGoogle);
    }
    public void enterTextForGooglePage(String text) {
        webElements.enterText(inputSearch,text);
    }
    public void clickOnSubmit() {
        webElements.clickElement(buttonSubmit);
    }


}
