package ru.geekbrains.lesson4;

public abstract class MyArrayException extends Exception{

    private String arraySize;

    public MyArrayException(String message, String arraySize) {
        super(message);
        this.arraySize = arraySize;
    }

    public String getArraySize() {
        return arraySize;
    }
}
