package ru.geekbrains.sem3.sample01;

public class Human {
    private final String name;

    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    private final int maxRun;
    private final int maxJump;

    public Human(){
        this("noname");
        /*this.name = "noname";
        this.maxRun = 1000;
        this.maxJump = 100;*/
    }

    public Human(String name){
        this(name, 1000);
        /*this.name = name;
        this.maxRun = 1000;
        this.maxJump = 100;*/
    }

    public Human(int maxRun, int maxJump){
        this(name,maxRun,100);
        /*this.name = "noname";
        this.maxRun = maxRun;
        this.maxJump = maxJump;*/
    }

    public Human(String name, int maxRun, int maxJump){
        if(name == null || name.length() < 3){
            this.name = "noname";
        }else{
            this.name = name;
        }
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public String toString(){
        return "Human{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }
}
