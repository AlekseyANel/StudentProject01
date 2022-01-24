package BDDexample.Test.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//показывает, для этого класса запускается выполнение наших тестов
@RunWith(Cucumber.class)
//устанавливает некоторые свойства для нашего сценария
@CucumberOptions(features = "Features", glue = {"BDDexample/StepDefinition"})
public class Runner {
    //создаем пакет для StepDefinition
}
