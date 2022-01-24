package TDDexample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Тестовый класс. Сначала прописываем здесь проверку, затем возвращаемся в
//клиентский класс и формируем рабчую логику/код.
//+ полное покрытие, ничего не забудем проверить
//+ простота, имена тестовых методов и их методов
//+ не нужно писать больше кода, чем есть тестов
public class UnitTest {
    @Test//просто тест
    public void test1() {
        new Unit(50,25);
    }
    @Test//Проверка здоровья юнита
    public void testGetHealth() {
        Unit unit = new Unit(50,25);
        assertEquals(50, unit.getHealth());
    }
    @Test//тест получения дамага
    public void testTakeDamage() {
        Unit unit = new Unit(50,25);
        unit.takeDamage(25);
    }
    @Test//проверка метода,чтоб получнный урон/дамаг вычитался из здоровья юнита
    public void testSubtractionDamage() {
        Unit unit = new Unit(50,25);
        unit.takeDamage(25);
        assertEquals(25, unit.getHealth());
    }
    @Test//проверка метода,чтоб наносимый урон/дамаг вычитался из здоровья юнита соперника
    public void testOneUnitToAnother() {
        Unit unitTom = new Unit(100,25);
        Unit unitDenis = new Unit(100,25);
        unitDenis.addDamage(unitTom);
        assertEquals(75, unitTom.getHealth());
    }
        //Следующий метод можно: проверка, чтоб здоровье не опускалось ниже нуля
}
