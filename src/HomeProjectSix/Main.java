package HomeProjectSix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
        while (true) {
            System.out.println("--- Меню ---");
            System.out.println("1. Добавить книгу ");
            System.out.println("2. Показать все материалы");
            System.out.println("3. Найти материал по id");
            System.out.println("4. Найти материалы по названию");
            System.out.println("5. Выдать материал читателю ");
            System.out.println("6. Вернуть материал ");
            System.out.println("7. Удалить материал");
            System.out.println("8. Показать уникальные жанры");
            System.out.println("9. Показать статистику по статусам");
            System.out.println("10.Отсортировать по названию ");
            System.out.println("11.Отсортировать по годy");
            System.out.println("12.Сохранить в файл ");
            System.out.println("13.Загрузить из файла");
            System.out.println("14.Показать итог по библиотеке");
            System.out.println("0.Выход");
            System.out.print("Выберите действие: ");
            int result = Integer.parseInt(sc.nextLine());
            switch (result) {
                case 1:

                    System.out.println("Введите id :");
                    String id = sc.nextLine();
                    System.out.println("Введите название :");
                    String name = sc.nextLine();
                    System.out.println("Введите год:");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.println("Введите жанр:");
                    Genre genre = Genre.valueOf(sc.nextLine());
                    System.out.println("Введите статус:");
                    ItemStatus status = ItemStatus.valueOf(sc.nextLine());
                    if (name.isEmpty() || year < 0 || year > 2024) {
                        System.out.println("Ошибка: неверно введено название или год!");
                        break;
                    }
                    if (libraryService.findFirstById(id) != null) {
                        System.out.println("Ошибка: материал с таким ID уже существует!");
                        break;
                    }
                    Book book = new Book(id, name, year, genre, status);
                    libraryService.addItem(book);
                    break;
                case 2:
                    libraryService.printItems1();
                    break;
                case 3:
                    System.out.println("Введите id для поиска совпадений:");
                    String searchId = sc.nextLine();
                    LibraryItem libraryItem = libraryService.findFirstById(searchId);
                    if (libraryItem != null) {
                        System.out.println("Найден материал: " + libraryItem.getInfo());
                    } else {
                        System.out.println("Материал с таким ID не найден.");
                    }
                    break;
                case 4:
                    System.out.println("Введите название для поиска материала:");
                    String searchTitle = sc.nextLine();
                    ArrayList<LibraryItem> arrayItem = libraryService.findByTitle(searchTitle);
                    if (arrayItem.isEmpty()) {
                        System.out.println("Ничего не найдено.");
                    } else {
                        for (LibraryItem item : arrayItem) {
                            System.out.println(item.getInfo());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Введите id материала:");
                    String resultId = sc.nextLine();
                    System.out.println("Введите ваше имя:");
                    String resultName = sc.nextLine();
                    libraryService.borrowItem(resultId, resultName);
                    break;
                case 6:
                    System.out.println("Введите id материала для возврата:");
                    String resultReturn = sc.nextLine();
                    libraryService.returnItem(resultReturn);
                    break;
                case 7:
                    System.out.println("Введите id по которому произвести удаление:");
                    String resultRemove = sc.nextLine();
                    libraryService.removeItem(resultRemove);
                    break;
                case 8:
                    System.out.println("Уникальные жанры в библиотеке:");
                    System.out.println(libraryService.collectGenres());
                    break;
                case 9:
                    System.out.println("Статистика по статусам:");
                    HashMap<ItemStatus,Integer> statusMap = libraryService.countStatus();
                    for (ItemStatus i:statusMap.keySet()){
                        System.out.println(i + ": " + statusMap.get(i) + "шт.");

                    } break;
                case 10:
                    System.out.println("Сортировка по названию:");
                    libraryService.sortTitle();
                    break;
                case 11:
                    System.out.println("Сортировка по году:");
                    libraryService.sortYear();
                    break;
                case 12:
                    System.out.println("Введите название файла куда нужно сохранить материал:");
                    LibraryFileStorage libraryFileStorage = new LibraryFileStorage();
                    String save = sc.nextLine();
                    libraryFileStorage.saveItems(libraryService.getArrayItems(),Path.of(save));
                    break;
                case 13:
                    System.out.println("Введите название файла для его чтения:");
                    LibraryFileStorage libraryFileStorage1 = new LibraryFileStorage();
                   ArrayList<LibraryItem> l1= libraryFileStorage1.loadItems(Path.of(sc.nextLine()));
                    libraryService.setArrayItems(l1);
                    break;
                case 14:
                    System.out.println("Всего материала в библиотеке: " + libraryService.getArrayItems().size());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Неверный пункт меню. Пожалуйста, выберите число от 0 до 14.");
                    break;


            }
        }

    }
}

