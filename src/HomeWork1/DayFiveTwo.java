package HomeWork1;

import java.util.Scanner;

public class DayFiveTwo {
    public static void main(String[] args) {

        Number num = new Number();
      ///  System.out.println(num.MaxOnTwo(10,25));
        Scanner sc = new Scanner(System.in);
        System.out.println(num.isEven(10));
        System.out.println("Введите два числа и мы сравним их");
        System.out.println("Введите первое число");
        int num1 = sc.nextInt();
        System.out.println("Введите второе число");
        int num2= sc.nextInt();
        int max= num.MaxOnTwo(num1,num2);
        System.out.println(" Число " + max + " больше " );


    }

    static class Number {

        public int MaxOnTwo(int num1, int num2) {
            if (num1 > num2) {
                return num1;

            } else {
                return num2;
            }
        }
        public boolean isEven(int a){
             return (a % 2 ==0);
            }
        }
    }
