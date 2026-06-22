package HomeWork5;

import java.util.ArrayList;

public class DayThree {
    public static void main(String[] args) {
        ArrayList<Shape> arrayShape = new ArrayList<>();
        arrayShape.add(new Circle("Blue",10));
        arrayShape.add(new Rectangle("Orange",5,7));
        for (Shape s: arrayShape){
            double result = s.calculateArea();
            System.out.println("Результат вычисления площади: " + result);
        }

        ArrayList<Employee> arrayEmployee = new ArrayList<>();
        arrayEmployee.add(new Developer1("Boris",3000,10));
        arrayEmployee.add(new Manager1("Mariya",2000,30));
        for (Employee e: arrayEmployee){
            int result = e.calculateSalary();
            System.out.println("Рассчет ЗП для сотрудника по имени: " + e.getName() + " равна: " + result);

        }

        ArrayList<Transport> arrayTransport = new ArrayList<>();
        arrayTransport.add(new Car1("VW",10000,true));
        arrayTransport.add(new Bus("Gazel",20000,25));
        for (Transport t: arrayTransport){
            int result = t.calculateServiceCost();
            System.out.println("Цена обслуживания автомобиля марки " + t.getName() + " равна: " + result);
        }

    }
}
abstract class Shape{
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    abstract double calculateArea();


}
class Circle extends Shape{
    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    double calculateArea(){
        return 3.14 * radius * radius;
    }
}
class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    double calculateArea(){
        return width * height;
    }
}

abstract class Employee{
    private String name;
    private int baseSalary;

    public Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
    abstract int  calculateSalary();
}
class Developer1 extends Employee{
    private int bonus;
    Developer1(String name,int baseSalary, int bonus){
        super(name,baseSalary);
        this.bonus=bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    @Override
    int calculateSalary(){
        return getBaseSalary() + bonus;
    }
}
class Manager1 extends Employee{
    private int percentage;
    Manager1(String name, int baseSalary,int percentage){
        super(name,baseSalary);
        this.percentage=percentage;
    }
    public int getPercentage(){
        return percentage;
    }
    public void setPercentage(int percentage){
        this.percentage=percentage;
    }

    @Override
    int calculateSalary() {
        return getBaseSalary() + (getBaseSalary() * percentage/100);
    }
}
abstract class Transport{
    private String name;
    private int baseServicePrice;

    public Transport(String name, int baseServicePrice) {
        this.name = name;
        this.baseServicePrice = baseServicePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseServicePrice() {
        return baseServicePrice;
    }

    public void setBaseServicePrice(int baseServicePrice) {
        this.baseServicePrice = baseServicePrice;
    }
    abstract int calculateServiceCost();
}
class Car1 extends Transport{
    private boolean isLuxury;
    Car1(String name, int price, boolean isLuxury){
        super(name,price);
        this.isLuxury=isLuxury;
    }
    public boolean isLuxury(){
        return isLuxury;
    }
    public void setLuxury(boolean isLuxury){
        this.isLuxury=isLuxury;
    }
    @Override
    int calculateServiceCost(){
        if (isLuxury){
            return getBaseServicePrice() * 2;
        } else {
            return getBaseServicePrice();
        }
    }
}
class Bus extends Transport{
    private int passengerSeats;
    Bus(String name, int price, int passengerSeats){
        super(name,price);
        this.passengerSeats=passengerSeats;
    }
    public int getPassengerSeats(){
        return passengerSeats;
    }
    public void setPassengerSeats(int passengerSeats){
        this.passengerSeats=passengerSeats;
    }
    @Override
    int calculateServiceCost(){
        return getBaseServicePrice() + (passengerSeats * 100);
    }
}