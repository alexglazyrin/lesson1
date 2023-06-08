package ru.geekbrains.lesson3;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
          new WorkerPerHour(1, "Alex", 120),
          new WorkerPerHour(2, "Jhon", 250),
          new WorkerPerMounth(3, "Boris", 25000),
                new WorkerPerHour(4,"Michail", 200),
                new WorkerPerMounth(5, "Oleg", 52000),

        };

        for (Worker worker: workers){
            System.out.println("Средняя зарплата " + worker.name + ": " + worker.getAverSalary(worker) + " рублей");
        }
    }
}
