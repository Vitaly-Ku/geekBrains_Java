package ru.geekbrains.lesson6;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int length) {
        System.out.println(name + " пробежал(а) метров: " + length);
    }

    public void swim(int length) {
        System.out.println(name + " проплыл " + length + " метров");
    }
}
