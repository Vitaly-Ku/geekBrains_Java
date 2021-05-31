package ru.geekbrains;

import java.util.Scanner;

public class lesson3 {

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
            "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static String goal = words[(int)(Math.random() * (words.length) - 0)];
    static Scanner scanner = new Scanner(System.in);
    static String answer = "";
    static int answerCharacter = 0;
    static int tryCount = 0;
    static int missingSharpSign = answer.length() < goal.length() ? 15 - answer.length() : 15 - goal.length(); // если ответ короче загаданного слова


    public static void main(String[] args) {
        System.out.println("Загаданное слово - " + goal);

        checkMatches();

        System.out.println("\nПобеда! Слово угадано\nПопыток: " + tryCount);
    }

    public static void checkMatches() {
        do {
            System.out.println("\nУгадайте фрукт / овощ");
            answer = scanner.nextLine();
            for (int i = 0; i < goal.length(); i++) {
                for (; answerCharacter < answer.length();) {
                    if (goal.charAt(i) != answer.charAt(answerCharacter)) {
                        System.out.print("#");
                        answerCharacter++;
                        break;
                    }
                    System.out.print(goal.charAt(i));
                    answerCharacter++;
                    break;
                }
            }
            addMissingSign();

            answerCharacter = 0;
            tryCount++;
        } while (!goal.equals(answer));
    }

    public static void addMissingSign() {
        for (int i = 0; i < missingSharpSign; i++) {
            System.out.print("#");
        }
    }
}
