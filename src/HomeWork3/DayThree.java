package HomeWork3;

import java.util.ArrayList;
import java.util.List;

public class DayThree {
    public static void main(String[] args) {
        List<String> ingredient = new ArrayList<>();
        ingredient.add("Морковь");
        ingredient.add("Лук");
        ingredient.add("Редис");
        ingredient.add("Укроп");
        ingredient.add("Салат");
        ingredient.remove(3);
        ingredient.set(0,"Оливковое масло");
        for (String s:ingredient){
            System.out.println(s);
        }

        List<Supplement> supplements = new ArrayList<>();
        Supplement omega = new Supplement("Omega",1100);
        Supplement d3 = new Supplement("d3",400);
        Supplement zinc = new Supplement("zinc",600);
        supplements.add(omega);
        supplements.add(d3);
        supplements.add(zinc);
        for (Supplement s:supplements){
           if (s.dosage > 1000){
               System.out.println("Витамин с дозировкой больше 1000мг:  " + s.name);
           }
        }
        List<String> git = new ArrayList<>();
        git.add("master");
        git.add("dev");
        git.add("feature-1");
        git.add("bugfix");
        git.remove("bugfix");
        git.clear();
        System.out.println(git.isEmpty());
        for (int i = 0; i< git.size(); i ++){
            System.out.println(git.get(i));
        }
       ArrayList<Integer> steps = new ArrayList<>();
        steps.add(5000);
        steps.add(4300);
        steps.add(17000);
        steps.add(9000);
        steps.add(6500);
        int maxSteps = getMaxSteps(steps);
        System.out.println("Максимальное количество шагов: " + maxSteps);

        ArrayList<String> promocode = new ArrayList<>();
        promocode.add("MAЙ20");
        promocode.add("ДЖАВА50");
        promocode.add("ЕЕРРЗЗ303");
        promocode.add("PRO_GAME");
        int resultLength = countValidCodes(promocode);
        System.out.println("Количество промокодов превышающих 5 символов: " + resultLength);

        PullRequest pl1= new PullRequest("hhh",3);
        PullRequest pl2= new PullRequest("aaa",5);
        PullRequest pl3= new PullRequest("jjj",7);
        ArrayList<PullRequest> plList = new ArrayList<>();
        plList.add(pl1);
        plList.add(pl2);
        plList.add(pl3);
        int resultPR = calculateTotalFiles(plList);
        System.out.println("Общее количество измененых файлов: " + resultPR);

    }
    static int calculateTotalFiles(ArrayList<PullRequest> arr){
        int sum = 0;
        for (int i = 0; i < arr.size(); i++){
            sum +=arr.get(i).changeFiles;
        }

        return sum;
    }
    static int getMaxSteps(ArrayList<Integer> arr){
        int max = arr.get(0);
        for (Integer i:arr){
            if ( i > max){
                max=i;
            }

        }
        return max;


}
static int countValidCodes(ArrayList<String> arr){
        int count = 0;
        for (String s:arr){
            if (s.length() > 5){
                count++;
            }
        } return count;
}
static class Supplement {
    String name;
    int dosage;
    Supplement(String name, int dosage){
        this.name=name;
        this.dosage=dosage;
    }

}
static class PullRequest{
        String title;
        int changeFiles;
        PullRequest(String title, int changeFiles){
            this.title = title;
            this.changeFiles = changeFiles;
        }

}


}

