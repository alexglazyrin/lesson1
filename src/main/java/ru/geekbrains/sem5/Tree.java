package ru.geekbrains.sem5;

import java.io.File;

public class Tree {

    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent); //рисуем отступ
        if(isLast){
            System.out.print("└");
            indent += "  ";
        }else{
            System.out.print("├");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if(files == null){
            return;
        }
        int subDirTotal = 0;
        int fileInDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                subDirTotal++;
            }else{
                fileInDirTotal++;
            }
        }

        int subDirCounter = 0;
        int fileInDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if(files[i].isDirectory()){
                print(files[i], indent, subDirCounter == subDirTotal-1 && fileInDirCounter == fileInDirTotal);
                subDirCounter++;
            } else{
                print(files[i], indent, fileInDirCounter == fileInDirTotal - 1 && subDirCounter == subDirTotal);
                fileInDirCounter++;
            }
        }

    }

}
