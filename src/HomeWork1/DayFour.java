package HomeWork1;

import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {
   ///1
    for (int i = 1;i <= 50; i++){
        if (i % 2 == 0){
            System.out.println(i);
        }
    }
   ///2
    for (int a =1 ; a <= 100; a++){
        if (a % 3 ==0 && a % 5 == 0) {
            System.out.println("FizzBuzz");

        } else if (a % 5 ==0) {
            System.out.println("Buzz");

        } else if (a % 3 ==0 ) {
            System.out.println("Fizz");

        } else {
            System.out.println(a);
        }

    }
        int number = 12645; ///3
        int sum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            sum = sum + lastDigit;
            number = number / 10;
        }

        System.out.println("Сумма цифр: " + sum);
double deposit = 1000.0; ///4
int years = 0;

while (deposit <= 2000.0){
    deposit = deposit * 1.05;
    years++;
}
        System.out.println("Понадобится лет: " + years);
        System.out.println("Итоговая сумма депозита: " + deposit);

        Scanner scanner = new Scanner(System.in); ///5
        String realPassword = "JavaBuss";
        String userPassword;
        do {
            System.out.println("Введите ваш пароль");
            userPassword = scanner.nextLine();
            System.out.println("Вы ввели: " + userPassword);
        } while (!userPassword.equals("JavaBuss"));
        System.out.println("Программа завершенна!");
        scanner.close();


        int height = 5; ///6
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        String word = "Programming"; /// 7
        System.out.print("Слово задом наперед: ");
        for (int i = word.length() - 1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }
        System.out.println();
    }
}

