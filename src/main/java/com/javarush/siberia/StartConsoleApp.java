package com.javarush.siberia;

import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.menu.ConsoleApplication;
import com.javarush.siberia.menu.ConsoleMenu;

public class StartConsoleApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Добро пожаловать в примитивный шифровальщик, который Цезарь завещал.");
        System.out.println(Constants.ALPHABET_LENGTH_TXT);

        //todo переместить сканер
        //перекинуть в конструктор

        ConsoleApplication consoleApplication = new ConsoleApplication();
        ConsoleMenu consoleMenu = new ConsoleMenu(consoleApplication);
        consoleMenu.showMenu();
    }
}