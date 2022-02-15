//package seleniumGrid;
//
//import Pages.GooglePage;
//import org.junit.runners.Parameterized;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class seleniumGridTest {
//    public WebDriver webDriver;
//    public GooglePage googlePage;
//
//    @Parameters("browser")
//    @BeforeTest
//    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
//        String url = "http://google.com";
//        String nodeUrl = "http://localhost:4444/wd/hub";
//
//        if (browser.equalsIgnoreCase("firefox")) {
//            System.out.println("Executing on Firefox bro ");
//            DesiredCapabilities cap = DesiredCapabilities.firefox();
//            cap.setBrowserName("firefox");
//            webDriver = new RemoteWebDriver(new URL(nodeUrl), cap);
//        } else if (browser.equalsIgnoreCase("chrome")) {
//            System.out.println("Executing on Chrome bro ");
//            DesiredCapabilities cap = DesiredCapabilities.chrome();
//            cap.setBrowserName("chrome");
//            webDriver = new RemoteWebDriver(new URL(nodeUrl), cap);
//            }
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        googlePage = new GooglePage(webDriver);
//    }
//
//    @AfterTest
//    public void tearDown() {
//        webDriver.quit();
//    }
//}
