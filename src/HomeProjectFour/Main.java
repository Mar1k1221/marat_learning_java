package HomeProjectFour;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Александр Пушкин", "Евгений Онегин", 1833, 7.8, BookStatus.FINISHED);
        Book book2 = new Book("Михаил Лермонтов", "Герой нашего времени", 1840, 8.9, BookStatus.READING);
        Book book3 = new Book("Иван Тургенев", "Отцы и дети", 1862, 6.3, BookStatus.PLANNED);
        Book book4 = new Book("Федор Достоевский", "Война и мир", 1865, 9.1, BookStatus.FINISHED);
        Book book5 = new Book("Лев Толстой", "Вишневый сад", 1904, 5.9, BookStatus.READING);
        LibrartService librartService = new LibrartService();
        librartService.addBook(book1);
        librartService.addBook(book2);
        librartService.addBook(book3);
        librartService.addBook(book4);
        librartService.addBook(book5);
        int resultStatucCount = librartService.countByStatus(BookStatus.READING);
        System.out.println("Результат совпадений по статусу - " + resultStatucCount);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("0 - закрыть меню");
            System.out.println("1 - добавить книгу");
            System.out.println("2 - вывести все книги");
            System.out.println("3 - поиск книги по названию");
            System.out.println("4 - изменить статус книги");
            System.out.println("5 - поиск книги с высоким рейтингом");
            System.out.println("6 - расчет среднего рейтинга ");
            System.out.println("7 - удалить книгу");
            System.out.println("8 - итог по библиотеке");
            System.out.println("9 - сортировка книг по возрастанию");
            int result1 = Integer.parseInt(sc.nextLine());
            if (result1 == 0) {
                System.out.println("Закрываем меню...");
                break;
            }
            switch (result1) {
                case 1:
                    System.out.println("Введите фамилию и имя автора: ");
                    String resultAuthor = sc.nextLine();
                    System.out.println("Укажите название книги: ");
                    String resultTtitle = sc.nextLine();
                    System.out.println("Укажите год ее выпуска: ");
                    int resultYear = Integer.parseInt(sc.nextLine());
                    System.out.println("Введите рейтинг книги: ");
                    double resultRating = Double.parseDouble(sc.nextLine());
                    System.out.println("Укажите статус книги: ");
                    String resultStatus = sc.nextLine();
                    BookStatus bookStringStatus = BookStatus.valueOf(resultStatus.toUpperCase());
                    Book newBook = new Book(resultAuthor, resultTtitle, resultYear, resultRating, bookStringStatus);
                    librartService.addBook(newBook);
                    System.out.println("Книга успешно добавлена.");
                    break;
                case 2:
                    librartService.printBook();
                    break;
                case 3:
                    System.out.println("Введите название книги для поиска: ");
                    String searchResult = sc.nextLine();
                    Book bookResult = librartService.findFirstByWord(searchResult);
                    if (bookResult == null) {
                        System.out.println("Совпадений не было найдено.");
                    } else {
                        System.out.println("Совпадение было найдено, автор данной книги: -  " + bookResult.getAuthor());
                    }
                    break;
                case 4:
                    System.out.println("Введите название книги у которой нужно изменить статус: ");
                    String changeResult = sc.nextLine();
                    System.out.println("Укажите статус на который нужно изменить: - READING, PLANNED, FINISHED");
                    String resultStatusBook = sc.nextLine();
                    BookStatus bookStatus = BookStatus.valueOf(resultStatusBook.toUpperCase());
                    librartService.changeStatus(changeResult, bookStatus);
                    System.out.println("Статус книги изменен успешно.");
                    break;
                case 5:
                    System.out.println("Ищем книгу с самым высоким рейтингом....");
                    Book NewBookResult = librartService.findBestBook();
                    if (NewBookResult != null) {
                        System.out.println("Книга с самым высоким рейтингом найдена: " + NewBookResult.getTitle());
                    } else {
                        System.out.println("Библиотека пуста. Лидирующей книги нет");
                    }
                    break;
                case 6:
                    System.out.println("Производим расчет среднего рейтинга...");
                    double resultAverage = librartService.averageFinishedRating();
                    System.out.println("Результат среднего рейтинга - " + resultAverage);
                    break;
                case 7:
                    System.out.println("Введите номер книги для удаления. Отсчет начинается с 0 - n");
                    int resultRemove = Integer.parseInt(sc.nextLine());
                    boolean statusRemove = librartService.removeBook(resultRemove);
                    if (statusRemove) {
                        System.out.println("Книга успешно удалена из списка.");
                    } else {
                        System.out.println("Ошибка, книга не удалена.");
                    }
                    break;
                case 8:
                    String summary = librartService.getLibrarySummary();
                    System.out.println(summary);
                    break;
                case 9:
                    librartService.sortRatingBook();
                    break;


            }
        }
    }
}

