package HomeWork6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DayFive {
    public static void main(String[] args) {
        ArrayList<Prep> arrayPrep = new ArrayList<>();
        Prep prep1 = new Prep("Том ям", 15);
        Prep prep2 = new Prep("Креветки" ,6);
        Prep prep3 = new Prep("Колбаса", 4);
        arrayPrep.add(prep1);
        arrayPrep.add(prep2);
        arrayPrep.add(prep3);
        ArrayList<String> csvData = new ArrayList<>();
        for (Prep p: arrayPrep){
            String line = p.getName() + ";" + p.getAmount();
            csvData.add(line);
        }
        Path path = Path.of("arrayPrep");
        try {
            Files.write(path,csvData);
            System.out.println("Журнал заготовок успешно сохранен!");
        } catch (IOException e) {
            System.out.println("Ошибка записи! Файл недоступен.");
        }

        System.out.println("---Наступило утро. Читаем файл: ---");
        try {
            List<String> loaded = Files.readAllLines(path);
            for (String s: loaded){
                String [] massive = s.split(";");

                String name = massive[0];
                int amount = Integer.parseInt(massive[1]);

                Prep loadedPrep = new Prep(name,amount);
                System.out.println(loadedPrep);

            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения! Журнал не найден.");
        }
    }
}
class Prep{
    private String name;
    private int amount;

    public Prep(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Заготовки: " +
                "Название - '" + name + '\'' +
                " || Количество  - " + amount +
                '.';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
