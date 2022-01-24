package APItest;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ApiTest {
    private final String endPoint = "https://swapi.dev/api/"; //https://swapi.dev/api/planets/1/
    private final String patchPeople = "people/1/";
    private final String patchPlanet = "planets/";
    public ApiTest() {
    }

    @Test
    public void getEndPoints() {
        //Response response = given() - первый метод не выводит в консоль ничего
        //Второй метод респонс стринга
        given()//Подготовка запроса
                .contentType("application/json")

                .when()//Происходит действие, сценарий
                .get(endPoint)//метод "гет" запроса сразу указываем

                .then()//Получаем результат ответ - респонс
                .assertThat().statusCode(200)//проверка ассертом статус код

                .extract().response()//извлекаем тело ответа-респонса
                .prettyPrint();//требует респонс стрингу и выводит
                // в консоль респонс-боди с енд-поинтами
    }
    @Test
    public void getPeople() {
        given()
                .contentType("application/json")
                .when()
                .get(endPoint + patchPeople)
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .prettyPrint();
    }
    @Test
    public void getNameCharacter() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get(endPoint+ patchPeople)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        String name = response.jsonPath().get("name").toString();
        //вытянуль из респонса, преобразовали в json, получили значение по ключу "name"
        // и отбразили его стингой
        String homeWorld = response.jsonPath().get("homeworld").toString();
        System.out.println("\n" + name + "\n" + homeWorld);
        // "\n" - с новой строки
    }
    @Test
    public void getNamePlanetAndPopulation() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get(endPoint+ patchPlanet)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        String namePlanet = response.jsonPath().get("results.name[0]").toString();
        String populationPlanet = response.jsonPath().get("results.population[0]").toString();
        String nameFilm = response.jsonPath().get("results.films[0][0]").toString();
        String nameResidents = response.jsonPath().get("results.residents[0][0]").toString();
        System.out.println("\n" + namePlanet + "\n" + populationPlanet + "\n" + nameFilm  + "\n" + nameResidents);
    }

}
