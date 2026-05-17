package HomeWork2;

public class DayFive {
    public static void main(String[] args) {
        String recipe = "Куриная грудка-130, Гречка-310, Брокколи-30, Сливочное масло-717, Сахар-398";
        String[] promocode = {" eApTeka2026 ", "SALE-50", "eapteka_new", "  EAPTEKA_PRO  ", "VITAMIN"};
        String schedule = "01Мая-Рабочий, 02Мая-Рабочий, 03Мая-Выходной, 04Мая-Выходной, 05Мая-Рабочий";
        String inventory = " Яблоки-10, Молоко-5, яблоки-3 , Вода-20, ЯБЛОКИ-2 ";
        int maxCalories = 200;
        checkCalories(recipe, maxCalories);
        filterPromocodes(promocode);
        countWordDays(schedule);
        countApples(inventory);
    }

    static void checkCalories(String data, int maxCalories) {
        String[] str = data.split(",");
        for (int i = 0; i < str.length; i++) {
            String item = str[i].trim();
            String[] parts = item.split("-");
            int ccal = Integer.parseInt(parts[1]);
            if (ccal <= maxCalories) {
                System.out.println(parts[0] + " подходит для ПП!");
            }
        }

    }

    static void filterPromocodes(String[] str) {
        int validCount = 0;
        for (int i = 0; i < str.length; i++) {
            String item = str[i].trim().toUpperCase();
            boolean result = item.contains("EAPTEKA");
            if (result) {
                System.out.println(item);
                validCount++;
            }
        }
        System.out.println("Валидных промокодов найдено: " + validCount);
    }

    static void countWordDays(String string) {
        int countWork = 0;
        String[] days = string.split(",");
        for (int i = 0; i < days.length; i++) {
            String[] st = days[i].trim().split("-");
            if (st[1].equals("Рабочий")) {
                countWork++;
            }
        }
        System.out.println("Количество рабочих смен: " + countWork);
    }

    static int countApples(String data) {
        int totalApples = 0;
        String[] items = data.split(",");
        for (int i = 0; i < items.length; i++) {
            String[] parts = items[i].trim().split("-");
            String name = parts[0].toLowerCase();
            if (name.equals("яблоки")) {
                int weight = Integer.parseInt(parts[1]);
                totalApples = totalApples + weight;

            }
        }
        System.out.println("Всего кг яблок: " + totalApples);
        return totalApples;
    }


}

