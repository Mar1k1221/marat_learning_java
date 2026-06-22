package HomeWork5;

import java.util.ArrayList;
import java.util.Scanner;

public class DayFivePartTwo {
    public static void main(String[] args) {
        ManagerShip managerShip = new ManagerShip();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---Меню---");
            System.out.println("[1] Зарегистрировать корабль");
            System.out.println("[2] Вывести табло кораблей");
            System.out.println("[3] Рассчитать время миссии");
            System.out.println("[0] Отключить терминал");
            int resultMenu = sc.nextInt();
            sc.nextLine();
            switch (resultMenu) {
                case 1:
                    try {
                        System.out.println("Введите имя корабля: ");
                        String nameShip = sc.nextLine();
                        if (nameShip.length() < 3){
                            System.out.println("Позывной не может быть короче 3-х символов");
                            continue;
                        }
                        System.out.println("Укажите количество топлива в тоннах: ");
                        int fuelResult = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Выберите состояние корабля: ");
                        String resultEnum = sc.nextLine();
                        ReactorStatus reactorStatus = ReactorStatus.valueOf(resultEnum.toUpperCase());
                        System.out.println("Введите тип корабля. [1] - грузовой, [2] - пассажирский.");
                        int resultShipType = sc.nextInt();
                        if (resultShipType == 1) {
                            CargoShuttle cargoShuttle1 = new CargoShuttle(nameShip, fuelResult, reactorStatus);
                            managerShip.addShip(cargoShuttle1);
                        } else {
                            PassengerCruiser passengerCruiser1 = new PassengerCruiser(nameShip, fuelResult, reactorStatus);
                            managerShip.addShip(passengerCruiser1);
                        }
                    } catch (Exception e) {
                        System.out.println("Неправильный ввод символов.");
                    }
                    break;


                case 2:
                    managerShip.ShipDisplay();
                    break;
                case 3:
                    System.out.println("Введите киллометраж по которому произвести расчет:");
                    int resultCalculation = sc.nextInt();
                    sc.nextLine();
                    managerShip.FlightСalculation(resultCalculation);

                    break;
                case 0:
                    System.out.println("Завершение программы...");
                    System.exit(0);

            }
        }
    }
}

class ManagerShip {
    private ArrayList<SystemShip> arrayList = new ArrayList<>();

    public void ShipDisplay() {
        for (SystemShip s : arrayList) {
            System.out.println("Имя корабля " + s.getCallSign() + " запас топлива: " + s.getFuelCapacity() + " Статус корабля: " + s.getReactorStatus());
        }
    }

    public void FlightСalculation(int km) {
        for (SystemShip s : arrayList) {
            int time = s.countDistance(km);
            System.out.println("Корабль " + s.getCallSign() + " достигнет цели за " + time + " ч.");

        }
    }

    public void addShip(SystemShip s) {
        arrayList.add(s);
    }

}

abstract class SystemShip implements Navigable {
    private String callSign;
    private int fuelCapacity;
    private ReactorStatus reactorStatus;

    public SystemShip(String callSign, int fuelCapacity, ReactorStatus reactorStatus) {
        setCallSign(callSign);
        setFuelCapacity(fuelCapacity);
        this.reactorStatus = reactorStatus;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        if (fuelCapacity <= 0) {
            throw new IllegalArgumentException("Аварийная ситуация. Бак топлива не может быть 0 или меньше нуля.");
        }
        this.fuelCapacity = fuelCapacity;
    }

    public ReactorStatus getReactorStatus() {
        return reactorStatus;
    }

    public abstract int countDistance(int distance);


}

enum ReactorStatus {
    STANDBY,
    ACTIVE,
    OFFLINE
}

interface Navigable {
    public int countDistance(int distance);

}

class CargoShuttle extends SystemShip implements Navigable {
    public CargoShuttle(String callSign, int fuelCapacity, ReactorStatus reactorStatus) {
        super(callSign, fuelCapacity, reactorStatus);
    }

    @Override
    public int countDistance(int distance) {
        return (distance + 60) * 3;
    }
}

class PassengerCruiser extends SystemShip implements Navigable {
    public PassengerCruiser(String callSign, int fuelCapacity, ReactorStatus reactorStatus) {
        super(callSign, fuelCapacity, reactorStatus);
    }

    @Override
    public int countDistance(int distance) {
        return (distance + 60) * 4;
    }
}
