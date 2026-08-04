package HomeWork6;

import java.util.HashMap;
import java.util.Map;

public class DayThreePartThree {
    public static void main(String[] args) {
        HashMap<String,Integer> department = new HashMap<>();
        department.put("Developer",13);
        department.put("Manager",10);
        department.put("HR",5);
        addCount(department,"Developer");
        System.out.println(department);
    }
    public static void addCount(HashMap<String,Integer> hashMap,String name){
       hashMap.put(name, hashMap.getOrDefault(name,0)+1);
    }
}
