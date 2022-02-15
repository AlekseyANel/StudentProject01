package parentTest;

import Pages.GooglePageSelenide;
import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

//Родительский тестовый класс, всё общее для тестирования любой страницы
//1/Манипуляции с запуском драйвера
//2/Объявляет все нужные объекты
//3/выключит наш браузер
public class ParentSelenideTest {
    public GooglePageSelenide googlePageSelenide;

    public ParentSelenideTest() {
    }
    @Parameters("browser")
    @BeforeClass
    public void setUp() { //@Optional("chrome") String browser
        //немного оптимизуруем наш Хром
        ChromeOptions options = new ChromeOptions();
        //Подтверждения во всплывающих окнах  (пр: геоданные, микрофон ...
        Map<String, Object> prefs = new HashMap<String, Object>();
        // 1 - Allow, 2 - Block, 3 - default
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);//активировать prefs
        options.addArguments("--incognito"); //Режим инкогнито
        options.addArguments("disable-infobars"); //Отключаем какие-то инфобары
        options.addArguments("--window-size-1600,900");//разрешение
        WebDriverRunner.setWebDriver(new ChromeDriver(options));//запускаем хром с нашими настройками

        googlePageSelenide = new GooglePageSelenide();//без ведрайвера для селенид

    }
    @AfterClass
    public void tearDown() {
        //закрывает браузер селенидом и его вебраннером, а не селениум-вебДрайвером webDriver.quit();
        //        //webDriver.quit();
        WebDriver currentDriver = WebDriverRunner.getWebDriver();
        currentDriver.manage().deleteAllCookies();//удаляем кукисы перед выходом
        currentDriver.quit();
    }

}
