package com.github.aivachkin.service;

import com.github.aivachkin.entity.Character;
import com.github.aivachkin.exception.CharacterIsDeadException;
import com.github.aivachkin.exception.CharactersOfTheSameClassException;

/**
 * Интерфейс - общие методы для взаимодействия игрока и монстров
 *
 */
public interface CharacterService {


    /**
     * реализация атаки одного персонажа на другого
     *
     * @param attacker атакующий персонаж
     * @param defender защищающийся персонаж
     */
    default void attackTheEnemy(Character attacker, Character defender) {

        if (attacker.getClass().equals(defender.getClass())){
            throw new CharactersOfTheSameClassException("Игроки одного класса не могут атаковать друг друга");
        }

        if (!attacker.isAlive() || !defender.isAlive()) {
            throw new CharacterIsDeadException("Один из персонажей мертв. Битва невозможна");
        }

        int defenderHealth = defender.getHealth();


        // модификатор атаки
        int attackModifier = Math.abs(attacker.getAttack() - defender.getHealth()) + 1;

        for (int i = 0; i < attackModifier; i++) {
            if (rollTheDie() > 4) {
                defenderHealth -= attackerDamageCalculation(attacker);
            }
        }

        if (defenderHealth <= 0) {
            defender.setHealth(0);
            defender.setAlive(false);
        } else {
            defender.setHealth(defenderHealth);
        }

    }

    /**
     * Метод, имитирующий бросание кубика
     *
     * @return число, выпавшее на кубике
     */
    default int rollTheDie() {
        int max = 6;
        int min = 1;
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Метод, вычисляющий урон, нанесенный нападающим
     *
     * @return урон, нанесенный нападающим
     */
    default int attackerDamageCalculation(Character character) {
        return (int) ((Math.random() * (character.getMaxDamage() - character.getMinDamage())) + character.getMinDamage());
    }

}
