package HomeWork2;

import java.util.Arrays;

public class DayTwo {
    public static void main(String[] args) {
        int[] number = {10, -30, 24, -45, 38, 49, 3, -33};
        System.out.println(Arrays.toString(number));
        numSearch(number);
        numSum(number);
        numMax(number);
        numMin(number);
        numNegative(number);
        numCountTen(number);
    }
    static void numIterate(int [] arr){ ///  Проход по массиву
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    } /// Обычная проходка по массиву, выводящая на экран наши числа.

    static void numSearch(int[] arr) { ///  Линейный поиск по массиву
        int target = 10; /// число которое мы ищем в массиве
        int index = -1; /// ставим значение индекс -1, так как у массивов индексы начинаются с 0
        for (int i = 0; i < arr.length; i++) { /// проходимся по массиву с помощью цикла
            if (arr[i] == target) { /// если число из массива равно числу которое мы ищем
                index = i; /// то переменной index, мы присваиваем индекс числа которое нашли
            }

        }
        if (index != -1) {
            System.out.println("Число в массиве найдено! Находится в ячейке номер: " + index);
        } else {
            System.out.println(" Такого числа в массиве нет.");
        }
    }

    static void numSum(int[] arr) { /// Сумма всех чисел в массиве
        int sum = 0; ///Начальное значение нашей переменной sum
        for (int i = 0; i < arr.length; i++) { /// проходимся по массиву с помощью цикла
            sum += arr[i]; /// прибавляем к переменной sum каждый элемент массива.
        }
        System.out.println("Сумма всех чисел в массиве: " + sum);

    }

    static void numMax(int[] arr) { /// Максимальное число в массиве
        int max = 0; /// изначально максимальное значение будет 0
        for (int i = 0; i < arr.length; i++) { ///  проходимся по массиву с помощью цикла
            if (arr[i] > max) { /// сравниваем элемент массива с переменной max(изначально она была 0)
                max = arr[i]; ///добавляем в переменную мах наше число и так до максимального числа.
            }

        }
        System.out.println("Максимальное число в массиве: " + max);
    }

    static void numMin(int[] arr) { /// Минимальное число в массиве
        int min = arr[0]; /// в переменную min мы добавляем число из массива под индексом 0
        for (int i = 0; i < arr.length; i++) { /// проходимся по массиву с помощью цикла
            if (arr[i] < min) { /// сравниваем числа массива с числом находящимся на индексе 0 (arr[0])
                min = arr[i]; /// присваиваем переменной min значение минимального числа из массива.
            }
        }
        System.out.println("Минимальное число в массиве: " + min);
    }

    static void numNegative(int[] arr) { /// Булев флаг
        boolean negativeNumber = false; /// изначально мы подняли флаг на (false), далее работаем уже с этим условием
        for (int i = 0; i < arr.length; i++) { /// проходимся по массиву с помощью цикла
            if (arr[i] < 0) { /// сравниваем элементы нашего массива с 0, если элемент меньше 0
                negativeNumber = true; /// то поднимаем флаг(переменной negativeNumber присваиваем значение false)
                break; /// завершает цикл
            }
        }
        if (negativeNumber) { /// если условие true, то выведет данной сообщение
            System.out.println("В массиве есть отрицательное число!");
        } else { /// если false, то это
            System.out.println("В массиве нету отрицательных чисел!");
        }
    } static void numCountTen(int [] arr) { /// Количество чисел больше 10 в массиве
        int count =0; /// изначальное значение счестика 0
        for (int i =0; i < arr.length; i ++){ /// проходимся по массиву с помощью цикла
            if (arr[i] > 10){ /// если элемент массива больше 10
                count++;/// то счетчик прибавляет +1
            }
        }
        System.out.println("Количество чисел >= 10 равно: " + count); ///тут выводим количество чисел >10
    }


    }



