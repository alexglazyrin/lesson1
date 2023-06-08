package ru.geekbrains.lesson3;

public abstract class Worker {
    protected String name;
    protected int tabNum;
    protected int salary;
    protected int averageSalary;

    public Worker(int tabNum, String name, int salary){
        this.tabNum = tabNum;
        this.name = name;
        this.salary = salary;
    }

    public int getAverSalary(Worker worker){
        if(worker instanceof WorkerPerHour){
            averageSalary = (int) (20.8 * 8 * salary);
        } else{
            averageSalary = salary;
        }
        return averageSalary;
    }

}
