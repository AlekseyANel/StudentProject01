package BDDexample.StepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    //Аннотация определяет метод открытия браузера и запуска приложения
    @Given("^Open chrome and launch the application$")
    public void open_chrome_and_launch_the_application() throws Throwable {
        //через ParentTest сначала открывается хром, затем наш сайт
        loginPage.openStackoverflowPage("https://stackoverflow.com");
        System.out.println("This step opens the chrome and launch the application");
    }
    //Аннотация определяет метод нажатия на кнопку ЛогИн
    @When("^Click to link Log in$")
    public void click_to_link_log_in() throws Throwable {
        loginPage.clickToButtonLogin();
        System.out.println("This step Click to link Log in");

    }
    //Аннотация определяет метод ввода имени пользователя и пароля
    @When("^Enter the UserName and Password$")
    public void enter_the_UserName_and_Password() throws Throwable {
        loginPage.setUsernameAndPassword("ocennysseq-9153@yopmail.com",
                "qwerty123");
        System.out.println("This step enters the UserName and Password");

    }
    //Аннотация определяет метод нажатия на кнопку
    @Then("^Click button submit$")
    public void click_the_button_submit()  throws Throwable {
        loginPage.clickButtonSubmit();
        System.out.println("This step click button submit");
    }

}

