package HomeProjectThree;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в менеджер задач!");
        System.out.println("Сколько задач вы хотите добавить в список?: ");
        int task = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < task; i++) {
            System.out.println("Введите название задачи: ");
            String title = sc.nextLine();
            System.out.println("Введите приоритет задачи: ");
            int priorety = sc.nextInt();
            sc.nextLine();
            System.out.println("Задача выполнена? Введите true или false.");
            boolean isCompleted = sc.nextBoolean();
            sc.nextLine();
            Task task1 = new Task(title, priorety, isCompleted);
            tasks.add(task1);


        }
        printTasks(tasks);
        int resultCompletedTask = countDoneTasks(tasks);
        System.out.println("Количество выполненных задач: " + resultCompletedTask);

        int resultUncompletedTast = countNotDoneTasks(tasks);
        System.out.println("Количество невыполненных задач: " + resultUncompletedTast);

        Task firstTask = findFirstImportantNotDoneTask(tasks);
        System.out.println("Первая невыполненная задача с высоким приоритетом: " + firstTask);


        double resultAveragePriority = averagePriority(tasks);
        System.out.println("Средний приоритет среди задач:  " + resultAveragePriority);


        String resultSummary = getSummary(tasks);
        System.out.println(resultSummary);

        if (!tasks.isEmpty()) {
            System.out.println("Введите слово для поиска совпадений: ");
            String str = sc.nextLine();
            System.out.println("Результат совпадений: " + containsWord(tasks, str));
        }
        if (!tasks.isEmpty()) {
            System.out.println("Введите индекс задачи которую хотите удалить.");
            int num = sc.nextInt();
            sc.nextLine();
            if (num >= 0 && num < tasks.size()) {
                tasks.remove(num);
                System.out.println("Задача по индексу " + num + " было удалена.");
            } else {
                System.out.println("Задачи по такой индексу не было найдено.");
            }
        } else {
            System.out.println("Вы не сможете удалить задачи из списка, так как массив пуст.");
        }

    }


    static void printTasks(ArrayList<Task> arr) {
        for (Task t : arr) {
            System.out.println(t);
        }
    }

    static int countDoneTasks(ArrayList<Task> arr) {
        int countCompleted = 0;
        for (Task t : arr) {
            if (t.isCompleted) {
                countCompleted++;
            }
        }
        return countCompleted;
    }

    static int countNotDoneTasks(ArrayList<Task> arr) {
        int countUncompleted = 0;
        for (Task t : arr) {
            if (!t.isCompleted) {
                countUncompleted++;
            }
        }
        return countUncompleted;
    }

    static Task findFirstImportantNotDoneTask(ArrayList<Task> arr) {
        for (Task t : arr) {
            if (t.priority == 5 && !t.isCompleted) {
                return t;
            }
        }
        return null;
    }

    static double averagePriority(ArrayList<Task> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (Task t : arr) {
            sum += t.priority;
        }
        double average = sum / arr.size();
        return average;
    }

    static boolean containsWord(ArrayList<Task> arr, String word) {
        String w = word.toLowerCase();
        for (Task t : arr) {
            if (t.title.toLowerCase().contains(w)) {
                return true;
            }
        }
        return false;
    }

    static String getSummary(ArrayList<Task> arr) {

        if (arr.isEmpty()) {
            return "Список пуст.";
        } else if (countNotDoneTasks(arr) < 3) {
            return "Нагрузка нормальная.";
        } else {
            return "Высокая нагрузка.";
        }
    }
}


class Task {
    String title;
    int priority;
    boolean isCompleted;

    public Task(String title, int priority, boolean isCompleted) {
        this.title = title;
        this.priority = priority;
        this.isCompleted = isCompleted;

    }

    @Override
    public String toString() {
        return "Задачи: " +
                "Название задачи:'" + title + '\'' +
                ",Приоритет: " + priority +
                ", Статус выполнение: " + isCompleted +
                ' ';
    }
}
