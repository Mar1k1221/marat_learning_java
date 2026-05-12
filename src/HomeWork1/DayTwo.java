package HomeWork1;

import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) {
        /// Анкета
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name = sc.nextLine();
        System.out.println("Введите ваш возраст: ");
        int age = sc.nextInt();
        System.out.println("Сбор информации для анкеты завершен успешно!");


        ageInYear();
        minInHours();
        areaAndPerimetr();


        sc.close();
    }

    /// Возраст через год
    static void ageInYear() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваш возраст на данный момент: ");
        int age = sc.nextInt();
        int nextAge = age + 1;
        System.out.println("Через год вам будет: " + nextAge);

    }


    /// Перевод минут в часы и минуты
    static int minInHours() {
        int minutes = 150;
        double hourse = (double) minutes / 60;
        System.out.println("минуты " + minutes + " часы " + hourse);
        int hourse2 = 3;
        int minutes2 = hourse2 * 60;
        System.out.println("часы " + hourse2 + " минуты " + minutes2);
        return minutes;
    }

    /// Площадь и периметр прямоугольника
    static void areaAndPerimetr() {
        int length = 10;
        int width = 6;
        int result1 = length * width;
        System.out.println("Площадь: " + result1);
        int result2 = 2 * (length + width);
        System.out.println("Периметр: " + result2);
    }

}