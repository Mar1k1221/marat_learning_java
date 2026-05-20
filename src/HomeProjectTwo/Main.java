package HomeProjectTwo;

import com.sun.source.tree.BreakTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя ученика: ");
        String name = scanner.nextLine();
        System.out.println("Введите название предмета: ");
        String item = scanner.nextLine();
        System.out.println("Введите количество оценок: ");
        int size = scanner.nextInt();
        int[] grades = new int[size];
        System.out.println("Введите оценки ученика: ");
        for (int i = 0; i < size; i++) {
            grades[i] = scanner.nextInt();
        }

        studentGrades(grades);
        averageScore(grades);
        minGrades(grades);
        maxGrades(grades);
        positiveNegative(grades);
        finalRecommendation(grades);
        averageWithoutMin(grades);

    }

    static void studentGrades(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Оценки ученика: " + arr[i]);
        }
    }

    static double averageScore(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double average = sum / arr.length;
        System.out.println("Средняя оценка ученика: " + average);
        return average;

    }

    static int minGrades(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Минимальная оценка из списка: " + min);
        return min;
    }

    static int maxGrades(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Максимальная оценка из спика: " + max);
        return max;
    }

    static void positiveNegative(int[] arr) {
        int fiveScore = 0;
        int twoScore = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                fiveScore++;
            } else if (arr[i] < 3) {
                twoScore++;

            }

        }
        System.out.println("Количество оценок равных 5: " + fiveScore + "  " + " Количество оценок ниже 3: " + twoScore);
    }

    static void finalRecommendation(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                System.out.println("Отлично! Ваша оценка: " + arr[i]);
            } else if (arr[i] == 4) {
                System.out.println("Нормально! Ваша оценка: " + arr[i]);
            } else {
                System.out.println("Нужно подтянуть! Ваша оценка: " + arr[i]);
            }
        }
    }

    static double averageWithoutMin(int[] arr) {
        int sum = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int finalSum = sum - min;
        double result = (double) finalSum / (arr.length - 1);
        System.out.println("Результат среднего балла без учета слабой оценки : " + result);
        return result;
    }
}
