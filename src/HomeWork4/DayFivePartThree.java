package HomeWork4;

import java.util.ArrayList;
import java.util.Scanner;

public class DayFivePartThree {
public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Investigation investigation1= new Investigation("Первое дело",1,Status.IN_PROGRESS);
        Investigation investigation2= new Investigation("Второе дело",4,Status.OPEN);
        Investigation investigation3= new Investigation("Третье  дело",7,Status.COLD);
        AgencyManager agencyManager = new AgencyManager();
        agencyManager.addInvestignation(investigation1);
        agencyManager.addInvestignation(investigation2);
        agencyManager.addInvestignation(investigation3);
        while(true){
            System.out.println("1 - добавить дело в список ");
            System.out.println("2 - распечатать весь архив ");
            System.out.println("3 - обновление статуса в деле ");
            System.out.println("4 - поиск дела в архиве (true/false)");
            System.out.println("5 - количество дел со схожим статусом ");
            System.out.println("6 - поиск по названию дела (обьект или null) ");
            System.out.println("0 - выход из программы");
            int resultScanner= Integer.parseInt(scanner.nextLine());
            if (resultScanner == 0){
                System.out.println("Выход из программы...");
                break;
            }
            switch (resultScanner){
                case 1:
                    System.out.println("---Укажите название дела---");
                    String addName= scanner.nextLine();
                    System.out.println("---Укажите количество подозреваемых---");
                    int addSuspect = Integer.parseInt(scanner.nextLine());
                    System.out.println("---Укажите состояние дела - COLD, OPEN, IN_PROGRESS, CLOSED. Строго как указано в примере!");
                    String addStatus = scanner.nextLine();
                    Status st = Status.valueOf(addStatus.toUpperCase());
                    Investigation NewInvestigation = new Investigation(addName,addSuspect,st);
                    agencyManager.addInvestignation(NewInvestigation);
                    System.out.println("Дело успешно добавлено.");
                    break;
                case 2:
                    agencyManager.printInvestignation();
                    break;
                case 3:
                    System.out.println("---Введите название дела в котором нужно изменить статус---");
                    String newStatus = scanner.nextLine();
                    System.out.println("---Введите новый статус---");
                    String status = scanner.nextLine();
                    Status status1 = Status.valueOf(status.toUpperCase());
                    agencyManager.newStatus(newStatus,status1);
                    System.out.println("Статус успешно изменен.");
                    break;
                case 4:
                    System.out.println("---Введите название дела для поиска---");
                    String res = scanner.nextLine();
                    System.out.println("Результат поиска совпадений - " + agencyManager.isInvestigtation(res));
                    break;
                case 5:
                    System.out.println("Введите статус для нахождения похожих дел");
                    String s = scanner.nextLine();
                    Status status2 = Status.valueOf(s.toUpperCase());
                    int result = agencyManager.statusCount(status2);
                    System.out.println("Результат совпадений: " + result);
                    break;
                case 6:
                    System.out.println("---Введите название дела---");
                    String s2 = scanner.nextLine();

                    Investigation foundCase = agencyManager.investigation(s2);

                    if (foundCase != null){
                        System.out.println("Совпадение найдено. Подозреваемых: " + foundCase.getSuspectCount());
                    } else {
                        System.out.println("Совпадений не было найдено.");
                    }
                    break;
            }


        }

    }


}

class Investigation {
    private String title;
    private int suspectCount;
    private Status statusl;


    Investigation (String title, int suspectCount, Status status){
        setTitle(title);
        setSuspectCount(suspectCount);
        setStatusl(status);

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Название дела не может быть пустым.");
        }
    }

    public int getSuspectCount() {
        return suspectCount;
    }

    public void setSuspectCount(int suspectCount) {
        if (suspectCount >= 0) {
            this.suspectCount = suspectCount;
        } else {
            System.out.println("Количество подозреваемых не может быть меньше 0.");
        }
    }

    public Status getStatusl() {
        return statusl;
    }

    public void setStatusl(Status statusl) {
        this.statusl = statusl;
    }
}

enum Status {
    OPEN,
    IN_PROGRESS,
    CLOSED,
    COLD

}

class AgencyManager {
    private ArrayList<Investigation> arrayList = new ArrayList<>();



    void addInvestignation(Investigation investigation){
        arrayList.add(investigation);

    }
    void printInvestignation(){
        if (arrayList.isEmpty()){
            System.out.println("Список пуст.");
        }
        for (int i = 0; i < arrayList.size(); i++){
            Investigation inv = arrayList.get(i);
            System.out.println((i + 1) + "Название дела: " + inv.getTitle() + " Количество подозреваемых: " + inv.getSuspectCount() + " Статус: " + inv.getStatusl());
        }
    }
    void newStatus(String name, Status status){
        for (Investigation i: arrayList){
            if (name.equals(i.getTitle())){
                i.setStatusl(status);
                return;
            }
        }
        System.out.println("Совпадений не найдено.");
    }
    boolean isInvestigtation(String name){
        for (Investigation i: arrayList){
            if (name.equals(i.getTitle())){
                return true;
            }
        }
        return false;
    }
    int statusCount(Status status){
        int count = 0;
        for (Investigation i: arrayList){
            if (status == i.getStatusl()){
                count++;
            }
        }
        return count;
    }
    Investigation investigation(String name){
        for (Investigation i: arrayList){
            if (name.equals(i.getTitle())){
                return i;
            }
        }
        return null;
    }


}

