package ru.geekbrains;
import java.util.Arrays;
import java.util.Collections;

public class lesson2 {

    static Integer[] task1array = new Integer[15];
    static int[] task2array = new int[8];
    static int[] task3array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    static Integer[] task5array = new Integer[9];


    public static void main(String[] args) {

        invertArray();

        fillArrayBy3Step();

        task3func();

        fillDiagonal(7);

        minAndMaxValues();
    }

    //    MARK: - task № 1
    public static void generateRandomArray(Integer[] someArray, int
            itemMaxValue, int itemMinValue) {
        for(int i = 0; i < someArray.length; i++){
            someArray[i] = (int)(Math.random() * (itemMaxValue + 1) - itemMinValue); // генерация массива с 0 и 1
        }

    }

    public static void invertArray() {
        generateRandomArray(task1array, 1, 0); // для переиспользования ф-ции
        System.out.println("Задание № 1\n" + Arrays.toString(task1array) + " изначально сгенерированный массив");
        for (int i = 0; i < task1array.length; i++) {
            switch (task1array[i]) {
                case 1 -> task1array[i] = 0;
                case 0 -> task1array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(task1array) + " инвертированный массив" + "\n");
    }

    //    MARK: - task № 2
    public static void fillArrayBy3Step() {
        System.out.println("Задание № 2\n" + Arrays.toString(task2array) + " базовый массив из задания № 2");
        for(int i = 1; i < task2array.length; i++){
            task2array[i] = task2array[i - 1] + 3;
        }
        System.out.println(Arrays.toString(task2array) + " массив с шагом 3" + "\n");
    }

    //    MARK: - task № 3
    public static void task3func() {
        System.out.println("Задание № 3\n" + Arrays.toString(task3array) + " базовый массив из задания № 3");
        for(int i = 0; i < task3array.length; i++){
            if (task3array[i] < 6) {
                task3array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(task3array) + " массив умноженных чисел, которые меньше 6" + "\n");
    }

    //    MARK: - task № 4
    public static void fillDiagonal(int sideSize) {
        int[][] task4array = new int[sideSize][sideSize];
        System.out.println("Задание № 4");

        for (int i = 0; i < sideSize; i++) {
            int fff = 0;
            for (int j = 0; j < sideSize; j++) {
                task4array[j][j] = 1;
                task4array[j][task4array.length - ++fff] = 1;
            }
        }

        for (int[] deep: task4array) {
            for (int num: deep) {
                System.out.printf("%2d", num);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    //    MARK: - task № 5
    public static void minAndMaxValues() {
        generateRandomArray(task5array, 100, 0);
        System.out.println("Задание № 5\n" + Arrays.toString(task5array) + " массив рандомных значений, задание № 5");

        Arrays.sort(task5array, Collections.reverseOrder());

        System.out.println(Arrays.toString(task5array) + " отсортированный массив");
        System.out.println(task5array[0] + " - макс значение");
        System.out.println(task5array[task5array.length - 1] + " - мин значение");
    }
}
