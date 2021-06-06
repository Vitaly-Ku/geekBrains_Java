package ru.geekbrains.lesson6;

public class Cat extends Animal {

    static int countCat;
    int limit = 200;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    @Override
    public void run(int length) {
        if (length > limit) {
            System.out.println("Коты столько не бегают. (больше " + limit + " метров)");
            return;
        }
        super.run(length);
    }

    @Override
    public void swim(int length) {
        System.out.println("В нашей программе коты не плавают");
        return;
    }
}
