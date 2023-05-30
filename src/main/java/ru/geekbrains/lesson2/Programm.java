package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Programm {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '·';
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final Scanner scan = new Scanner(System.in);
    private static final Random rand = new Random();

    private static char[][] field;

    /*
    Инициализация игрового поля
     */
    private static void initialize(){
        fieldSizeX = 3;
        fieldSizeY = 3;

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }
    /*
    Отрисовка игрового поля
    TODO: Поправить отрисовку игрового поля
     */
    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++){
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++){
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeY; j++){
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /*Обработка хода игрока (человека)

     */
    private static void humanTurn(){
        int x, y;
        do{
            System.out.println("Введите координаты хода X и Y (от 1 до  3) через пробел");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        }
        while (!isCellValid(x,y) || !isCellEmpty(x,y));
        field[x][y] = DOT_HUMAN;

    }
    /*
    Проверка, ячека является пустой
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn(){
        int x, y;
        do{
            x = rand.nextInt(fieldSizeX);
            y = rand.nextInt(fieldSizeY);
        }while (!isCellEmpty(x,y));
        field[x][y] = DOT_AI;
    }


    public static void main(String[] args) {
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                //TODO: Проверка на победу
                aiTurn();
                printField();
                //TODO: Проверка на победу
            }

    }

}
