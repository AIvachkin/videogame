package com.github.aivachkin;

import com.github.aivachkin.entity.Monster;
import com.github.aivachkin.entity.Player;

public class Main {


    public static void main(String[] args) {


        // Создаем персонажей: Игрок и Монстр
        Monster monster = new Monster(10,12,15,1,10);
        Player player = new Player(2,12,20,3,6);

        // Выводим в консоль параметры созданных персонажей
        System.out.println("Параметры созданных персонажей");
        System.out.println(monster);
        System.out.println(player);
        System.out.println();

        // производим атаку Игрока на Монстра
        player.attackTheEnemy(player, monster);
        System.out.println("Параметры игроков после атаки Игрока на Монстра");
        System.out.println(monster);
        System.out.println(player);
        System.out.println();


        // производим атаку Монстра на Игрока
        monster.attackTheEnemy(monster, player);
        System.out.println("Параметры игроков после атаки Монстра на Игрока");
        System.out.println(monster);
        System.out.println(player);
        System.out.println();

        // лечим Игрока
        player.getCured(player);
        System.out.println("Параметры игрока после лечения");
        System.out.println(player);

    }
}