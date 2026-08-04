package HomeWork6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DayTwoPartThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Введите целое предложение...");
            String resultInput = sc.nextLine();
            HashSet<String> hashString = new HashSet<>();
            String [] stringMassive = resultInput.toLowerCase().split(" ");
           for (String s:stringMassive){
               hashString.add(s);
           }
           for (String s:hashString){
               System.out.println(s);
           }
        }
    }
}
