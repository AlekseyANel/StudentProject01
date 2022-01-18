package parentTest;

import Pages.GooglePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
//Родительский тестовый класс, всё общее для тестирования любой страницы
//1/Манипуляции с запуском драйвера
//2/Объявляет все нужные объекты
//3/выключит наш браузер
public class ParentTest {
    public WebDriver webDriver;
    public GooglePage googlePage;

    public ParentTest() {

    }

    @Before
    public void setUp() {
        File fileChromeDriver = new File ("chromedriver.exe");
        System.setProperty("webDriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        googlePage = new GooglePage(webDriver);
    }
    @After
    public void tearDown() {
        webDriver.close();// закрывает только вкладку
        webDriver.quit();
    }

}
