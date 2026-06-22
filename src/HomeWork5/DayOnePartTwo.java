package HomeWork5;

public class DayOnePartTwo {
   public static void main(String[] args) {
Vehicle vehicle = new Vehicle(13,"VW");
Car car = new Car(3,"Toyota",4);
Truck truck = new Truck(10,"Kamaz",15);
vehicle.move();
car.move();
truck.move();
    }
}
class Vehicle{
    private String carMake;
    private int year;

    public Vehicle(int year, String carMake) {
        this.year = year;
        this.carMake = carMake;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void move(){
        System.out.println("Транспортное средство в движении");
    }
}
class Car extends Vehicle{
    private int passengerSeats;

    public Car(int year, String carMake, int passengerSeats) {
        super(year, carMake);
        this.passengerSeats = passengerSeats;
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public void setPassengerSeats(int passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    public void move(){
        System.out.println("Легковой автомобиль начал движение.");
    }
}
class Truck extends Vehicle{
    private int loadСapacity;
    Truck( int year,String carMake,int loadСapacity){
        super(year, carMake);
        this.loadСapacity=loadСapacity;
    }

    public int getLoadСapacity() {
        return loadСapacity;
    }

    public void setLoadСapacity(int loadСapacity) {
        this.loadСapacity = loadСapacity;
    }
    @Override

    public void move(){
        System.out.println("Грузовой автомобиль не готов к движению, случилась поломка!");
    }
}