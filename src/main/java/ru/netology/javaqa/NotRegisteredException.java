package ru.netology.javaqa;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {
        super("Gamer with name " + playerName + " not found");
    }
}
