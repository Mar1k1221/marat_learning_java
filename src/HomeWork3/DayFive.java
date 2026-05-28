package HomeWork3;

import java.util.ArrayList;
import java.util.Scanner;

public class DayFive {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- МОЯ КИНОТЕКА ---");
            System.out.println("1. Добавить новый фильм");
            System.out.println("2. Посмотреть весь каталог");
            System.out.println("3. Найти фильм по слову");
            System.out.println("4. Посчитать количество просмотренных фильмов");
            System.out.println("5. Отметить фильм как просмотренный");
            System.out.println("0. Выход");
            System.out.print("Выберите команду: ");
            String command = scanner.nextLine();
            if (command.equals("1")) {
                System.out.println("Укажите название фильма: ");
                String title = scanner.nextLine();
                System.out.println("Укажите рейтинг фильма: ");
                double rating = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Статус просмотра фильма: ");
                boolean isWatched = scanner.nextBoolean();
                scanner.nextLine();
                Movie movOne = new Movie(title,rating,isWatched);
                movies.add(movOne);


            } else if (command.equals("2")) {
                printMovies(movies);

            } else if (command.equals("3")) {
                System.out.println("Введите ваше слово: ");
                String name = scanner.nextLine();
                searchByWord(movies, name);

            } else if (command.equals("4")) {

                int resultCountWatch = countWatchedMovies(movies);
                System.out.println("Количество просмотренных фильмов: " + resultCountWatch);
            } else if (command.equals("5")) {
                System.out.println("Введите точное название фильма: ");
                String name = scanner.nextLine();
                markAsWatched(movies,name);

            } else if (command.equals("0")) {
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("Неизвестная команда, попробуйте снова.");
            }
        }


    }

    static void printMovies(ArrayList<Movie> arr) {
        if (arr.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (Movie m : arr) {
                System.out.println(m);
            }

        }

    }

    static void searchByWord(ArrayList<Movie> arr, String name) {
        String s = name.toLowerCase();
        boolean isWound = false;
        for (Movie m : arr) {
            if (m.title.toLowerCase().contains(s)) {
                isWound = true;
                System.out.println("Cовпадение найдено " + m);
            }

        }
        if (!isWound) {
            System.out.println("Cовпадений не было найдено.");

        }
    }

    static void markAsWatched(ArrayList<Movie> arr, String name) {

        for (Movie m : arr) {
            if (m.title.equalsIgnoreCase(name)) {
                m.isWatched = true;
                System.out.println("Статус фильма обновлен.");
                return;
            }

        }
        System.out.println("Фильма с таким названием не найдено.");
    }


    static int countWatchedMovies(ArrayList<Movie> arr) {
        int countWatched = 0;
        for (Movie m : arr) {
            if (m.isWatched) {
                countWatched++;
            }
        }
        return countWatched;
    }
}

class Movie {
    String title;
    double rating;
    boolean isWatched;

    public Movie(String title, double rating, boolean isWatched) {
        this.title = title;
        this.rating = rating;
        this.isWatched = isWatched;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", isWatched=" + isWatched +
                '}';
    }
}