class Book {
    private String author;
    private String title;
    private int year;
    private double rating;
    private BookStatus bookStatus;

    Book(String author, String title, int year, double rating, BookStatus bookStatus) {
        setAuthor(author);
        setTitle(title);
        setYear(year);
        setRating(rating);
        setBookStatus(bookStatus);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Отсутствует название книги.");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Отсутствуют данные автора книги.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0 && year < 2027) {
            this.year = year;
        } else {
            System.out.println("Год книги указан неверно.");
        }

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            System.out.println("Рейтинг указан неверно.");
        }
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

}

enum BookStatus {
    PLANNED,
    READING,
    FINISHED
}

class LibrartService {
    private ArrayList<Book> arrayBook = new ArrayList<>();


    public void printBook() {
        if (arrayBook.isEmpty()) {
            System.out.println("Список пуст. Сначала добавьте обьекты.");
        }
        for (Book b : arrayBook) {
            System.out.println("Название книги: " + b.getTitle() + " Автор: " + b.getAuthor() + " Год издания: " + b.getYear() + " Рейтинг: " + b.getRating());
        }
    }

    public void addBook(Book book) {
        arrayBook.add(book);
    }

    public Book findFirstByWord(String word) {
        for (Book b : arrayBook) {
            if (b.getTitle().equalsIgnoreCase(word) || b.getAuthor().equalsIgnoreCase(word)) {
                return b;
            }
        }
        return null;
    }

    public int countByStatus(BookStatus bookStatus) {
        int count = 0;
        for (Book b : arrayBook) {
            if (bookStatus == b.getBookStatus()) {
                count++;
            }
        }
        return count;
    }

    public void changeStatus(String name, BookStatus status) {
        for (Book b : arrayBook) {
            if (name.equals(b.getTitle())) {
                b.setBookStatus(status);
                return;
            }


        }
        System.out.println("Книга с таким названием не найдена.");
    }

    public boolean removeBook(int index) {
        if (index >= 0 && index < arrayBook.size()) {
            arrayBook.remove(index);
            return true;
        }
        return false;


    }

    public double averageFinishedRating() {
        double sum = 0;
        int count = 0;
        for (Book b : arrayBook) {
            if (b.getBookStatus() == BookStatus.FINISHED) {
                sum += b.getRating();
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }

    public Book findBestBook() {
        if (arrayBook == null || arrayBook.isEmpty()) {
            return null;


        }
        Book bestBook = arrayBook.get(0);
        for (Book b : arrayBook) {
            if (b.getRating() > bestBook.getRating()) {
                bestBook = b;
            }
        }
        return bestBook;
    }

    public String getLibrarySummary() {
        if (arrayBook == null || arrayBook.isEmpty()) {
            return ("Библиотека пуста.");
        }
        String summary = "---Сводка по библиотеке---\n";
        summary = summary + "Общее количество книг: " + arrayBook.size() + "\n";
        summary = summary + "Список изданий:\n";


        for (int i = 0; i < arrayBook.size(); i++) {
            Book book = arrayBook.get(i);
            summary = summary + (i + 1) + ". " + book.getTitle() + " — " + book.getAuthor() + "\n";
        }

        return summary;
    }
     public void sortRatingBook(){
         arrayBook.sort((p1, p2) -> Double.compare(p1.getRating(), p2.getRating()));
         for (Book b:arrayBook){
             System.out.println("Название книги: " + b.getTitle() + " Автор: "
                     + b.getAuthor() + " Год издания: " + b.getYear() + " Рейтинг: " + b.getRating());
         }

     }
}
