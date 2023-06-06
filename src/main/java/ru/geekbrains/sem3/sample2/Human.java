package ru.geekbrains.sem3.sample2;

public class Human extends BaseHuman{

    private int maxRun;
    private int maxJump;

    public Human(String name, int maxJump, int maxRun){
        super(name);
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }
}
