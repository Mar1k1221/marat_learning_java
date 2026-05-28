package HomeProjectTwo;



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
        if (size <= 0) {
            System.out.println("Оценок нет, считать нечего! Программа завершена.");
            return;
        }
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
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double average = sum / arr.length;
        if (average >= 4.5) {
            System.out.println("Отлично! Ваша итоговая оценка: " + average);
        } else if (average >= 3.5) {
            System.out.println("Нормально! Ваша итоговая оценка: " + average);
        } else {
            System.out.println("Нужно подтянуть! Ваша итоговая оценка: " + average);
        }
    }

    static double averageWithoutMin(int[] arr) {
        if (arr.length <= 1) {
            System.out.println("Недостаточно оценок для расчета среднего балла без минимальной.");
            return 0;
        }
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
