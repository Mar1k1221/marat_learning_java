package HomeWork6;

import java.util.HashSet;
import java.util.Scanner;

public class DayTwoPartTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> orderHash = new HashSet<>();
        while (true) {
            System.out.println("Введите номер заказа...");
            String result = sc.nextLine();
            int resultParse = Integer.parseInt(result);
            boolean resultContains = orderHash.contains(resultParse);
            if (resultContains) {
                System.out.println("Ошибка. Заказ с таким номером уже существует");
            } else {
                orderHash.add(resultParse);
            }
        }

    }
}

