
package ru.geekbrains.lesson4;

public class Main {


    public static void main(String[] args) {
        ArrayT arrayT = new ArrayT(4,4);

        try {
            arrayT.checkArray();
            arrayT.useArrayT();
            System.out.println(arrayT.sumArray());

        }catch (MyArraySizeException e){
            System.out.printf("Ошибка размерности массива \n%s\n", e.getMessage());
        }catch (MyArrayDataException e){
            System.out.println("Ошибка формата");
        }

    }



}

