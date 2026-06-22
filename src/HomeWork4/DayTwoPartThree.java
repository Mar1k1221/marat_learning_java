package HomeWork4;

import java.util.ArrayList;

public class DayTwoPartThree {
   public static void main(String[] args) {
        CosmeticProduct cosmeticProduct1 = new CosmeticProduct("WWW","letual","zinc");
        CosmeticProduct cosmeticProduct2 = new CosmeticProduct("AAA","gold apple","so-13");
        CosmeticProduct cosmeticProduct3 = new CosmeticProduct("BBB","zm","D-1");
        ProductAnalyzer productAnalyzer = new ProductAnalyzer();
        productAnalyzer.addProduct(cosmeticProduct1);
        productAnalyzer.addProduct(cosmeticProduct2);
        productAnalyzer.addProduct(cosmeticProduct3);

        productAnalyzer.findByIngredient("zinc");
       int resultCount = productAnalyzer.countProductByBrand("gold apple");
        System.out.println("Количество найденных совпадений: "  + resultCount);
    }
}
class CosmeticProduct{
    private String name;
    private String brand;
    private String activeIngridient;

    CosmeticProduct(String name, String brand, String activeIngridient){
        setName(name);
        setBrand(brand);
        setActiveIngridient(activeIngridient);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if (name != null && !name.trim().isEmpty()){
            this.name = name;
        } else {
            System.out.println("Название продукта не может быть пустым.");
        }
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        if (brand != null && !brand.trim().isEmpty()){
            this.brand = brand;
        } else {
            System.out.println("Название бренда не может быть пустым.");
        }
    }
    public String getActiveIngridient(){
        return  activeIngridient;
    }
    public void setActiveIngridient(String activeIngridient){
        if (activeIngridient != null && !activeIngridient.trim().isEmpty()){
            this.activeIngridient = activeIngridient;
        } else {
            System.out.println("Название активных компонентов не может быть пустым.");
        }
    }
}
class ProductAnalyzer{
    private ArrayList<CosmeticProduct> arrayList = new ArrayList<>();

    public void addProduct(CosmeticProduct cosmeticProduct){
        arrayList.add(cosmeticProduct);
    }
    public void findByIngredient(String ingredient){
        boolean isFound = false;
        for (CosmeticProduct c: arrayList){
            if (ingredient.equals(c.getActiveIngridient())){
                System.out.println("Найдено: " + c.getBrand() + " " + c.getName());
                isFound = true;
            }
        } if (!isFound){
            System.out.println("Совпадений не найдено.");
        }
    }
    public int countProductByBrand(String brand){
        int countBrand = 0;
        for (CosmeticProduct c: arrayList){
            if (brand.equals(c.getBrand()))
                countBrand++;
        }
        return countBrand;

    }
}
