package ru.geekbrains.lesson4;

public class WrongArrSizeException extends Exception{
    String msg; // = "Wrong array size (not 4 x 4)!!!";
    public WrongArrSizeException(String msg){
        this.msg = msg;
    }
    /*public String getMsg() {
        return msg;
    }*/
}
