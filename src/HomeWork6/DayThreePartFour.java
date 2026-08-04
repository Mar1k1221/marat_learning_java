package HomeWork6;

import java.util.HashMap;

public class DayThreePartFour {
   public  static void main(String[] args) {
        String [] word = {"NEW", "IN_PROGRESS", "DONE", "NEW", "DONE"};
        HashMap<String,Integer> hashMap = addCounter(word);
       System.out.println(hashMap);

    }
    public static HashMap<String,Integer> addCounter(String [] word){
       HashMap<String,Integer> newHashMap = new HashMap<>();
       for (String w:word){

           newHashMap.put(w, newHashMap.getOrDefault(w,0)+1);
       } return newHashMap;
    }
}
