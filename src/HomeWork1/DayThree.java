package HomeWork1;

public class DayThree {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        if (a > b) {
            System.out.printf("число %d больше числа %d\n", a, b);

        } else if (a < b) {
            System.out.printf("число %d меньше числа %d\n", a, b);
        } else {
            System.out.println("Числа равны!");
        }

        int age = 17; /// Пропуск в заведение старше 18 лет
        if (age >= 18) {
            System.out.println("Вход в заведение разрешен!");
        } else {
            System.out.println("Приходите когда исполнится 18 лет!");
        }

        int number = 10; /// Четное ли число
        if (number % 2 == 0) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число нечетное");
        }


        int score = 88; /// Оценка по баллам
        if (score < 0 || score > 100) {
            System.out.println("Ошибка! Неверное количество баллов!!!");
        } else if (score >= 90) {
            System.out.println("Отлично");
        } else if (score >= 70) {
            System.out.println("Хорошо");

        } else if (score >= 50) {
            System.out.println("Удовлетворительно");
        } else if (score < 50) {
            System.out.println("Неудовлетворительно");
        } else {
            System.out.println("Ошибка: неверное количество баллов");
        }
        int hour = 6; /// Время
        if (hour >= 6) {
            System.out.println("Доброе утро!");
        } else if (hour >= 12) {
            System.out.println("Добрый день!");
        } else if (hour >= 18) {
            System.out.println("Добрый вечер!");
        } else if (hour >= 23) {
            System.out.println("Доброй ночи!");
        } else {
            System.out.println("Добро ночи!");
        }

        double amount = 1398;  /// Размер скидки
        boolean isVip = true;
        if (amount <= 1000) {
            double sale = amount * 5 / 100;
            System.out.println("Скидка 5% = " + sale);
        } else if (amount <= 5000) {
            double sale = amount * 10 / 100;
            System.out.println("Скидка 10% " + sale);
        } else if (amount > 1000 && isVip == true) {
            double sale = amount * 5 / 100;
            System.out.println("Скидка 5% " + sale);

        } else if (amount <= 1000 && isVip == true) {
            double sale = amount * 5 / 100;
            System.out.println("Скидка 5% " + sale);
        } else if (amount <= 5000 && isVip == true) {
            double sale = amount * 15 / 100;
            System.out.println("Скидка 15% " + sale);
        }

        int year = 2012; /// Високосный ли год
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " год — високосный");
        } else {
            System.out.println(year + " год — не високосный");
        }
        double orderAmount = 3500; /// Доставка
        int distance = 12;
        if (orderAmount > 5000) {
            System.out.println("Доставка будет бесплатная!");
        } else if (distance < 5) {
            System.out.println("Стоимость доставки 200 rub");
        } else if (distance >= 5 && distance < 20) {
            System.out.println("Доставка 500 rub");

        } else {
            System.out.println("Доставка 1000 rub");
        }

        int c = 5; /// Треугольник
        int d = 4;
        int e = 8;
        if (c + d > e || c + e > d || d + e > c) {
            System.out.println("Треугольник существует!");

        } else {
            System.out.println("Треугольник с такими сторонами не существует!");
        }
        if (c == d && c == e && e == d) {
            System.out.println("Это равносторонний треугольник");

        } else if (c == d || c == e || e == d) {
            System.out.println("Это равнобедренный треугольник");

        } else {
            System.out.println("Это обычный разносторонний треугольник");
        }
    }
}



