//package selenoidTest;
//
//import Pages.GooglePageSelenide;
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.WebDriverRunner;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.codeborne.selenide.Selenide.open;
//
//
//public class SelenoidTest {
//    public GooglePageSelenide googlePageSelenide;
//
//    @BeforeTest
//    public void setUp() {//@Optional("chrome") String browser - no       @Parameters("browser")
//        String RUN_TYPE = "local";//на выбор способ запуска
//        switch (RUN_TYPE) {
//            case ("remote"):
//                //Настраиваем конфигурации для нашего селеноида
//                //урл удаленного вебдрайвера
//                Configuration.remote = "http://192.168.99.100:4444/wd/hub"; // http://localhost:4444/wd/hub
//                //Разрешение браузера
//                Configuration.browserSize = "1600x1200";
//                //Создаем объект капабилитис
//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                //настройка капабилитис пара: ключ-значение
//                capabilities.setCapability("browserName", "chrome");
//                capabilities.setCapability("browserVersion", "97.0");
//                capabilities.setCapability("platform", "LINUX");
//                //+ определенные настройки
//                capabilities.setCapability("enableVNC", true);//показывает, что мы отображаем браузер в нашем контейнере
//                capabilities.setCapability("enableVideo", true);
//                capabilities.setCapability("enableLog", true);
//                //переопределяем наш браузеркапабилитис
//                Configuration.browserCapabilities = capabilities;
//
//                break;
//            case ("local"):
//                Configuration.fastSetValue = true;
//                Configuration.browserSize = "1600x900";
//                Configuration.screenshots = true;
//                Configuration.savePageSource = true;
//                Configuration.reopenBrowserOnFail = true;
//                //немного оптимизуруем наш Хром
//                ChromeOptions options = new ChromeOptions();
//                //Подтверждения во всплывающих окнах  (пр: геоданные, микрофон ...
//                Map<String, Object> prefs = new HashMap<>();
//                // 1 - Allow, 2 - Block, 3 - default
//                prefs.put("profile.default_content_setting_values.notifications", 1);
//                options.setExperimentalOption("prefs", prefs);//активировать prefs
//                options.addArguments("--incognito"); //Режим инкогнито
//                options.addArguments("disable-infobars"); //Отключаем какие-то инфобары
//                options.addArguments("--window-size-1600,900");//разрешение
//                WebDriverRunner.setWebDriver(new ChromeDriver(options));//запускаем хром с нашими настройками
//                break;
//        }
//        googlePageSelenide = new GooglePageSelenide();
//    }
//    @Test
//    //повторим такой же тест как у селенида
//    public void googleRemoteTest() throws InterruptedException {
//        googlePageSelenide.openGooglePageWithSelenide("https://google.com");
//        googlePageSelenide.shouldPresentOnGooglePage();
//        googlePageSelenide.inputTextForSearching("maven selenium java");
//        googlePageSelenide.clickOnSubmitForSearch();
//        googlePageSelenide.shouldHaveSearchUrl
//                ("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java");
//        //Будет очень быстро, поэтому требуется пауза)
//        Thread.sleep(1000);
//        //даже не надо закрывать браузер, хотя это конфигурируемо, какие-то драйвер-менеджеры
//
//    }
//
//    @Test
//    public void stackoverflowTest() throws InterruptedException {
//        open("https://stackoverflow.com/");
//        Thread.sleep(3000);
//    }
//    @AfterTest
//    public void quitTest() {
//        WebDriverRunner.closeWebDriver();
//    }
//
//}
