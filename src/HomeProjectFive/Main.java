package HomeProjectFive;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeService();

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Показать всех сотрудников");
            System.out.println("3. Найти сотрудника по имени\n");
            System.out.println("4. Изменить статус сотрудника");
            System.out.println("5. Удалить сотрудника");
            System.out.println("6. Показать общую сумму зарплат");
            System.out.println("7. Найти сотрудника с самой высокой зарплатой");
            System.out.println("8. Посчитать сотрудников по отделу\n");
            System.out.println("9. Показать сотрудников с бонусом\n");
            System.out.println("10. Показать итог по компании");
            System.out.println("0. Выход");
            int resultScanner = sc.nextInt();
            sc.nextLine();
            switch (resultScanner){
                case 1:
                    try {
                        System.out.println("Введите имя сотрудника: ");
                        String nameEmployee= sc.nextLine();
                        System.out.println("Укажите возраст: ");
                        int resultAge = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Укажите статус работы: ");
                        String resultStatus = sc.nextLine();
                        EmployeeStatus employeeStatus = EmployeeStatus.valueOf(resultStatus.toUpperCase());
                        System.out.println("Введите отделение: ");
                        String resultDeportament = sc.nextLine();
                        Department department = Department.valueOf(resultDeportament.toUpperCase());
                        System.out.println("Введите базовую ставку: ");
                        int baseSalary = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Выберите кого нужно добавить: [1] - Developer || [2] - Manager || [3] - Intern");
                        int res= sc.nextInt();
                        sc.nextLine();
                        if (res == 1){
                            Developer developer1 = new Developer(nameEmployee,resultAge,baseSalary,department,employeeStatus);
                            employeeService.addEmploye(developer1);
                        } else if(res == 2) {
                            Manager manager1 = new Manager(nameEmployee,resultAge,baseSalary,department,employeeStatus);
                            employeeService.addEmploye(manager1);
                        } else if(res == 3) {
                            Intern intern = new Intern(nameEmployee,resultAge,baseSalary,department,employeeStatus);
                            employeeService.addEmploye(intern);
                        } else {
                            System.out.println("Некорректный ввод.Повторите");
                        }
                    } catch (Exception e){
                        System.out.println("Неправильно введеные данные.Повторите снова.");
                    } break;
                case 2:
                    employeeService.printEmployees();
                    break;
                case 3:
                    System.out.println("Введите имя для поиска совпадение..");
                    String resultName=sc.nextLine();
                    Employee e = employeeService.findFirstByName(resultName);
                   if (e != null){
                       e.getInfo();
                   } else{
                       System.out.println("Совпадений не было найдено.");
                   }
                    break;
                case 4: {
                    System.out.println("Введите имя сотрудника у которого хотите изменить статус...");
                    String resultChangeStatus = sc.nextLine();
                    Employee empToChange = employeeService.findFirstByName(resultChangeStatus);

                    if (empToChange != null) {
                        try {
                            System.out.println("Введите новый статус для сотрудника (ACTIVE, VACATION, FIRED)..");
                            String resultStatus = sc.nextLine();
                            EmployeeStatus newStatus = EmployeeStatus.valueOf(resultStatus.toUpperCase());
                            employeeService.changeStatus(empToChange, newStatus);
                            System.out.println("Статус успешно обновлен!");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Ошибка: такого статуса не существует.");
                        }
                    } else {
                        System.out.println("Сотрудник с таким именем не найден.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Введите индекс сотрудника для удаления:");
                    try {
                        int index = sc.nextInt();
                        sc.nextLine();
                        boolean isRemoved = employeeService.removeEmployee(index);
                        if (isRemoved) {
                            System.out.println("Сотрудник успешно удален.");
                        } else {
                            System.out.println("Ошибка: сотрудника с таким индексом не существует.");
                        }
                    } catch (Exception ex) {
                        System.out.println("Ошибка ввода: индекс должен быть числом.");
                        sc.nextLine();
                    }
                    break;
                }
                case 6:
                    System.out.println("Общий фонд заработной платы компании: " + employeeService.calculateTotalSalary());
                    break;
                case 7:
                    try {
                        Employee topEarner = employeeService.findHighestSalaryEmployee();
                        if (topEarner != null) {
                            System.out.println("Сотрудник с самой высокой зарплатой: ");
                            topEarner.getInfo();
                            System.out.println("Его итоговая зарплата: " + topEarner.calculateSalary());
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Невозможно найти максимум: " + ex.getMessage());
                    }
                    break;
                case 8: {
                    System.out.println("Введите название отдела для подсчета (DEVELOPMENT, SALES, HR, SUPPORT): ");
                    try {
                        String depInput = sc.nextLine();
                        Department searchDep = Department.valueOf(depInput.toUpperCase());
                        int count = employeeService.countByDepartament(searchDep);
                        System.out.println("Количество сотрудников в отделе " + searchDep + ": " + count);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Ошибка: такого отдела не существует.");
                    }
                    break;
                }
                case 9:
                    System.out.println("--- Список сотрудников с правом на бонус ---");
                    employeeService.printBonusEmployees();
                    break;
                case 10:
                    System.out.println("--- Отчет по компании ---");
                    System.out.println(employeeService.getCompanySummary());
                    break;
                case 0:
                    System.out.println("Завершение работы программы. До свидания!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный пункт меню. Пожалуйста, выберите число от 0 до 10.");
                    break;
            }
            }
        }

    }

