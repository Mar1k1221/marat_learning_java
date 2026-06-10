package HomeWork3;

import java.util.ArrayList;
import java.util.Arrays;

public class DayFour {
    public static void main(String[] args) {
        Task task1 = new Task("Проверка ошибок", true, 2);
        Task task2 = new Task("Сверка информации", false, 1);
        Task task3 = new Task("Устранение неполадок на сервере", true, 5);
        Task task4 = new Task("Обновление доменов", false, 4);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        printTasks(tasks);

        int resultCount = countDoneTasks(tasks); /// Принимаем результат из метода, чтобы дальше работать с ним
        System.out.println("Количество выполненных задач: " + resultCount);

        Task result = findFirstImportantTask(tasks);
        if (result != null) {
            System.out.println(result.title);
        } else {
            System.out.println("Приоритетных задач на сегодня нет.");
        }

        double resultAverage = averagePriority(tasks);
        System.out.println("Средний приоритет всех задач: " + resultAverage);

        boolean resultContains=containsWord(tasks,"Проверка"); /// Принимаем результат из метода boolean(true или false)
        if (resultContains){                                             /// и работаем с ним дальше
            System.out.println("Совпадение было найдено!");
        } else {
            System.out.println("Совпадений не найдено.");
        }


    }

    static void printTasks(ArrayList<Task> arr) { /// Метод берет в работу наш аррэй лист и при каждой проходке, данный метод
        System.out.println("ВЕСЬ СПИСОК ЗАДАЧ"); ///  вызывает предыдущий метод printTask
        for (Task task : arr) {
            task.printTask();
        }

    }

    static int countDoneTasks(ArrayList<Task> arr) { /// Метод берет в параметры Аррэй лист
        int countTask = 0;
        for (Task t : arr) {
            if (t.isDone) {
                countTask++;
            }
        }
        return countTask; /// Возвращает итоговый результат типа int в main

    }

    static double averagePriority(ArrayList<Task> arr) {
        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i).priority;
        }
        double average = (double) sum / arr.size();
        return average;

    }

    static Task findFirstImportantTask(ArrayList<Task> arr) {
        for (Task t : arr) {
            if (t.priority == 1 && t.isDone == false) {
                return t;                                                             /// Возвращает переменную типа таск, если условие true
            }
        }
        return null; /// Если предыдущее условие false, то мы вернем null(пустоту)
    } static boolean containsWord(ArrayList<Task> arr, String string){
        for (Task t:arr){
            if (t.title.contains(string)){
                return true;
            }
            }
        return false;  }
    }




class Task {
    String title;
    boolean isDone;
    int priority;

    public Task(String title, boolean isDone, int priority) {
        this.title = title;
        this.isDone = isDone;
        this.priority = priority;
    }

    void printTask() { /// Метод ничего не принимает, просто печатает текст
        System.out.println("Задача: " + title + " Приоритет задачи: " + priority + " Выполнение задачи:  " + isDone);

    }
}



