/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j10.labs.shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ENVY
 */
public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    
    //метод для выведения сообщений пользователю (пока что выводит в консоль)
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    //метод для чтения вводимых с консоли строк:
    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    //метод для чтения координат с консоли:
    public static float readFloat() throws IOException {
        String text = readString();
        return Float.parseFloat(text.trim());
    }
}