class LibraryService {
    private ArrayList<LibraryItem> arrayItems = new ArrayList<>();

    public void addItem(LibraryItem item) {
        arrayItems.add(item);

    }

    public ArrayList<LibraryItem> getArrayItems() {
        return arrayItems;
    }

    public void setArrayItems(ArrayList<LibraryItem> arrayItems) {
        this.arrayItems = arrayItems;
    }

    public void printItems1() {
        if (!arrayItems.isEmpty()) {
            for (LibraryItem l : arrayItems) {
                System.out.println(l.getInfo());
            }
        } else {
            System.out.println("Библиотека пуста.");
        }

    }

    public LibraryItem findFirstById(String id) {
        for (LibraryItem l : arrayItems) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    public ArrayList<LibraryItem> findByTitle(String title) {
        ArrayList<LibraryItem> newArray = new ArrayList<>();
        for (LibraryItem l : arrayItems) {
            if (l.getTitle().equalsIgnoreCase(title)) {
                newArray.add(l);
            }
        }
        return newArray;
    }

    public boolean removeItem(String id) {
        LibraryItem itemRemove = findFirstById(id);
        if (itemRemove != null) {
            arrayItems.remove(itemRemove);
            return true;
        }
        return false;

    }

    public void borrowItem(String id, String readerName) {
        LibraryItem itemSearch = findFirstById(id);
        if (itemSearch == null) {
            System.out.println("Материал не найден.");
            return;
        }
        if (itemSearch instanceof Borrowable) {
            ((Borrowable) itemSearch).borrow(readerName);

        } else {
            System.out.println("Этот материал нельзя взять на дом.");
        }
    }

    public void returnItem(String id) {
        LibraryItem returnItemNew = findFirstById(id);
        if (returnItemNew instanceof Borrowable) {
            ((Borrowable) returnItemNew).returnBack();

        } else {
            System.out.println("Материал не найден.");
        }
    }

    public HashSet<Genre> collectGenres() {
        HashSet<Genre> genres = new HashSet<>();
        for (LibraryItem l : arrayItems) {
            genres.add(l.getGenre());
        }
        return genres;
    }

    public HashMap<ItemStatus, Integer> countStatus() {
        HashMap<ItemStatus, Integer> count = new HashMap<>();
        for (LibraryItem l : arrayItems) {
            ItemStatus status = l.getItemStatus();
            count.put(status, count.getOrDefault(status, 0) + 1);
        }
        return count;
    }

    public void sortTitle() {
        arrayItems.sort((item1, item2) -> item1.getTitle().compareTo(item2.getTitle()));
        System.out.println("Библиотека отсортирована по названию.");
    }

    public void sortYear() {
        arrayItems.sort((item1, item2) -> Integer.compare(item1.getYear(), item2.getYear()));
        System.out.println("Библиотека отсортирована по году издания.");
    }

}

enum Genre {
    FICTION,
    EDUCATION,
    HISTORY,
    TECHNOLOGY,
    BUSINESS
}

enum ItemStatus {
    AVAILABLE,
    BORROWED,
    LOST
}

interface Borrowable {
    public void borrow(String readerName);

    public void returnBack();
}

abstract class LibraryItem {
    private String id;
    private String title;
    private int year;
    private Genre genre;
    private ItemStatus itemStatus;

    public LibraryItem(String id, String title, int year, Genre genre, ItemStatus itemStatus) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;

        this.itemStatus = itemStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    abstract String getInfo();
}

class Book extends LibraryItem implements Borrowable {
    public Book(String id, String title, int year, Genre genre, ItemStatus itemStatus) {
        super(id, title, year, genre, itemStatus);
    }

    @Override
    String getInfo() {
        return "Книга [" + getId() + "]: '" + getTitle() + "' (" + getYear() + ") - " + getGenre() + ". Статус: " + getItemStatus();
    }

    @Override
    public void borrow(String readerName) {
        if (getItemStatus() == ItemStatus.AVAILABLE) {
            setItemStatus(ItemStatus.BORROWED);
            System.out.println("Материал выдан читателю: " + readerName);
        } else {
            System.out.println("Материал сейчас недоступен.");
        }
    }

