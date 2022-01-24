package TDDexample;

public class Unit {

    private int health;
    private final int damage;

    public Unit (int health, int damage) {//конструктор
        this.health=health;
        this.damage = damage;
    }
    public int getHealth() {//метод получения здоровья
        return health;
    }
    public void takeDamage(int damage) {//метод вычитания урона из здоровья
        health -=damage;
    }

    public void addDamage(Unit unitTom) {//метод - unitDenis наносит урон unitTomy
        unitTom.takeDamage(damage);
    }
}