class EmployeeService{
    private ArrayList<Employee> arrayEmploye = new ArrayList<>();


    public void printEmployees(){
        for (Employee e:arrayEmploye){
            System.out.println("Имя сотрудника: " + e.getName() + " Отдел сотрудника: " + e.getDepartament() + " Статус сотрудника: " + e.getStatus());
        }
    }
    public void addEmploye(Employee e){
        arrayEmploye.add(e);
    }
    Employee  findFirstByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Вы ничего не ввели. Попробуйте снова.");
        }
        for (Employee e : arrayEmploye) {
            if (name.equalsIgnoreCase(e.getName())) {
            return e;
            }
        } return null;
    }
    public int countByDepartament(Department department){
        int count = 0;
        for (Employee e: arrayEmploye){
            if (department == e.getDepartament())
                count++;
        }
        return count;
    }
    public void changeStatus(Employee employee, EmployeeStatus newStatus){
        for (Employee e: arrayEmploye){
           if (e == employee){
               employee.setStatus(newStatus);
             return;
           }
        }
    }
    public boolean removeEmployee(int index){
        if (index >= 0 && index < arrayEmploye.size()){
            arrayEmploye.remove(index);
            return true;
        }
        return false;
    }
    public double calculateTotalSalary(){
        double countSalary = 0;
        for (Employee e: arrayEmploye){
            countSalary +=e.calculateSalary();
        } return countSalary;
    }
    Employee  findHighestSalaryEmployee(){
        if (arrayEmploye.isEmpty()){
            throw new IllegalArgumentException("Список пуст.");
        }
        double max = 0;
        Employee maxTop = null;
        for (Employee e: arrayEmploye){
            if (e.calculateSalary() > max){
                max = e.calculateSalary();
                maxTop = e;
            }
        }
        return maxTop;
    }
    public void  printBonusEmployees(){
        for (Employee e: arrayEmploye){
            if (e instanceof BonusEligble){
                System.out.println("Имя человека у которого есть бонусная система расчета ЗП: " + e.getName());
            }
        }
    }
    public String  getCompanySummary(){
        return "В нашей дружной компании работает " + arrayEmploye.size() + " человек. По отчетам за предыдущий год, мы выплачивали ежемесячно по " + calculateTotalSalary();
    }

}
abstract class Employee  {
    private String name;
    private int age;
    private int baseSalary;
    private Department departament;
    private EmployeeStatus status;


    public Employee(String name, int age, int baseSalary,Department departament, EmployeeStatus status) {
        setName(name);
        setAge(age);
        setBaseSalary(baseSalary);
        this.departament = departament;
        this.status=status;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
       if (baseSalary < 0){
          throw new IllegalArgumentException("Ошибка, зарплата не может быть меньше отрицательной.");
       } this.baseSalary=baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       if (name.trim().length() == 0){
           throw new IllegalArgumentException("Имя не указано. Или указано не корректно.");
       } this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
       if (age < 18){
           throw new IllegalArgumentException("Сотруднику в обязательном порядке должно быть 18 или более лет.");
       } this.age=age;
    }

    public Department getDepartament() {
        return departament;
    }

    public void setDepartament(Department departament) {
        this.departament = departament;
    }
    public abstract double calculateSalary();

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
     public  void getInfo(){
         System.out.println("Привет, меня зовут - " + getName() + " мне - " + getAge() + " лет. Мой статус работы: " + getStatus() + " работаю в отделении - " + getDepartament() );

    }
}
interface BonusEligble{
    public double calculateBonus();
}
enum Department {
    DEVELOPMENT,
    SALES,
    HR,
    SUPPORT
}

enum EmployeeStatus {
    ACTIVE,
    VACATION,
    FIRED
}
class Developer extends Employee{
    public Developer(String name, int age, int baseSalary ,Department departament, EmployeeStatus status) {
        super(name, age, baseSalary,departament, status);
    }
    @Override
    public double calculateSalary(){
        return getBaseSalary() * 1.5;

    }

}
class Manager extends Employee implements BonusEligble{
    public Manager(String name, int age, int baseSalary, Department departament, EmployeeStatus status) {
        super(name, age, baseSalary, departament, status);
    }
    @Override
    public double calculateBonus(){
return getBaseSalary() * 0.7;
    }
    @Override
    public double calculateSalary(){
return getBaseSalary();
    }
}
class Intern extends Employee{
    public Intern(String name, int age, int baseSalary, Department departament, EmployeeStatus status) {
        super(name, age, baseSalary, departament, status);
    }
@Override
    public double calculateSalary(){
return getBaseSalary() * 0.3;
}
}