    @Override

    public void returnBack() {
        if (getItemStatus() == ItemStatus.BORROWED) {
            setItemStatus(ItemStatus.AVAILABLE);
            System.out.println("Материал успешно возвращен.");
        } else {
            System.out.println("Ошибка: этот материал сейчас не на руках!");
        }
    }
}

class Magazine extends LibraryItem implements Borrowable {
    public Magazine(String id, String title, int year, Genre genre, ItemStatus itemStatus) {
        super(id, title, year, genre, itemStatus);
    }

    @Override
    public String getInfo() {
        return "Журнал [" + getId() + "]: '" + getTitle() + "' (" + getYear() + ") - " + getGenre() + ". Статус: " + getItemStatus();
    }

    @Override
    public void borrow(String readerName) {
        if (getItemStatus() == ItemStatus.AVAILABLE) {
            setItemStatus(ItemStatus.BORROWED);
            System.out.println("Материал выдан читателю: " + readerName);
        } else {
            System.out.println("Материал недоступен.");
        }
    }

    @Override
    public void returnBack() {
        if (getItemStatus() == ItemStatus.BORROWED) {
            setItemStatus(ItemStatus.AVAILABLE);
            System.out.println("Материал успешно возвращен.");
        } else {
            System.out.println("Ошибка: этот материал сейчас не на руках!");
        }
    }
}

class AudiBook extends LibraryItem implements Borrowable {
    public AudiBook(String id, String title, int year, Genre genre, ItemStatus itemStatus) {
        super(id, title, year, genre, itemStatus);
    }

    @Override
    public String getInfo() {
        return "Аудио книга [" + getId() + "]: '" + getTitle() + "' (" + getYear() + ") - " + getGenre() + ". Статус: " + getItemStatus();
    }

    @Override
    public void borrow(String readerName) {
        if (getItemStatus() == ItemStatus.AVAILABLE) {
            setItemStatus(ItemStatus.BORROWED);
            System.out.println("Материал выдан читателю:" + readerName);
        } else {
            System.out.println("Материал недоступен.");
        }
    }

    @Override
    public void returnBack() {
        if (getItemStatus() == ItemStatus.BORROWED) {
            setItemStatus(ItemStatus.AVAILABLE);
            System.out.println("Материал успешно возвращен.");
        } else {
            System.out.println("Ошибка: этот материал сейчас не на руках!");
        }
    }
}

class LibraryFileStorage {
    public void saveItems(ArrayList<LibraryItem> items, Path path) {
        ArrayList<String> newArray = new ArrayList<>();
        for (LibraryItem l : items) {
            String type = "";
            if (l instanceof Book) {
                type = "BOOK";
            } else if (l instanceof AudiBook) {
                type = "AUDIBOOK";

            } else if (l instanceof Magazine) {
                type = "MAGAZINE";
            }
            String line = type + "|" + l.getId() + "|" + l.getTitle() + "|" + l.getYear() + "|" + l.getGenre() + "|" + l.getItemStatus();
            newArray.add(line);


        }
        try {
            Files.write(path, newArray);
            System.out.println("Файл успешно сохранен.");
        } catch (IOException e) {
            System.out.println("Проблема с сохранением файла.");
            ;
        }
    }

    public ArrayList<LibraryItem> loadItems(Path path) {
        ArrayList<LibraryItem> arrayString = new ArrayList<>();
        try {
            List<String> list = Files.readAllLines(path);
            for (String l : list) {
                String[] massive = l.split("\\|");
                String type = massive[0];
                String id = massive[1];
                String title = massive[2];
                int year = Integer.parseInt(massive[3]);
                Genre genre = Genre.valueOf(massive[4]);
                ItemStatus status = ItemStatus.valueOf(massive[5]);
                if (type.equalsIgnoreCase("BOOK")) {
                    LibraryItem libraryItem = new Book(id, title, year, genre, status);
                    arrayString.add(libraryItem);
                } else if (type.equalsIgnoreCase("AUDIBOOK")) {
                    LibraryItem libraryItem2 = new AudiBook(id, title, year, genre, status);
                    arrayString.add(libraryItem2);
                } else if (type.equalsIgnoreCase("MAGAZINE")) {
                    LibraryItem libraryItem3 = new Magazine(id, title, year, genre, status);
                    arrayString.add(libraryItem3);

                }

            }

        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла.");
        }
        return arrayString;


    }

}