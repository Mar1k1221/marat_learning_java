package HomeWork6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DayFivePartThree {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        Car car1 = new Car("Volvo",2021 ,1950000 );
        Car car2 = new Car("BMV",2017 , 2200000 );
        Car car3 = new Car("Honda",2019 ,1670000 );
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        ArrayList<String> csvData = new ArrayList<>();
        for (Car c:carList){
            String newCarString = c.getName()+ ";" + c.getYear() + ";" + c.getPrice();
            csvData.add(newCarString);

        }
        Path path = Path.of("car.txt");
        try{
            Files.write(path,csvData);
            System.out.println("Материал загружен успешно!");
        } catch (IOException e) {
            System.out.println("При загрузке данных произошла ошибка.");
        }
        try {
           List<String> newArrayList = Files.readAllLines(path);
            for (String s:newArrayList){
                String [] massive = s.split(";");
                String name = massive[0];
                int year = Integer.parseInt(massive[1]);
                int price = Integer.parseInt(massive[2]);
                Car car = new Car(name,year,price);

            }
        } catch (IOException ioException){
            System.out.println("Произошла ошибка во время распаковки файлов, попробуйте снова.");

        }
    }

}
class Car{
    private String name;
    private int year;
    private int price;
    public Car(String name,int year,int price){
        this.name=name;
        this.year=year;
        this.price=price;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Марка  - '" + name + '\'' +
                ", Год выпуска - " + year +
                ", Цена -" + price +
                '}';
    }
}

