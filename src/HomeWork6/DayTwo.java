package HomeWork6;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class DayTwo {
    public static void main(String[] args) {
UserService userService = new UserService();
        ArrayList<Book> arrayBook = new ArrayList<>();
        Book book1 = new Book("Триллер","Смерть и восхождение");
        Book book2 = new Book("Ужастик","Вне бряного мира");
        Book book5 = new Book("Ужастик","Вне бряного мира");
        Book book3 = new Book("Мелодрама","Сквозь любовь");
        Book book4 = new Book("Мелодрама","Сквозь любовь");
        arrayBook.add(book1);
        arrayBook.add(book2);
        arrayBook.add(book3);
        arrayBook.add(book4);
        arrayBook.add(book5);

        HashSet<String> uniqueSet = uniqueBook(arrayBook);
        for (String s:uniqueSet){
            System.out.println(s);
        }




boolean result = userService.registerUser("login123");
if (result){
    System.out.println("Логин успешно добавлен.");
} else {
    System.out.println("Логин занят!");
}

    }
   public static HashSet<String> uniqueBook(ArrayList<Book> arrayList){
        HashSet<String> hashSet = new HashSet<>();
        for (Book b:arrayList){
            hashSet.add(b.getGenre());
        }
        return hashSet;

    }
}
class UserService{
    HashSet<String> hashLogin = new HashSet<>();

    public boolean registerUser(String login) {
    boolean resultContains = hashLogin.contains(login);
    if (resultContains){
        return false;
    } else {
        hashLogin.add(login);
        return true;
    }

    }

}
class Book{
    private String title;
    private String genre;

    public Book(String genre, String title) {
        this.genre = genre;
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre);
    }

}