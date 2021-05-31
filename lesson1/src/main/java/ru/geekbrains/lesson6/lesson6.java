package ru.geekbrains.lesson6;

public class lesson6 {




    public static void main(String[] args) {
        Cat nessy = new Cat("Несси");
        Cat rina = new Cat("Рина");
        nessy.run(22);
        rina.swim(8);
        System.out.println("Количество созданных котиков: " + Cat.countCat);

        Dog bobik = new Dog("Бобик");
        bobik.run(400);
        bobik.swim(60);
        System.out.println("Количество созданных собак: " + Dog.countDog);


    }
}
