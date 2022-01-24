package parentTest;

import Pages.GooglePage;

import Pages.LoginPage;

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
    public LoginPage loginPage;


    public ParentTest() {

    }

    @Before
    public void setUp() {

        File fileChromeDriver = new File ("chromedriver.exe");
        System.setProperty("webDriver.chrome.driver", fileChromeDriver.getAbsolutePath());
         webDriver = new ChromeDriver();
         webDriver.manage().window().maximize();
         webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //неявные ожидания (лучше не использовать) на определенное время
        //Implicit Waits - конфигурируют весь экземпляр WebDriverа

        //метод ускоряет наши тесты и ввод данных в поля, не работает в данной версии селениума 3.141.59
        //Configuration.fastSetValue = true;
        //Configuration.browser = "1600x800";
        //Configuration.screenshots = true;
        //Configuration.savePageSources = true;//сохраняет изначальную страницу на фейленых тестах
        //переоткрывать бро (пр: не успел открыться) когда тест будет зафейлен
        //Configuration.reopenBrowserOnFail = true;

        googlePage = new GooglePage(webDriver);
        loginPage = new LoginPage(webDriver);


    }
    @After
    public void tearDown() {
        //закрывает только вкладку вебДрайвера
        //webDriver.close();
        //закрывает браузер вебДрайвером
        webDriver.quit();

    }

}
