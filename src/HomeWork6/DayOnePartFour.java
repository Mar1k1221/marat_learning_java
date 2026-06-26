package HomeWork6;

import java.util.ArrayList;
import java.util.Scanner;

public class DayOnePartFour {
    public static void main(String[] args) {
 ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1 - Добавить товар в список");
            System.out.println("2 - Найти самый дорогой товар");
            System.out.println("3 - Посчитать сумму всех товаров в базе");
            System.out.println("4 - Найти товар с определенным лимитом");
            System.out.println("0 - Выйти из меню.");
            int resultMenu = Integer.parseInt(scanner.nextLine());;
            scanner.nextLine();
            switch (resultMenu){
                case 1:
                    try {

                        System.out.println("Введите название товара - ");
                    String addTitle = scanner.nextLine();
                    System.out.println("Укажите цену товара - ");
                    double addPrice = Double.parseDouble(scanner.nextLine());

                    Product newProduct = new Product(addTitle,addPrice);
                    productService.addProduct(newProduct);
                    System.out.println("Товар успешно загружен в базу.");
                    break;
            } catch(Exception e){
                        System.out.println("Некорректные данные, повторите ввод.");
                    }
                    break;
                case 2:
                    Product resultMax = productService.maxPrice();
                    if (resultMax != null){
                    System.out.println("Самый дорогой товар стоит: " + resultMax.getPrice() + " Название товара: " + resultMax.getTitle());}
                    else {
                        System.out.println("Склад пока пуст.");
                    }
                    break;
                case 3:
                    double resultSum = productService.sumPrice();
                    System.out.println("Стоимость всего товара на складе = " + resultSum);
                    break;
                case 4:
                    System.out.println("Укажите лимит по которому будет осуществляться поиск товара ... ");
                    int resultLimit  = Integer.parseInt(scanner.nextLine());

                    ArrayList<Product> resultArrayProduct = productService.limitPrice(resultLimit);
                    if (!resultArrayProduct.isEmpty()) {
                        for (Product p : resultArrayProduct) {
                            System.out.println("Название товара: " + p.getTitle() + " цена: " + p.getPrice());
                        }
                    } else {
                        System.out.println("Cписок товара пуст.");
                    } break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
class ProductService{
    private ArrayList<Product> arrayProduct = new ArrayList<>();

    public ArrayList<Product> getArrayProduct() {
        return arrayProduct;
    }

    public void setArrayProduct(ArrayList<Product> arrayProduct) {
        this.arrayProduct = arrayProduct;
    }
    public void addProduct(Product product){
        arrayProduct.add(product);
    }
    public Product maxPrice(){
       Product maxProduct = null;
       double max = 0;
        for(Product p: arrayProduct){
            if (p.getPrice() > max ){
                max = p.getPrice();
                maxProduct = p;
            }
        }
        return maxProduct;
    }
    public double sumPrice(){
        double sum = 0.0;
        for (Product p: arrayProduct){
            sum+=p.getPrice();
        }
        return sum;
    }
    public ArrayList <Product>  limitPrice(int limit){
        ArrayList<Product> arrayLimitProduct = new ArrayList<>();
        for (Product p: arrayProduct){
            if (p.getPrice() <= limit ){
                arrayLimitProduct.add(p);
            }
        } return arrayLimitProduct;
    }
}
class Product {
    private String title;
    private double price;

    public Product(String title, double price) {
        setTitle(title);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
       if (title != null && !title.trim().isEmpty()){
           this.title=title;
       } else {
           throw new IllegalArgumentException("Некорректный ввод названия товара.");
       }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        } else {
            throw new IllegalArgumentException("Цена продукта не может быть ниже 0.");
        }
    }
}
