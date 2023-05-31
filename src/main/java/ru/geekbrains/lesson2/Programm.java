package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Programm {
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '·';
    private static int fieldSize;
    //private static int fieldSizeY;

    private static final Scanner scan = new Scanner(System.in);
    private static final Random rand = new Random();

    private static char[][] field;

    /*
    Инициализация игрового поля
     */
    private static void initialize() {
        fieldSize = 5;
        //fieldSizeY = 5;

        field = new char[fieldSize][fieldSize];
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /*
    Отрисовка игрового поля
    TODO: Поправить отрисовку игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSize * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSize * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /*Обработка хода игрока (человека)

     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до  3) через пробел");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;

    }

    /*
    Проверка, ячека является пустой
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(fieldSize);
            y = rand.nextInt(fieldSize);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /*
    Проверка победы
    TODO: Переработать метод в дз
     */
    static boolean checkWin(char c) {
        /*
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;

         */
        boolean winDiagR = true;
        boolean winDiagL = true;
        boolean winH = true;
        boolean winV = true;
        for (int i = 0; i < fieldSize; i++) {
            winDiagR = winDiagR & (field[i][i] == c);
        }
        for (int i = 0; i < fieldSize; i++) {
            winDiagL = winDiagL & (field[i][fieldSize - i - 1] == c);
        }
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j<fieldSize; j++){
                winH = winH & (field[i][j] == c);
            }
            if (winH) break;
        }
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j<fieldSize; j++){
                winV = winV & (field[j][i] == c);
            }
            if (winV) break;
        }
        if (winDiagR) return true;
        if (winDiagL) return true;
        if (winH) return true;
        if (winV) return true;
        return false;
    }


    static boolean checkDraw() {
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }
    /*
    Метод проверки состояния игры
     */

    static boolean gameCheck(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; //Игра продолжается
    }


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы подбедили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер подбедил!"))
                    break;
            }
            System.out.println("Еще разок?");
            if (!scan.next().equalsIgnoreCase("Y"))
                break;
        }
    }
}
