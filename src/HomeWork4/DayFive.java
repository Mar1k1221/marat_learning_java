package HomeWork4;

import java.util.ArrayList;

public class DayFive {
    public static void main(String[] args) {
Spaceship spaceship1 = new Spaceship("Zurkan",290,MissionType.COMBAT);
Spaceship spaceship2 = new Spaceship("Alivia",78,MissionType.DIPLOMACY);
Spaceship spaceship3 = new Spaceship("Loras",170,MissionType.EXPLORATION);
FleetManager fleetManager = new FleetManager();
fleetManager.addSpaceShip(spaceship1);
fleetManager.addSpaceShip(spaceship2);
fleetManager.addSpaceShip(spaceship3);
System.out.println("Результат поиска корабля " + fleetManager.ShipSearch("Loras"));
fleetManager.printSpaceShip();
int resultSum = fleetManager.sumMissionType(MissionType.COMBAT);
        System.out.println("Количество совпадений " + resultSum);
        fleetManager.newMissionType("Zurkan",MissionType.CARGO);

Spaceship spaceshipResult = fleetManager.getSpaceship("Alivia");
if (spaceshipResult != null){
    System.out.println("Корабль найден, его миссия " + spaceshipResult.getMissionType());
    System.out.println("Его вместимость:  " + spaceshipResult.getCapacity());
} else {
    System.out.println("Корабль с таким названием не найден.");
}


    }
}
class Spaceship{
    private String name;
    private int capacity;
    private MissionType missionType;

    Spaceship(String name, int capacity, MissionType missionType){
        setName(name);
        setCapacity(capacity);
        setMissionType(missionType);

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if (name != null && !name.trim().isEmpty()){
            this.name = name;
        } else {
            System.out.println("Имя корабля введено не корректно.");
        }
    }
    public int getCapacity(){
        return capacity;

    }
    public void setCapacity(int capacity){
        if (capacity > 0 && capacity < 300){
            this.capacity = capacity;
        }
        else {
            System.out.println("Вместимость экипажа указана неверно.");
        }
    }
    public MissionType getMissionType(){
        return missionType;
    }
    public void setMissionType(MissionType missionType){
        this.missionType = missionType;
    }
}
enum MissionType{
    EXPLORATION,
    COMBAT,
    CARGO,
    DIPLOMACY
}
class FleetManager{
    private ArrayList<Spaceship> arrayList = new ArrayList<>();


    public void addSpaceShip(Spaceship spaceship){
        arrayList.add(spaceship);
        System.out.println("Обьект успешно добавлен.");
    }
    public void printSpaceShip(){
        if (arrayList.isEmpty()){
            System.out.println("Список пуст. Для начала заполните его.");
        }
        for (int i = 0; i < arrayList.size(); i ++){
            Spaceship s = arrayList.get(i);
                    System.out.println((i + 1) + " Название корабля " + s.getName() + " Вместимость экипажа: " + s.getCapacity() + " Вид корабля: " + s.getMissionType());
        }
    }
    public boolean ShipSearch(String name){
        boolean isFound = false;
        for (Spaceship s: arrayList){
            if (name.equals(s.getName())){
                isFound = true;
                break;
            }


        }
        return isFound;
    }
    public int sumMissionType(MissionType missionType){
        int sum = 0;
        for (Spaceship s: arrayList){
            if (missionType == s.getMissionType()){
                sum++;
            }
        }
        return sum;
    }
    public void newMissionType(String name, MissionType missionType){
        boolean isFound2 = false;
        for (Spaceship s: arrayList){
            if (name.equals(s.getName())){
                s.setMissionType(missionType);
                isFound2 = true;

                System.out.println("Тип корабля был успешно измене на " + missionType);
                break;
            }
        }  if (!isFound2){
            System.out.println("Корабль не был найден.");
        }
    }
    public Spaceship getSpaceship(String name){
        for (Spaceship s: arrayList){
            if (name.equals(s.getName())){
                return s;
            }
        }
    return null;
    }
}
