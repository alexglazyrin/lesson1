package ru.geekbrains.lesson4;

import static java.lang.Integer.parseInt;

public class ArrayT {
    private int rows;
    private int columns;
    private int sum;
    private String[][] str;


    public ArrayT(int rows, int columns) {
        str = new String[rows][columns];
    }

    public void useArrayT(){
        for (int i=0; i<str.length; i++){
            for(int j = 0; j < str[0].length; j++){
                str[i][j] =  ""+i+j+1;
                System.out.print(str[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void checkArray() throws MyArraySizeException{
        if (str.length == 4 && str[0].length == 4){
            System.out.println("Размер массива: 4 х 4");
        } else{
            throw new MyArraySizeException("Размер массива отличен от: 4 х 4", str.length + " " + str[0].length);
        }
    }

    public int sumArray() throws MyArrayDataException{
        for (int i = 0; i < str.length; i++){
            for(int j = 0; j < str[0].length; j++){
                try {
                    sum += parseInt(str[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Данные отличны от челочисленного формата","row: " + i + " column: " + j);
                }
            }
        }
        return sum;
    }
}
