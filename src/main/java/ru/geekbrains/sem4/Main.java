package ru.geekbrains.sem4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*try {
            int[] numbers = new int[3];
            numbers[3] = 45;
            System.out.println(numbers[3]);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/

        //readTextFile("C://test//test.txt");

        Animal cat = new Cat("Persik", 100);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int j = random.nextInt(2);
            try {
                switch (j){
                    case 0:
                        cat.swim(i*10);
                        break;
                    case 1:
                        cat.run(i*10);
                        System.out.printf("Кошка пробежала %d метров\n", i*10);
                        break;
                }
            }
            catch (AnimalRunException ex){
                System.out.printf("Ошибка при попытке %s пробежать %d \n%s\n",
                        ex.getName(), ex.getDistance(), ex.getMessage());

            }
            catch (AnimalSwimException ex){
                System.out.printf("Ошибка при попытке %s проплыть %d \n%s\n",
                        ex.getName(), ex.getDistance(), ex.getMessage());

            }
        }
    }


        public static void readTextFile(String fileName){
            FileReader fileReader = null;
        try {
                fileReader = new FileReader(fileName);
                char[] buf = new char[256];
                int c;
                while ((c = fileReader.read(buf)) > 0) {
                    if (c < 256) {
                        buf = Arrays.copyOf(buf, c);
                    }
                    for (char symbol : buf) {
                        System.out.print(symbol);
                    }
                }
                //fileReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("**** File not found **** ");
            } catch (IOException e) {
                System.out.println("**** File is bad ****");
            }
        finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

