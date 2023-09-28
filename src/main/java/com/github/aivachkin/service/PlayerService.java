package com.github.aivachkin.service;


import com.github.aivachkin.entity.Player;
import com.github.aivachkin.exception.CharacterIsDeadException;
import com.github.aivachkin.exception.CureException;

/**
 * Интерфейс - методы, уникальные для персонажа "игрок"
 */
public interface PlayerService {

    /**
     * исцеление игрока
     *
     * @param player сущность игрока
     */
    default void getCured(Player player) {

        if (!player.isAlive()) {
            throw new CharacterIsDeadException("Игрок мертв. Лечение невозможно");
        }

        if (player.getHealing() == 0) {
            throw new CureException("Игрок истратил все попытки исцеления. Лечение невозможно");
        }

        // текущее здоровье игрока
        int currentHealth = player.getHealth();

        // максимально возможная прибавка к текущему здоровью (30% от максимального здоровья)
        int cure = (int) (player.getMaxHealth() * 0.3);

        int newHealth = currentHealth + cure;

        player.setHealth(Math.min(newHealth, player.getMaxHealth()));
        player.setHealing(player.getHealing() - 1);

    }

}
