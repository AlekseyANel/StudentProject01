package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//Конкретный Гуугл-класс для работы с конкретной Гуугл-сраницей
public class GooglePage extends ParentPage{

    @FindBy(xpath = "//title[contains(text(),'Google')]")////img[@class='lnXdpd']")
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
