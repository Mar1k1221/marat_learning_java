package HomeWork5;

public class DayFour {
    static void main(String[] args) {
FoodProduct1 foodProduct1 = new FoodProduct1("Молоко",100);
DayFour.processCheclout(foodProduct1);
TechProduct1 techProduct1 = new TechProduct1("Телевизор",50000);
DayFour.processCheclout(techProduct1);
Developer2 developer2 = new Developer2("Владимир",30000,20);
Manager2 manager2 = new Manager2("Лилия",20000,10);
DayFour.sendBonus(manager2);
DayFour.sendBonus(developer2);
Taxi taxi = new Taxi("Vesta",200);
Bus1 bus = new Bus1("VW", 150);
DayFour.printRentalContract(taxi,13);
DayFour.printRentalContract(bus,7);
ChefRoutineReels chefRoutineReels = new ChefRoutineReels("Lana Del Ray", 60,"Pho-Bo");
StudentRoutineReel studentRoutineReel = new StudentRoutineReel("Биологическая ОИЗ", "Sonner",40);
DayFour.uploadToSocialMedia(chefRoutineReels);
DayFour.uploadToSocialMedia(studentRoutineReel);
    }
    public static void processCheclout(Discountable item){
        System.out.println("Товар пробит, итоговая цена со скидкой " + item.getPriceWithDiscount());
    }
    public static void sendBonus(BonusEligible bonusEligible){
        System.out.println("Индивидуальный расчет бонуса: " + bonusEligible.calculateBonus());
    }
    public static void printRentalContract(Rentable rentable, int hours){
        System.out.println("Итоговая стоимость к оплате: " + rentable.calculateRentPrice(hours));

    }
    public static void uploadToSocialMedia(Publishable publishable){
        publishable.publishContent();
        System.out.println("---Риллс успешно загружен---");
    }
}
interface Discountable{
    double getPriceWithDiscount();
}
abstract class Product1{
    private String name;
    private int basePrice;

    public Product1(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }
}
class FoodProduct1 extends Product1 implements Discountable{
    public FoodProduct1(String name, int basePrice) {
        super(name, basePrice);
    }

    @Override
    public double getPriceWithDiscount() {
        return getBasePrice() - (getBasePrice() * 15/100);
    }
}
class TechProduct1 extends Product1 implements Discountable{
    TechProduct1(String name, int basePrice){
        super(name,basePrice);
    }
    @Override
    public double getPriceWithDiscount(){
        return getBasePrice() - (getBasePrice() * 5/100);
    }
}

interface BonusEligible{
    int calculateBonus();
}
abstract class Employee2{
    private String name;
    private int baseSalary;

    Employee2(String name, int BaseSalary){
        this.name=name;
        this.baseSalary=BaseSalary;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getBaseSalary(){
        return baseSalary;
    }
    public void setBaseSalary(int baseSalary){
        this.baseSalary=baseSalary;
    }

}
class Developer2 extends Employee2 implements BonusEligible{
    private int fixedBonus;

    public Developer2(String name, int BaseSalary, int fixedBonus) {
        super(name, BaseSalary);
        this.fixedBonus = fixedBonus;
    }

    public int getFixedBonus() {
        return fixedBonus;
    }

    public void setFixedBonus(int fixedBonus) {
        this.fixedBonus = fixedBonus;
    }
    @Override
    public int calculateBonus(){
        return fixedBonus;
    }
}
class Manager2 extends Employee2 implements BonusEligible{
    private int bonusPercentage;

    public Manager2(String name, int BaseSalary, int bonusPercentage) {
        super(name, BaseSalary);
        this.bonusPercentage = bonusPercentage;
    }

    public int getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(int bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }
    @Override
    public int calculateBonus(){
        return (getBaseSalary() * bonusPercentage) / 100;
    }
}
interface Rentable{
    int calculateRentPrice(int hours);
}
abstract class Transport2{
    private String brand;
    private int baseRatePerHour;

    public Transport2(String brand, int baseRatePerHour) {
        this.brand = brand;
        this.baseRatePerHour = baseRatePerHour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getBaseRatePerHour() {
        return baseRatePerHour;
    }

    public void setBaseRatePerHour(int baseRatePerHour) {
        this.baseRatePerHour = baseRatePerHour;
    }
}
class Taxi extends Transport2 implements Rentable{
    public Taxi(String brand, int baseRatePerHour) {
        super(brand, baseRatePerHour);
    }

    @Override
    public int calculateRentPrice(int hours){
        return (getBaseRatePerHour() * hours) + 500;

    }
}
class Bus1 extends Transport2 implements Rentable{
    Bus1(String brand, int baseRatePerHour){
        super(brand,baseRatePerHour);
    }
    @Override
    public int calculateRentPrice(int hours){
        return (getBaseRatePerHour() * hours) + (1000*hours);
    }
}
interface Publishable{
    void publishContent();
}
abstract class VideoReel{
    private String trackName;
    private int durationSeconds;

    public VideoReel(String trackName, int durationSeconds) {
        this.trackName = trackName;
        this.durationSeconds = durationSeconds;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
}
class ChefRoutineReels extends VideoReel implements Publishable{
    private String dishName;

    ChefRoutineReels(String trackName, int durationSeconds, String dishName){
        super(trackName, durationSeconds);
        this.dishName=dishName;

    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public void publishContent(){
        System.out.println("Публикуем видео с кухни, готовка " + dishName + " под трек: " + getTrackName() + " длина видео: " + getDurationSeconds());
    }
}
class StudentRoutineReel extends VideoReel implements Publishable{
    private String studyTopic;
    StudentRoutineReel(String studyTopic, String trackName, int durationSeconds){
        super(trackName,durationSeconds);
        this.studyTopic = studyTopic;
    }
    @Override
    public void publishContent(){
        System.out.println("Загружаем учебный влог.  Изучени темы: " + studyTopic + " под трек: " + getTrackName() + " длительность видео:" + getDurationSeconds());

    }
}