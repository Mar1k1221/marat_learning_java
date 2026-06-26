package HomeWork6;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class DayOnePartThree {
    public static void main(String[] args) {
TaskService taskService = new TaskService();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("0 - Выйти из меню.");
            System.out.println("1 - Добавить задачу в список.");
            System.out.println("2 - Показать все задачи.");
            System.out.println("3 - Найти просроченные задачи.");
            System.out.println("4 - Поменять статус по индексу");
            System.out.println("5 - Удалить задачу по индексу");
          int resultMenu = Integer.parseInt(sc.nextLine());
          switch(resultMenu) {
              case 1:
                  try {
                      System.out.println("Введите название задачи...");
                      String newNameTask = sc.nextLine();
                      System.out.println("Введите статус задачи...");
                      String resultStatus = sc.nextLine();
                      TaskStatus newTaskStatus = TaskStatus.valueOf(resultStatus.toUpperCase());
                      System.out.println("Просроченна ли данная задача? ");
                      boolean newIsOverdue = Boolean.parseBoolean(sc.nextLine());
                      Task newTask = new Task(newTaskStatus, newNameTask, newIsOverdue);
                      taskService.addTask(newTask);
                  } catch (Exception e) {
                      System.out.println("Внесенные данные некорректны. Попробуйте снова..");
                  }
                  break;
              case 2:
                  taskService.printTask();
                  break;
              case 3:
                  ArrayList<Task> newArray = taskService.taskIsOverdue();
                  if (!newArray.isEmpty()) {
                      for (Task t : newArray) {
                          System.out.println("Название просроченной задачи: " + t.getTaskName());
                      }
                  } else {
                      System.out.println("Список пуст. Просроченных задач нет.");
                  } break;


              case 4:
                  try {

                  System.out.println("Введите индекс задачи у которой нужно изменить статус: ");
                  int resultNewStatus = Integer.parseInt(sc.nextLine());
                  System.out.println("Введите новый статус - ");
                  String newStatus = sc.nextLine();
                  TaskStatus taskStatus = TaskStatus.valueOf(newStatus.toUpperCase());
                  taskService.newStatus(resultNewStatus,taskStatus);}
                  catch (Exception e){
                      System.out.println("Данные внесены некорректно, попробуйте снова.");
                  } break;
              case 5:
                  System.out.println("Введите номер задачи которую желаете удалить - ");
                  int removeResult = Integer.parseInt(sc.nextLine());
                 boolean result =  taskService.deleteTask(removeResult);
                  System.out.println("Удаление задачи....  " + result);
                  break;
              case 0:
                  System.exit(0);


          }
        }
    }
}
class TaskService{
    private ArrayList<Task> taskArrayList = new ArrayList<>();

    public void printTask(){
        if (!taskArrayList.isEmpty()){
        for (Task t: taskArrayList){
            System.out.println("Название задачи: " + t.getTaskName() + " Статус: " + t.getTaskStatus() + " Просроченна ли она: " + t.isOverdue() );
        }}
    }
    public void addTask(Task task){
        taskArrayList.add(task);
    }
    public ArrayList<Task> taskIsOverdue (){
        ArrayList<Task> newTaskArray = new ArrayList<>();
        for (Task t: taskArrayList){
            if (t.isOverdue()){
                newTaskArray.add(t);
            }

        } return newTaskArray;
    }
    public void newStatus(int index,TaskStatus taskStatus){
        if (index >= 0 && index < taskArrayList.size()){
        Task t = taskArrayList.get(index);
        t.setTaskStatus(taskStatus);
        }
        else {
            throw new IllegalArgumentException("Индекс введен некорректно, повторите снова.");
        }
    }
    public boolean deleteTask(int index){
        if (index >= 0 && index < taskArrayList.size()){
         taskArrayList.remove(index);
         return true;
        }
        return false;
    }
    }
class Task{
    private String taskName;
    private TaskStatus taskStatus;
    private boolean isOverdue;

    public Task(TaskStatus taskStatus, String taskName, boolean isOverdue) {
        setTaskName(taskName);
        setTaskStatus(taskStatus);
        this.isOverdue = isOverdue;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public void setOverdue(boolean overdue) {
        isOverdue = overdue;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        if (taskName != null && !taskName.trim().isEmpty()){
            this.taskName=taskName;
        } else {
            throw new IllegalArgumentException("Некорректный ввод названия.");
        }
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        if (taskStatus != null){
            this.taskStatus=taskStatus;
        } else {
            throw new IllegalArgumentException("Статус задачи не может быть равным null");
        }
    }
}
enum TaskStatus{
    NEW,
    IN_PROGRESS,
    DONE
}
