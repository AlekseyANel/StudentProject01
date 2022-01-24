package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='email']")
    private WebElement inputUsername;
    @FindBy(xpath = ".//a[contains(text(),'Log in')]")
    private WebElement buttonLogin;
    @FindBy(xpath = ".//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//button[@id='submit-button']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Вызываем родительский метод open()
    public void openStackoverflowPage(String url) {
        open(url);
    }
    public void clickToButtonLogin() {
        webElements.clickElement(buttonLogin);
    }

    public void setUsernameAndPassword(String username, String password) {
        webElements.enterText(inputUsername,username);
        webElements.enterText(inputPassword, password);
    }
    public void clickButtonSubmit() {
        webElements.clickElement(buttonSubmit);
    }
}
