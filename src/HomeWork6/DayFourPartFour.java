package HomeWork6;

import java.util.ArrayList;
import java.util.Comparator;

public class DayFourPartFour {
    public static void main(String[] args) {
TaskOne taskOne1 = new TaskOne("Починить сервер",Status.IN_PROCESS,5);
TaskOne taskOne2 = new TaskOne("Убрать лишние классы",Status.COMPLETED,2);
TaskOne taskOne3 = new TaskOne("Создание нового микросервиса",Status.IN_PROCESS,4);
TaskOne taskOne4 = new TaskOne("Подготовка проекта к релизу",Status.IN_PROCESS,1);
        ArrayList<TaskOne> taskArray = new ArrayList<>();
        taskArray.add(taskOne1);
        taskArray.add(taskOne2);
        taskArray.add(taskOne3);
        taskArray.add(taskOne4);
        ArrayList<TaskOne> newSortArray = filterAndSortTasks(taskArray,Status.IN_PROCESS);
        System.out.println(newSortArray);

    }
    public static ArrayList<TaskOne> filterAndSortTasks(ArrayList<TaskOne> arrayList,Status status){
        ArrayList<TaskOne> sortArray = new ArrayList<>();
        for (TaskOne t: arrayList){
            if (t.getStatus() == status){
                sortArray.add(t);
            }

        } sortArray.sort(new Comparator<TaskOne>(){
            public int compare(TaskOne o1,TaskOne o2){
                return Integer.compare(o1.getPriority(),o2.getPriority());
            }
        });
        return sortArray;
    }
}
class TaskOne{
    private String description;
    private Status status;
    private int priority;

    public TaskOne(String description, Status status, int priority) {
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Задача:" +
                "Описание задачи: '" + description + '\'' +
                ", Статус задачи: " + status +
                ", Приоритет: " + priority +
                '}';
    }
}
enum Status{
  IN_PROCESS,
    COMPLETED,
    IN_LINE
}