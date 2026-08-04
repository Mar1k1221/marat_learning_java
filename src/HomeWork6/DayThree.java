package HomeWork6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DayThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Алиса", "+88005553535");
        phoneBook.put("Марат", "+89099993311");
        phoneBook.put("Олег", "+89797788331");
        while (true) {
            System.out.println("Введите имя человека для поиска...");
            String searchName = sc.nextLine();
            if (phoneBook.containsKey(searchName)) {
                System.out.println(phoneBook.get(searchName));
            } else {
                System.out.println("Человека с таким именем нет в телефонной книге.");

            }
        }
    }
}




