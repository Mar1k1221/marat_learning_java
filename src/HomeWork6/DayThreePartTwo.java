package HomeWork6;

import java.util.HashMap;
import java.util.Scanner;

public class DayThreePartTwo {
    public static void main(String[] args) {
        Product1 product1 = new Product1("Беспроводные наушники");
        Product1 product2 = new Product1("Телефон");
        Product1 product3 = new Product1("Повербанк");
        HashMap <String,Product1> product = new HashMap<>();
        product.put("7778",product1);
        product.put("7721",product2);
        product.put("9989",product3);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Введите артикул для поиска товара..");
            String resultSearch = sc.nextLine();

            if (product.containsKey(resultSearch)){
                System.out.println(product.get(resultSearch));
            } else {
                System.out.println("Товара с таким артикулом не было найдено.");
            }
        }

    }
}
class Product1{
    private String productName;

    public Product1(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "Товар='" + productName + '\'' +
                '}';
    }
}
