package HomeProjectOne;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Number num = new Number();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число ");
        int number = scanner.nextInt();
        num.isEven(number);
        num.isNegative(number);
        System.out.println("Таблица умножения числа " + number + " : ");
        num.multiplicationTable(number);
        System.out.println("Количество символов: " + num.isLength(+number));
        System.out.println("Сумму чисел:  " + num.sum(number));
        if (number >= 0 && number <= 12) {
            System.out.println("Факториал числа " + number + " = " + num.factorial(number));
        } else {
            System.out.println("Факториал не вычисляется число должно быть от 0 до 12");
        }

        scanner.close();
    }

    static class Number {
        public void isEven(int number) {
            if (number % 2 == 0) {
                System.out.println("Число четное!");
            } else {
                System.out.println("Число нечетное!");

            }
        }

        public void isNegative(int number) {
            if (number == 0) {
                System.out.println("Число равно 0");
            } else if (number > 0) {
                System.out.println("Число положительное");
            } else if (number < 0) {
                System.out.println("Число отрицательное");
            }
        }

        public int isLength(int number) {
            int length = String.valueOf(Math.abs(number)).length();
            return length;
        }

        public int sum(int number) {
            int sum = 0;


            for (int i = 1; i <= number; i++) {
                sum += i;
            }

            return sum;
        }

        public void multiplicationTable(int number) {

            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " * " + i + " = " + (number * i));
            }
        }

        public long factorial(int number) {

            int result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;
        }
    }

}
