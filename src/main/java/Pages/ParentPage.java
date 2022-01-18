package Pages;

import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Родительский класс, всё общее для любой из страниц страниц
public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    WebElements webElements;
    //Конструктор, чтоб передавать вебДрайвер
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);
        logger = Logger.getLogger(getClass());
    }
/**
 * Method opens url
 * @param url
 */
public void open(String url) {
    try {
        webDriver.get(url);
        logger.info("Page has opened" + url);
    } catch (Exception e) {// При негативе тест останавливаем и пишем в логгах
        logger.error("Page can't opened" + url);
        Assert.fail("Page can't opened" + url);
    }
}
}
