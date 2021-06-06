package ru.geekbrains.lesson7;

public class MainClass {

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];

        Cat cat1 = new Cat("Cat1", 5);
        Cat cat2 = new Cat("Cat2", 10);
        Cat cat3 = new Cat("Cat3", 15);
        Cat cat4 = new Cat("Cat4", 30);
        Cat cat5 = new Cat("Cat5", 45);

        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = cat3;
        cats[3] = cat4;
        cats[4] = cat5;

        Plate plate = new Plate(100);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.info();
            cats[i].info();
        }

        plate.increaseFood(70);
        plate.info();
    }
}
