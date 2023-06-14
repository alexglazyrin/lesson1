package ru.geekbrains.sem4;

public class AnimalRunException extends AnimalException{
    public AnimalRunException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
