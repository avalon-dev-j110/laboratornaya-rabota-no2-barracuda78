/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j10.labs.shapes;

/**
 *
 * @author ENVY
 */
public class WrongShapeCreationException extends Exception {
    public WrongShapeCreationException(String message){
        super(message);
        ConsoleHelper.writeMessage("Ошибка.");
    }
}
