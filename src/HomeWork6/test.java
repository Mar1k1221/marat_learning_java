package HomeWork6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
Book1 book1 = new Book1("hashdas","jdasjasdj",3333);
Book1 book2 = new Book1("ddfsdf","ghgghf",98833);
Book1 book3 = new Book1("sdaasd","dewewq",66776);
ArrayList<Book1> arrayBook = new ArrayList<>();
arrayBook.add(book1);
arrayBook.add(book2);
arrayBook.add(book3);
List<String> newArray = new ArrayList<>();
for (Book1 b:arrayBook){
    String newString = b.getName() + ";" + b.getTitle() + ";" + b.getPages();
    newArray.add(newString);
}
Path path = Path.of("book.txt");
try {
    Files.write(path,newArray);
    System.out.println("Файл успешно загружен.");
} catch (IOException e) {
    System.out.println("Проблемы с загрузкой файла.");
}
ArrayList<Book1> newArrayBook = new ArrayList<>();
        System.out.println("---Чтение файла---");
try {
   List<String> listOne =  Files.readAllLines(path);
    for (String l:listOne){
        String [] massive = l.split(";");
        String name = massive[0];
        String title = massive[1];
        int pages = Integer.parseInt(massive[2]);
        Book1 newBook = new Book1(name,title,pages);
        newArrayBook.add(newBook);



    }  System.out.println("Файл успешно прочитан и сохранен в новую коллекцию.");
} catch (Exception e) {
    System.out.println("Ошибка при чтении файла.");
}


    }
}
class Book1{
    private String name;
    private String title;
    private int pages;
    Book1(String name,String title, int pages){
        setName(name);
        setTitle(title);
        setPages(pages);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public int getPages(){
        return pages;
    }
    public void setPages(int pages){
        this.pages=pages;
    }

    @Override
    public String toString() {
        return "Book1{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}

