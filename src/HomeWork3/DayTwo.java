package HomeWork3;



public class DayTwo {
    public static void main(String[] args) {
BankAccount one = new BankAccount("Alex",250.5);
BankAccount two = new BankAccount("Alica",150.7);
Hero heroOne = new Hero("Kitana",30);
Hero heroTwo = new Hero("Kano",90);
one.deposit(50);
two.withdraw(130.3);
heroOne.takeDamage(30);
heroOne.heal(10);

SmartLamp slone = new SmartLamp("blue");
SmartLamp sltwo = new SmartLamp("pink");
slone.turnOff();
sltwo.turnOn();
sltwo.printStatus();

ParkingPass pr1 = new ParkingPass(777,true);
ParkingPass pr2 = new ParkingPass(137,false);
int resultParking = pr1.calculatePrice(5);
        System.out.println("Вы должны за парковку - " + resultParking + " рублей.");

        CoffeeMachine myMachine = new CoffeeMachine(120);
        System.out.println("Чашка 1");
        myMachine.makeCoffee();
        System.out.println("Чашка 2");
        myMachine.makeCoffee();
        System.out.println("Чашка 3");
        myMachine.makeCoffee();


        int resultSum = Methods.sum(30,10,20);
        System.out.println("Сумма чисел  = " + resultSum);

        int resultMax = Methods.max(5,10);
        System.out.println("Число " + resultMax + " больше.");

        boolean resultIsEven= Methods.isEven(537);
        System.out.println("Является ли число четным? - "  + resultIsEven);

        boolean resultIsAdult = Methods.isAdult(17);
        System.out.println("Вам 18 или старше лет? " + resultIsAdult);

        String message = Methods.getGrade(45);
        System.out.println(message);

    }
}
class BankAccount{
    String ownerName;
    double balance;

    BankAccount(String ownerName,double balance){
        this.ownerName=ownerName;
        this.balance=balance;
    }
     void deposit(double amount){
      balance += amount;
        System.out.println("Баланс пополнен. Текущий баланс: " + balance);
    }
    void withdraw(double amount){
        if (balance >= amount){
            balance -=amount;
            System.out.println("Операция прошла успешно, ваш баланс: " + balance);
        }else {
            System.out.println("Ошибка: недостаточно средств! " + balance);
        }

    }
}
class Hero{
    String name;
    int health;
    Hero(String name, int health){
        this.name = name;
        this.health = health;
    }
    void takeDamage(int damage){
        health -=damage;
        if (health <= 0){
            System.out.println("Герой " + name + " пал в бою.");
        }
    }
    void heal(int amount){
        health += amount;
        System.out.println("Игрок " + name + " исцелился!");
    }
}
class SmartLamp{
    String color;
    boolean isOn = false;
    SmartLamp(String color){
        this.color = color;
    }
    void turnOn(){
        if (isOn == false){
            isOn=true;
            System.out.println("Лампа была включена! ");
        }

    } void turnOff(){
        if (isOn){
            isOn=false;
            System.out.println("Лампа выключена.");
           } else {
            System.out.println("Лампа уже и так была выключена.");
        }

    } void printStatus(){
        System.out.println("Лампа светит: " + isOn +  ",  Цвет: " + color);
    }
}
class ParkingPass{
    int carNumber;
    boolean isVip;
    ParkingPass(int carNumber,boolean isVip){
        this.carNumber = carNumber;
        this.isVip= isVip;
    }
    int calculatePrice(int hours){
        if (isVip){
            return 0;
        } else {
            return (hours * 150);
        }
    }

}
class CoffeeMachine{
    int waterLevel;
    CoffeeMachine(int waterLevel){
        this.waterLevel = waterLevel;
    }
    boolean makeCoffee(){
        if (waterLevel >= 50) {
            waterLevel -= 50;
            System.out.println("Кофе готов! Остаток воды в баке: " + waterLevel + " мл.");
            return true;
        } else {

            System.out.println("Ошибка: Нужно долить воды. В баке всего: " + waterLevel + " мл.");
            return false;
        }
    }
}
class Methods{
    static int sum(int a, int b, int c){
        return a+b+c;
    } static int max (int a, int b) {
        if (a > b){
            return a;
        } else {
            return b;
        }
    } static boolean isEven(int num){
        if (num % 2 == 0){

            return true;
        } else {

            return false;
        }
    }
    static boolean isAdult(int num){
        if (num >= 18){
            return true;

        } else {
            return false;
        }
    }
    static String getGrade(int score){
        if (score >=80){
            return "Отлично";
        } else if (score >= 60 && score <= 79) {
            return "Хорошо";

        } else if (score >=40 && score <=59 ){
            return "Удовлетворительно";
        } else {
            return "Неуд";
        }
    }

}
