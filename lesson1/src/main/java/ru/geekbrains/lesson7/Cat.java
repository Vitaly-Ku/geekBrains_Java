package ru.geekbrains.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
        if (p.food < appetite) {
            satiety = false;
            return;
        }
        satiety = true;
    }

    public void info() {
        System.out.println("кот: " + name + " сытый? " + satiety);
    }
}