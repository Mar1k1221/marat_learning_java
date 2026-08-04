package HomeWork6;

import java.util.ArrayList;
import java.util.Comparator;

public class DayFourPartTwo {
    public static void main(String[] args) {
        ArrayList<ProductOne> productArray = new ArrayList<>();
        ProductOne productOne1 = new ProductOne("Клавиатура", 55);
        ProductOne productOne2 = new ProductOne("Мышка", 17);
        ProductOne productOne3 = new ProductOne("Монитор", 105);
        productArray.add(productOne1);
        productArray.add(productOne2);
        productArray.add(productOne3);
      ArrayList<ProductOne> newArray = filterAndSortProducts(productArray,40,105);
      System.out.println(newArray);


    }
    public static ArrayList<ProductOne> filterAndSortProducts(ArrayList<ProductOne> arrayList, int min, int max){
        ArrayList<ProductOne> sortProduct = new ArrayList<>();
        for (ProductOne p: arrayList) {
            if (p.getPrice() <= max && p.getPrice() >= min) {
                sortProduct.add(p);
            }
        }
        sortProduct.sort(new Comparator<ProductOne>(){
            public int compare(ProductOne o1, ProductOne o2){
                return o1.getName().compareTo(o2.getName());
            }
        });

        return sortProduct;
    }

}
class ProductOne {
    private String name;
    private int price;

    public ProductOne(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
