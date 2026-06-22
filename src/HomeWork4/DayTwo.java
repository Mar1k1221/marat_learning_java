package HomeWork4;

import java.util.ArrayList;

public class DayTwo {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Изучить Java", "Подробное изучение инкапсуляции", false);
        Task task2 = new Task("Сделать коммит на GitHub", "После изучения сделать коммит", false);
        Task task3 = new Task("Посмотреть расписание обучения", "Составить расписание обучения на 1 месяц вперед", false);

        task1.setCompleted(true);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.printAllTasks();

        System.out.println("--- Вывод только завершенных задач ---");
        taskManager.printCompletedTask();
    }

    static class Task {
        private String title;
        private String description;
        private boolean isCompleted = false;

        Task(String title, String description, boolean isCompleted) {
            setTitle(title);
            setDescription(description);
            setCompleted(isCompleted);
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setTitle(String title) {
            if (title != null && !title.trim().isEmpty()) {
                this.title = title;
            } else {
                throw new IllegalArgumentException("Ошибка. Название задачи не может быть пустым.");
            }
        }

        public void setDescription(String description) {
            if (description != null && !description.trim().isEmpty()) {
                this.description = description;
            } else {
                throw new IllegalArgumentException("Ошибка. Описание задачи не может быть пустым.");
            }
        }

        public void setCompleted(boolean isCompleted) {
            this.isCompleted = isCompleted;
        }
    }

    static class TaskManager {
        private ArrayList<Task> tasks = new ArrayList<>();

        public void addTask(Task task) {
            tasks.add(task);
        }

        public void printAllTasks() {
            for (Task t : tasks) {

                System.out.println(t.getTitle());
            }
        }

        public void printCompletedTask() {
            for (Task t : tasks) {

                if (t.isCompleted()) {
                    System.out.println("Задача: " + t.getTitle() + " Статус: " + t.isCompleted());
                }
            }
        }
    }
}