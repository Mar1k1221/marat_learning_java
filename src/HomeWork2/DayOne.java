package HomeWork2;

public class DayOne {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]); ///Вывод элементов массива
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Сумма всех элементов массива: " + sum); ///Сумма всех элементов массива

        int[] numbers2 = {20, 10, -10, 30, 31};
        int max = numbers2[0];
        for (int i = 0; i < numbers2.length; i++) {
            if (numbers2[i] > max) {
                max = numbers2[i];
            }


        }
        System.out.println("Максимальное число в массиве: " + max); ///Максимальное число в массиве

        int[] numbers3 = {10, -5, -7, 30, 17};
        int min = numbers3[0];
        for (int i = 0; i < numbers3.length; i++) {
            if (numbers3[i] < min) {
                min = numbers3[i];
            }
        }
        System.out.println("Минимальное число в массиве: " + min);

        int[] numbers4 = {11, 17, 32, 8, 21};
        int count = 0;
        for (int number : numbers4) {
            if (number % 2 == 0) {
                count++;
            }

        }
        System.out.println("Количество четных чисел в массиве: " + count); /// Количество четных элементов в массиве
        int[] numbers5 = {-9, 3, -10, 30, -50, -30};
        int count1 = 0;
        for (int i = 0; i < numbers5.length; i++) {
            if (numbers5[i] >= 0) {
                count1++;
            }
        }
        System.out.println("Количество положительных чисел в массиве: " + count1); /// Количество положительных элементов в массиве
 int [] numbers6 = {1,2,3,4,5,6,7,8,9,10};
 for (int i = numbers6.length -1; i>=0; i--){
//     System.out.println(numbers6[i]); /// Массив в обратном порядке
 }

 int[] numbers7 = {11,3,4,10,5};
 double sum1 = 0;

 for (int i = 0; i<numbers7.length; i++){
     sum1+=numbers7[i];

 } double average = sum1 / numbers7.length;
        System.out.println("Среднее арифметическое массив: " + average);
    }
}
