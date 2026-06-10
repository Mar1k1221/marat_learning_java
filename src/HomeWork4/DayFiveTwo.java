package HomeWork4;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class DayFiveTwo {
    public static void main(String[] args) {
        MagicalCreature magicalCreature1 = new MagicalCreature("Zavr",300,DangerLevel.HIGH);
        MagicalCreature magicalCreature2 = new MagicalCreature("Lokus",176,DangerLevel.MEDIUM);
        MagicalCreature magicalCreature3 = new MagicalCreature("Ruer", 80,DangerLevel.LOW);

        SanctuaryManager sanctuaryManager = new SanctuaryManager();
        sanctuaryManager.addPersonage(magicalCreature1);
        sanctuaryManager.addPersonage(magicalCreature2);
        sanctuaryManager.addPersonage(magicalCreature3);

        sanctuaryManager.printPersonage();
        sanctuaryManager.newStatus("Zavr",DangerLevel.LOW);
        boolean resultSearch =  sanctuaryManager.isThereOne("Lokus");
        System.out.println("Проверка на наличие персонажа в списке - " + resultSearch);
        int resultSum = sanctuaryManager.sumDangerLevel(DangerLevel.HIGH);
        System.out.println("Результат совпадений " + resultSum);
        MagicalCreature magicaled = sanctuaryManager.magicalCreature("dragon");
        if ( magicaled != null){
            System.out.println("Cовпадение найдено. Его имя - " + magicaled.getName());
        } else {
            System.out.println("Совпадений нету.");
        }

    }
}

class MagicalCreature {
    private String name;
    private int age;
    private DangerLevel dangerLevel;

    MagicalCreature(String name, int age, DangerLevel dangerLevel) {
        setName(name);
        setAge(age);
        setDangerLevel(dangerLevel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Имя указано некорректно.");
        }
    }

    public int getAge() {
        return age;

    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным.");
        }
    }

    public DangerLevel getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(DangerLevel dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
}

enum DangerLevel {
    LOW,
    MEDIUM,
    HIGH
}

class SanctuaryManager {
    private ArrayList<MagicalCreature> arrayList = new ArrayList<>();

    void addPersonage(MagicalCreature magicalCreature) {
        arrayList.add(magicalCreature);
    }
    void printPersonage(){
        if (arrayList.isEmpty()){
            System.out.println("Список пуст.");
        }
        for (int i = 0; i< arrayList.size(); i++){
            MagicalCreature m = arrayList.get(i);
            System.out.println((i  + 1) + " Имя персонажа: " + m.getName() + " Возраст: " + m.getAge() + " Уровень опасности: " + m.getDangerLevel());
        }
    }
    void newStatus(String name, DangerLevel dangerLevel){
        boolean isFound = false;
        for (MagicalCreature m:arrayList){
            if (name.equals(m.getName())){
                m.setDangerLevel(dangerLevel);
                System.out.println("Опасность персонажа " + name + " изменилась на - " + dangerLevel);
                isFound = true;
                break;
            }
        } if (!isFound){
            System.out.println("Персонаж с таким именем не был найден.");
        }
    }
    boolean isThereOne(String name){
        boolean search = false;
        for (MagicalCreature m: arrayList){
            if (name.equals(m.getName())){
                search = true;
                return search;
            }
        }
        return  search;
    }
    int sumDangerLevel(DangerLevel dangerLevel){
        int sum = 0;
        for (MagicalCreature m:arrayList){
            if (dangerLevel == m.getDangerLevel()){
                sum++;
            }
        }
        return sum;
    }
    MagicalCreature magicalCreature(String name){
        for (MagicalCreature m: arrayList){
            if (name.equals(m.getName())){
                return m;
            }
        }
        return null;
    }



}