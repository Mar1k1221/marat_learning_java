package HomeWork6;

import java.util.ArrayList;
import java.util.Comparator;

public class DayFourPartThree {
   public  static void main(String[] args) {
       BookOne book1 = new BookOne("А зори здесь тихие...","Борис Васильев",2026);
BookOne book2 = new BookOne("Мастер и Маргарита","Михаил Булгаков",1928);
BookOne book5 = new BookOne("Мастер и Маргарита","Михаил Булгаков",1940);
BookOne book6 = new BookOne("Новая жизнь","Михаил Булгаков",1947);
BookOne book3 = new BookOne("Кавказский пленник","Александр Пушкин",1819);
BookOne book4 = new BookOne("Преступление и наказание ","Федор  Достаевский",1819);
       ArrayList<BookOne> bookArray = new ArrayList<>();
bookArray.add(book1);
bookArray.add(book2);
bookArray.add(book3);
bookArray.add(book4);
bookArray.add(book5);
bookArray.add(book6);
ArrayList<BookOne> newBook = filterAndSortBooks(bookArray,"Михаил Булгаков");
       System.out.println(newBook);
    }
    public static ArrayList<BookOne> filterAndSortBooks(ArrayList<BookOne> arrayList, String author){
       ArrayList<BookOne> newArrayList = new ArrayList<>();
       for (BookOne b: arrayList){
           if (b.getAuthor().equalsIgnoreCase(author)){
               BookOne copyBook = new BookOne(b.getTitle(),b.getAuthor(),b.getYear());
               newArrayList.add(copyBook);

           }
       } newArrayList.sort(new Comparator<>(){
               public int compare(BookOne o1, BookOne o2){
                   return Integer.compare(o1.getYear(),o2.getYear());
               }
           });
        return newArrayList;
    }
}
class BookOne{
    private String title;
    private String author;
    private int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookOne(String title,  String author ,int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Книги: " +
                "Название | - '" + title + '\'' +
                ", Автор | -'" + author + '\'' +
                ", Год выпуска | - " + year +
                '}';
    }
}