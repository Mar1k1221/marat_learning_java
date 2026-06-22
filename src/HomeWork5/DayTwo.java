package HomeWork5;

import java.util.ArrayList;

public class DayTwo {
    public static void main(String[] args) {
ArrayList <NewEmployee> arrayEmployee = new ArrayList<>();
arrayEmployee.add(new NewEmployee("Loca",20000));
arrayEmployee.add(new Developer("Alos",2000,20));
arrayEmployee.add(new Intern("Nurk",0,1000));
arrayEmployee.add(new Manager("Jura",7000,10));

for (NewEmployee n: arrayEmployee){
    int result = n.calculateSalary();
    System.out.println("Итоговый результат  сотрудника: " + n.getName() + " = " + result);
}
    }
}

class NewEmployee {
    private String name;
    private int baseSalary;

    NewEmployee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;


    }
    public int getBaseSalary(){
        return baseSalary;
    }
    public void setBaseSalary(int baseSalary){
        this.baseSalary=baseSalary;
    }
    public int calculateSalary(){
        return baseSalary;
    }

}
class Developer extends NewEmployee{
    private int bonus;

    public Developer(String name, int baseSalary, int bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    @Override
    public int calculateSalary(){
        return getBaseSalary() + bonus;
    }
}
class Manager extends NewEmployee{
    private int percentage;
    Manager(String name, int baseSalary, int percentage){
        super(name,baseSalary);
        this.percentage = percentage;
    }
    public int getPercentage(){
        return percentage;
    }
    public void setPercentage(int percentage){
        this.percentage=percentage;
    }
    @Override
    public int calculateSalary(){
        return getBaseSalary() + (getBaseSalary() * percentage / 100);
    }
}
class Intern extends NewEmployee{
    private int fixedPayout;

    Intern(String name, int payout, int fixedPayout){
        super(name,0);
        this.fixedPayout=fixedPayout;
    }
    @Override
    public int calculateSalary(){
        return fixedPayout;
    }
}