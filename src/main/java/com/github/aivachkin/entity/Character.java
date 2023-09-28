package com.github.aivachkin.entity;

import com.github.aivachkin.exception.IncorrectParametersException;

import java.util.Objects;

/**
 * Сущность - персонаж
 */
public class Character {

    /**
     * атака персонажа
     */
    private final int attack;

    /**
     * защита персонажа
     */
    private final int defence;

    /**
     * здоровье персонажа
     */
    private int health;

    /**
     * минимальное значение урона персонажа
     */
    private final int minDamage;

    /**
     * максимальное значение урона персонажа
     */
    private final int maxDamage;

    /**
     * флаг - признак того, что персонаж жив
     */
    private boolean isAlive;


    public Character(int attack, int defence, int health, int minDamage, int maxDamage) {
        if (check(attack, defence, health, minDamage, maxDamage)) {
            this.attack = attack;
            this.defence = defence;
            this.health = health;
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
            this.isAlive = true;
        } else {
            throw new IncorrectParametersException("Введены некорректные параметры при для создания существа");
        }
    }


    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return attack == character.attack && defence == character.defence && health == character.health && minDamage == character.minDamage && maxDamage == character.maxDamage && isAlive == character.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attack, defence, health, minDamage, maxDamage, isAlive);
    }

    @Override
    public String toString() {
        return "attack=" + attack +
                ", defence=" + defence +
                ", health=" + health +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", isAlive=" + isAlive;
    }

    /**
     * Метод для валидации параметров при создании существа
     *
     * @param attack    атака (1..30)
     * @param defence   защита (1..30)
     * @param health    (0..N)
     * @param minDamage минимальный урон (>0)
     * @param maxDamage максимальный урон (>0)
     * @return результат проверки (true/false)
     */
    public boolean check(int attack, int defence, int health, int minDamage, int maxDamage) {

        return (attack >= 1 && attack <= 30 && defence >= 1 && defence <= 30 &&
                health >= 1 && minDamage >= 0 && maxDamage >= 0 && minDamage <= maxDamage);
    }

}
