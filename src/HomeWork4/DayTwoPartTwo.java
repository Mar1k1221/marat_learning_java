package HomeWork4;

import java.util.ArrayList;

public class DayTwoPartTwo {
    public static void main(String[] args) {
AutoPart autoPart1= new AutoPart("9890","WWM",20.5,3);
AutoPart autoPart2= new AutoPart("1322","GGB",20.0,1);
AutoPart autoPart3= new AutoPart("5666","JJN",9.3,10);
InventoryManager inventoryManager = new InventoryManager();
inventoryManager.addPart(autoPart1);
inventoryManager.addPart(autoPart2);
inventoryManager.addPart(autoPart3);
inventoryManager.findPartByArticle("0900");
inventoryManager.printPartsAvailable();

    }
}
class AutoPart{
    private String article;
    private String name;
    private double price;
    private int inStock;

    AutoPart(String article, String name, double price, int inStock){
        setArticle(article);
        setName(name);
        setPrice(price);
        setInStock(inStock);

    }
    public String getArticle(){
        return article;
    }
    public void setArticle(String article){
        if (article != null && !article.trim().isEmpty()){
            this.article = article;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if (name != null && !name.trim().isEmpty()){
            this.name = name;
        }
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if (price > 0 ){
            this.price = price;
        } else {
            System.out.println("Цена не может быть 0 и ниже.");
        }
    }
    public int getInStock(){
        return inStock;
    }
    public void setInStock(int inStock){
        if (inStock >= 0){
            this.inStock = inStock;
        } else {
            System.out.println("Количество товара не может быть отрицательным.");
        }
    }
}
class InventoryManager{
    private ArrayList<AutoPart> arrayList = new ArrayList<>();

    public void addPart(AutoPart part){
        arrayList.add(part);
    }
    public void printPartsAvailable(){
        System.out.println("Товары в наличии: ");
        for (AutoPart auto:arrayList){
            if (auto.getInStock() > 0){
                System.out.println("Название товара: " + auto.getName() + " Количество товара: " + auto.getInStock());
            }

        }
      }
    public void findPartByArticle(String string ){
        boolean isFound = false;
    for (AutoPart part: arrayList){
        if (string.equals(part.getArticle())){
            System.out.println("Совпадение найдено! Имя товара: " + part.getName() + " цена: " + part.getPrice());
            isFound = true;
            break;
        }
        }
    if (!isFound){
        System.out.println("Товар с артикулом " + string + " не был найден.");
    }
    }
}
