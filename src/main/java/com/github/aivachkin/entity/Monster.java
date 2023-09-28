package com.github.aivachkin.entity;

import com.github.aivachkin.service.CharacterService;

/**
 * Сущность - монстр
 *
 */
public class Monster extends Character implements CharacterService {

    public Monster(int attack, int defence, int health, int minDamage, int maxDamage) {
        super(attack, defence, health, minDamage, maxDamage);
    }

    @Override
    public String toString() {
        return String.format("Monster: " + super.toString());
    }
}
