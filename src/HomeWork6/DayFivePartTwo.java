package HomeWork6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DayFivePartTwo {
    public static void main(String[] args) {
ArrayList <Employee2> arrayList = new ArrayList<>();
Employee2 employee1 = new Employee2("Иван","Мидл",200000);
Employee2 employee2 = new Employee2("Марат","Сеньор",250000);
Employee2 employee3 = new Employee2("Игорь","Джун",100000);
arrayList.add(employee1);
arrayList.add(employee2);
arrayList.add(employee3);
ArrayList<String> csvData = new ArrayList<>();
for (Employee2 e: arrayList){
    String newString = e.getName() + ";" + e.getPosition() + ";" + e.getSalary();
    csvData.add(newString);
}
Path path = Path.of("employee2.txt");
try{
    Files.write(path,csvData);
    System.out.println("Данные успешно сохранены.");
} catch (IOException e) {
    System.out.println("Ошибка! Повторите снова.");
}

        System.out.println("-----Загрузка из файла-----");
try {
    List<String> loadedLines = Files.readAllLines(path);
    for (String s: loadedLines){
      String [] massive = s.split(";");
      String name = massive[0];
      String position = massive[1];
      int salary = Integer.parseInt(massive[2]);
      Employee2 newEmployee = new Employee2(name,position,salary);
    }
} catch (IOException ioException){
    System.out.println("Некорректная распаковка файлов. Ошибка!");
}
    }
}
class Employee2{
    private String name;
    private String position;
    private int salary;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position=position;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public Employee2(String name,String position,int salary){
        this.name=name;
        this.position=position;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "Имя - '" + name + '\'' +
                ", Позиция - '" + position + '\'' +
                ", Зарплата -" + salary +
                '}';
    }
}
