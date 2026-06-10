package HomeWork4;

import java.util.ArrayList;
import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {
        Auto BMW = new Auto("BMW", 773, Condition.NORMAL);
        Auto Merc = new Auto("Mercedes", 001, Condition.AVERAGE);
        Auto VW = new Auto("Volkswagen", 878, Condition.BAD);

        AutoManager autoManager = new AutoManager();
        autoManager.addAuto(BMW);
        autoManager.addAuto(Merc);
        autoManager.addAuto(VW);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - показать весь автопарк");
            System.out.println("2 - добавить автомобиль");
            System.out.println("3 - удалить автомобиль");
            System.out.println("4 - изменить состояние автомобиля");
            System.out.println("5 - удалить автомобиль по индексу");
            System.out.println("0 - выход");

            int result = Integer.parseInt(scanner.nextLine());
            if (result == 0) {
                System.out.println("Выход из программы...");
                break;

            }
            switch (result) {
                case 1:
                    autoManager.printAuto();
                    break;
                case 2:
                    System.out.println("---Укажите марку автомобиля---");
                    String autoAdd = scanner.nextLine();
                    System.out.println("---Укажите регистрационный номер---");
                    int resultAdd = Integer.parseInt(scanner.nextLine());
                    System.out.println("---Укажите состояние автомобиля - BAD(ПЛОХОЕ), NORMAL(ХОРОШЕЕ), AVERAGE(СРЕДНЕЕ) ---");
                    String resultCondition = scanner.nextLine();
                    Condition condition = Condition.valueOf(resultCondition.toUpperCase());
                    Auto auto = new Auto(autoAdd, resultAdd, condition);
                    autoManager.addAuto(auto);
                    System.out.println("Автомобиль был успешно добавлен.");

                    break;

                case 3:
                    System.out.println(" ---Введите название автомобиля для удаления из базы--- ");
                    String nameResultRemove = scanner.nextLine();
                    autoManager.removeAuto(nameResultRemove);

                    break;
                case 4:
                    System.out.println("---Введите название автомобиля для изменения состояние---");
                    String newCondition = scanner.nextLine();
                    System.out.println("---Укажите новое состояние---");
                    String newEnum = scanner.nextLine();
                    Condition condition1 = Condition.valueOf(newEnum.toUpperCase());
                    autoManager.newCondition(newCondition, condition1);

                    break;
                case 5:
                    System.out.println("Введите индекс автомобиля который хотите удалить из списка.");
                    int index = Integer.parseInt(scanner.nextLine());
                    autoManager.removeIndexAuto(index);
                    break;

            }
        }


    }
}


class Auto {
    private String name;
    private int registrationNumber;
    private Condition condition;


    Auto(String name, int registrationNumber, Condition condition) {
        setName(name);
        setRegistrationNumber(registrationNumber);
        setCondition(condition);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Марка машины не может быть пустой.");
        }
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        if (registrationNumber > 0) {
            this.registrationNumber = registrationNumber;
        } else {
            System.out.println("Регистрационный номер машины не может быть пустым.");
        }
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}

enum Condition {
    NORMAL, AVERAGE, BAD
}

class AutoManager {
    private ArrayList<Auto> arrayAuto = new ArrayList<>();

    public void addAuto(Auto auto) {
        arrayAuto.add(auto);
    }

    public void removeAuto(String name) {
        boolean isFound = false;
        for (int i = 0; i < arrayAuto.size(); i++) {
            Auto a = arrayAuto.get(i);
            if (name.equals(a.getName())) {
                arrayAuto.remove(i);
                isFound = true;
                System.out.println("Машина бренда " + name + " успешно удалена.");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Машина с таким названием не найдена.");
        }
    }

    public void printAuto() {
        if (arrayAuto.isEmpty()) {
            System.out.println("В автопарке пока что  нету ни 1 машины.");
        } else {
            for (int i = 0; i < arrayAuto.size(); i++) {
                Auto a = arrayAuto.get(i);
                System.out.println((i + 1) + " - " + " Название машины: " + a.getName() +
                        " Номер машины: " + a.getRegistrationNumber() +
                        " Состояние машины: " + a.getCondition());
            }

        }
    }

    public void newCondition(String name, Condition condition) {
        boolean isFound = false;
        for (Auto a : arrayAuto) {
            if (name.equals(a.getName())) {
                a.setCondition(condition);
                System.out.println("Состояние машины " + a.getName() + " изменилось на " + condition);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Машина не найдена.");
        }


    }

    public void removeIndexAuto(int index) {
        int usernumber = index - 1;
        if (usernumber >= arrayAuto.size() || index < 0) {
            System.out.println("Вы ввели некорректный индекс.");
            return;
        }
        if (usernumber <= arrayAuto.size()) {
            arrayAuto.remove(usernumber);
            System.out.println("Обьект успешно был удален.");
        }
    }
}



