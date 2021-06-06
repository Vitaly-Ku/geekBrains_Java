package ru.geekbrains.lesson6;

public class Dog extends Animal {

    static int countDog;
    int runLimit = 500;
    int swimLimit = 10;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int length) {
        if (length > runLimit) {
            System.out.println("Коты столько не бегают. (больше " + runLimit + " метров)");
            return;
        }
        super.run(length);
    }

    @Override
    public void swim(int length) {
        if (length > swimLimit) {
            System.out.println("Собакм столько не плавают. (больше " + swimLimit + " метров)");
            return;
        }
        super.swim(length);
    }
}
