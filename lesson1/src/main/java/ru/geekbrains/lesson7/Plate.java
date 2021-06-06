package ru.geekbrains.lesson7;

public class Plate {
    public int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food < n) {
            System.out.println("Осталось слишком мало еды");
            return;
        }
        food -= n;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void increaseFood(int n) {
        food += n;
    }
}