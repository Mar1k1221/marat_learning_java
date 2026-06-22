package HomeWork5;

public class DayOnePartFour {
    public static void main(String[] args) {
Product product = new Product("Паста",130);
FoodProduct foodProduct = new FoodProduct("Стейк",100,2);
TechProduct techProduct = new TechProduct("Б",200,true);
product.printInfo();
foodProduct.printInfo();
techProduct.printInfo();
    }
}
class Product{
    private String name;
    private int price;
    Product(String name,int price){
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void printInfo(){
        System.out.println("Общая информация о товаре");
    }
}
class FoodProduct extends Product{
    private int date;
    FoodProduct(String name,int price,int date){
        super(name,price);
        this.date=date;

    }
    public int getDate(){
        return date;
    }
    public void setDate(int date){
        this.date=date;
    }
    @Override
    public void printInfo(){
        System.out.println("Вывод информации о сроке годности");
    }
}
class TechProduct extends Product{
    private boolean hasWarranty;
    TechProduct(String name, int price, boolean hasWarranty){
        super(name,price);
        this.hasWarranty=hasWarranty;
    }
    public boolean hasWarranty(){
        return hasWarranty;
    }
    public void setFresh(boolean hasWarranty){
        this.hasWarranty=hasWarranty;
    }
    @Override
    public void printInfo(){
        System.out.println("Вывод информации о техникеDct");
    }
}