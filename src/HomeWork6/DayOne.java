package HomeWork6;

import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {
EmployeeService employeeService = new EmployeeService();

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1 - Показать всех сотрудников.");
            System.out.println("2 - Добавить сотрудника.");
            System.out.println("3 - Поиск по имени.");
            System.out.println("4 - Показать сколько активных сотрудников.");
            System.out.println("5 - Вывести сотрудников из определенного отдела.");
            System.out.println("0 - Выйти из меню.");
            int resultMenu = sc.nextInt();
            sc.nextLine();
            switch(resultMenu){
                case 1:
                    employeeService.printEmployee();
                    break;
                case 2:
                    try {
                        System.out.println("Введите имя человека для добавления в команду...");
                        String addName = sc.nextLine();
                        System.out.println("Введите возраст...");
                        int addAge  =sc.nextInt();
                        sc.nextLine();
                        System.out.println("Введите отдел в котором будет числиться...");
                        String addDep = sc.nextLine();
                        Departament addDepartament = Departament.valueOf(addDep.toUpperCase());
                        System.out.println("Введите текущее состояние активности на момент добавления: TRUE or FALSE.");
                        boolean addIsActive  = sc.nextBoolean();
                        Employee  newEmployee = new Employee(addName,addAge,addDepartament,addIsActive);
                        employeeService.addEmployee(newEmployee);
                        System.out.println("Сотрудник успешено добавлен.");
                    }catch (Exception e){
                        System.out.println("Некорректный ввод данных. Повторите снова...");
                    } break;
                case 3:
                    System.out.println("Введите имя для поиска среди сотрудников: ");
                    String resultSearchByName = sc.nextLine();
                   Employee employeeResult =  employeeService.searchByName(resultSearchByName);
                    if (employeeResult == null){
                        System.out.println("Сотрудник с таким именем не найден.");

                    } else {
                        System.out.println("Результат поиска по имени: " + employeeResult.getName() + " Возраст: " + employeeResult.getAge() + " Отдел в котором числится сотрудник: " + employeeResult.getDepartament());
                    }
                    break;
                case 4:
                   int result =  employeeService.countActiveEmployees();
                    System.out.println(" Количество активных сотрудников из списка =  " + result );
                    break;
                case 5:
                    System.out.println("Введите название отдела для вывода сотрудников: ");
                    String resultDepartament = sc.nextLine();
                    Departament departament1  = Departament.valueOf(resultDepartament.toUpperCase());
                    ArrayList <Employee> resultDepar = employeeService.searchDepartament(departament1);
                    for (Employee e: resultDepar){
                        System.out.println("Имя сотрудника: " + e.getName() + " Возраст: " + e.getAge() + " Отдел: " + e.getDepartament());
                    }
                    break;
                case 0:
                    System.exit(0);
            }

        }


    }
}
class EmployeeService{
    private ArrayList<Employee> arrayEmployee = new ArrayList<>();



    public Employee searchByName(String name){
        for (Employee e: arrayEmployee){
            if (name.equalsIgnoreCase(e.getName())){
                return e;
            }
        } return null;
    }
    public void printEmployee(){
        for (Employee e: arrayEmployee){
            System.out.println("Имя сотрудника: " + e.getName() + " Возраст: " + e.getAge() + " Кем является в компании: " + e.getDepartament());
        }
    }
    public  ArrayList<Employee> searchDepartament (Departament departament){
        ArrayList <Employee> arrayDepartament = new ArrayList<>();
        for(Employee e: arrayEmployee){
            if (departament == e.getDepartament()){
                arrayDepartament.add(e);
            }
            }
        return arrayDepartament;
        }
        public void addEmployee(Employee e ){
        arrayEmployee.add(e);
        }
        public int countActiveEmployees(){
        int count = 0;
        for (Employee e: arrayEmployee){
            if (e.isActive()){
                count++;
            }
        } return count;
        }
    }


class Employee{
    private String name;
    private int age;
    private Departament departament;
    private boolean isActive;

    public Employee(String name, int age, Departament departament,boolean isActive) {
        setName(name);
        setAge(age);
        setDepartament(departament);
        this.isActive=isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()){
            this.name=name;
        } else {
            throw new IllegalArgumentException("Некорректный ввод имени.");
        }
        }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18 ){
            this.age=age;
        }else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18 лет.");
        }

    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
enum Departament{
    HR,
    MANAGER,
    DEVELOPER

        }
