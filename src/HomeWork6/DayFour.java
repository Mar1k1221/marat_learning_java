package HomeWork6;

import java.util.ArrayList;
import java.util.Comparator;

public class DayFour {
    public static void main(String[] args) {
Employee1 employee1 = new Employee1("Василий",180000);
Employee1 employee2 = new Employee1("Игорь",250000);
Employee1 employee3 = new Employee1("Антон",110000);
ArrayList<Employee1> defoltArray = new ArrayList<>();
defoltArray.add(employee1);
defoltArray.add(employee2);
defoltArray.add(employee3);
        System.out.println("До сортировки: ");
for (Employee1 e: defoltArray){
    System.out.println(e);
}
        System.out.println();
        System.out.println("После сортировки: ");

ArrayList<Employee1> newEmployeeArray = sortBySalaryDesc(defoltArray);
for (Employee1 e: newEmployeeArray){
    System.out.println(e);
    System.out.println("Сотрудник с самой высокой зарплатой в компании - " + newEmployeeArray.get(0));
}

    }
    public static ArrayList<Employee1> sortBySalaryDesc(ArrayList<Employee1> arrayList){
        ArrayList<Employee1> newArray = new ArrayList<>(arrayList);
        newArray.sort(new Comparator<Employee1>(){
            public int compare(Employee1 o1, Employee1 o2){
                return Integer.compare(o2.getSalary(),o1.getSalary());
            }
        });
        return newArray;
    }
    public ArrayList<Employee1>  filterHighPaidEmployees(ArrayList<Employee1> arrayList){
        ArrayList<Employee1> newArray = new ArrayList();
        for (Employee1 a: arrayList){
            if (a.getSalary() > 200000){
                newArray.add(a);
            }
        }
        return newArray;
    }

}
class Employee1{
    private String name;
    private int salary;

    public Employee1(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "Имя сотрудника -'" + name + '\'' +
                ", Зарплата - " + salary +
                '}';
    }
}