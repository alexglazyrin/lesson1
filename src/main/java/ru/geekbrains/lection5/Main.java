package ru.geekbrains.lection5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        long timeStart = System.nanoTime();

        String s = "Example";
        for (int i = 0; i < 200000; i++){
            s = s + i;
        }

        double deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("Delta time (sec): " + deltaTime);

        StringBuilder sb = new StringBuilder("Example");
        for (int i = 0; i < 200000; i++){
            sb.append(i);
        }

        deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("Delta time (sec): " + deltaTime);

        System.out.println(s.equals(sb.toString()));
    }
}
