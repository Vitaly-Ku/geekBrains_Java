package ru.geekbrains;

public class lesson1 {
    byte num1 = 0;
    short num2 = 0;
    int num3 = 0;
    long num4 = 0L;
    float num5 = 0.0f;
    double num6 = 0.0;
    char char1 = '0';
    boolean bool1 = true;



    public static void main(String[] args) {
        System.out.println(evaluateExpression(3, 4, 5, 6));
        System.out.println(checkRange(10, 5));
        checkSign(-7);
        System.out.println(checkSign2(0));
        printGreeting("Виталий");
        leapYearCalculator(2100);

    }

    public static float evaluateExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean checkRange(int a, int b) {
        return a + b > 10 && a + b < 20;
    }

    public static void checkSign(int a) {
        if (a < 0) {
            System.out.println(a + " число отрицательное");
        } else {
            System.out.println(a + " число положительное");
        }
    }

    public static boolean checkSign2(int a) {
        return a < 0;
    }

    public static void printGreeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYearCalculator(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year +" год високосный");
                    return;
                }
                System.out.println(year + " год не високосный");
                return;
            }
            System.out.println(year +" год високосный");
        } else {
            System.out.println(year + " год не високосный");
        }
    }
}


