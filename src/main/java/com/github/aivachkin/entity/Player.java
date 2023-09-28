package com.github.aivachkin.entity;


import com.github.aivachkin.service.CharacterService;
import com.github.aivachkin.service.PlayerService;

/**
 * Сущность - игрок
 */
public class Player extends Character implements CharacterService, PlayerService {


    /**
     * количество доступных исцелений
     */
    private int healing;

    /**
     * Максимально возможный уровень здоровья игрока
     *
     */
    private final int maxHealth;

    public Player(int attack, int defence, int health, int minDamage, int maxDamage) {
        super(attack, defence, health, minDamage, maxDamage);
        this.healing = 4;
        this.maxHealth = health;
    }

    public int getHealing() {
        return healing;
    }

    public int getMaxHealth() {
        return maxHealth;
    }


    public void setHealing(int healing) {
        this.healing = healing;
    }

    @Override
    public String toString() {
        return String.format("Player: " + super.toString() + ", healing=" + this.getHealing());
    }
}
