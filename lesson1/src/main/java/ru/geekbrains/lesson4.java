package ru.geekbrains;


import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    static int size = 30;

    private static final String SPACE_MAP = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char[][] MAP = new char[size][size];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();

    static int turnsCount = 0;
    private static int dotsToWin = 3;

    public static void main(String[] args) {
        turnGame();
    }

    private static void turnGame() {
        do {
            sizeChoice();
            init();
            printMap();
            playGame();
        } while (isContinueGame());

        endGame();
    }

    private static void sizeChoice() {
        System.out.println("Веедите число - сторону игрового поля от 3 до 30");
        size = in.nextInt();
        if (size > 2 && size < 7) {
            dotsToWin = 3;
        } else if (size > 6 && size < 11) {
            dotsToWin = 4;
        } else {
            dotsToWin = 5;
        }
    }

    private static void init() {
        initMap();

        turnsCount = 0;
    }

    private static void initMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printBodyMap() {
        for (int i = 0; i < size; i++) {
            putSpaceFrom1To9(i);
            printMapNumber(i);
            for (int j = 0; j < size; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP + "  ");
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(" " + (i + 1) + SPACE_MAP);
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < size; i++) {
            putSpaceFrom1To9(i);
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void putSpaceFrom1To9(int i) {
        if (i<9) {
            System.out.print(" ");
        }
    }

    private static void playGame() {
        System.out.println("\nИГРА НАЧИНАЕТСЯ!");
        do{
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        } while (true);
    }

    private static void humanTurn() {

        int rowNumber;
        int columnNumber;
        System.out.println("\nХод ЧЕЛОВЕКА!");

        do {
            rowNumber = getNumberFromScanner() - 1;
            columnNumber = getNumberFromScanner() - 1;
        } while (!isHumanTurnValid(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;

    }

    private static int getNumberFromScanner() {
        int number = 0;
        boolean isValid = false;
        do {
            System.out.print("Введите координату: ");
            if (in.hasNextInt()) {
                number = in.nextInt();
                isValid = true;
            } else {
                in.next();
            }
        } while (!isValid);

        return number;
    }

    private static boolean isHumanTurnValid(int rowNumber, int columnNumber) {
        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nПроверьте значение строки и столбца. Должны быть от 1 до " + size);
            return false;
        }
        if (!isCellFree(rowNumber, columnNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }
        return true;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return rowNumber < size && rowNumber >= 0 && columnNumber < size && columnNumber >= 0;
    }

    private static void aiTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод компьютера");
        do {
            rowNumber = random.nextInt(size);
            columnNumber = random.nextInt(size);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;

    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("УРА! Вы победили!");
            }
            else {
                System.out.println("Восстание близко... Компьютер победил...");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {

        int winToD1 = 0,  winToD2 = 0;

        for (int i = 0; i < size; i++) {
            int winToCol = 0, winToRow = 0;

            for (int j = 0; j < size; j++) {
                if (MAP[i][j] == symbol) winToRow++;
                if (MAP[j][i] == symbol) winToCol++;
            }
            //System.out.println(" S: " + symb + " R: " + winToRow + " C: " + winToCol);

            // условия победы
            if (winToRow == dotsToWin || winToCol == dotsToWin) return true;

            // диоганали
            if (MAP[i][i] == symbol) winToD1++;
            if (MAP[i][MAP[i].length-i-1] == symbol) winToD2++;
        }

        //System.out.println(" S: " + symb + " D1: " + winToD1 + " D2: " + winToD2);
        // условия победы
        if (winToD1 == dotsToWin || winToD2 == dotsToWin) return  true;

        return false;
    }

    private static boolean checkDraw() {
        return turnsCount == size * size;
    }

    private static void endGame() {
        System.out.println("Ты заходи если что");
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "+", "д", "да" -> true;
            default -> false;
        };
    }
}

