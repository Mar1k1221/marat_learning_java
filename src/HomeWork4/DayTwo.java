package HomeWork4;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class DayTwo {
     static void main(String[] args) {

         TaskManager taskManager = new TaskManager();
         Task task1 = new Task("Изучить Java","Подробное изучени инкапсуляции",false);
         Task task2 = new Task("Сделать коммит на GitHub","После изучения сделать коммит",false);
         Task task3 = new Task("Посмотреть расписание обучения","Составить расписание обучения на 1 месяц вперед",false);
task1.setCompleted(true);
taskManager.addTask(task1);
taskManager.addTask(task2);
taskManager.addTask(task3);
taskManager.printAllTasks();


    }

   static class Task{
        private String title;
        private String descrpiption;
        private boolean isCompleted = false;

        Task(String title, String descrpiption, boolean isCompleted){
            setTitle(title);
            setDescrpiption(descrpiption);
            setCompleted(isCompleted);

        }
        public String getTitle(){
            return title;
        }
        public String getDescrpiption(){
            return descrpiption;
        }

       public boolean isCompleted() {
           return isCompleted;
       }
       public void setTitle(String title){
            if (title !=null && !title.trim().isEmpty()){
                this.title = title;
            } else{
                System.out.println("Ошибка. Заполните название.");
            }

       }
       public void setDescrpiption( String descrpiption){
            if (descrpiption !=null && !descrpiption.trim().isEmpty() ){
                this.descrpiption = descrpiption;
            } else {
                System.out.println("Ошибка. Заполните описание.");
            }
       }
       public void setCompleted(boolean isCompleted){
            this.isCompleted = isCompleted;
       }
   }
   static class TaskManager{
          private ArrayList<Task> tasks = new ArrayList<>();

          public void addTask(Task task){
             tasks.add(task);
         }
         public void printAllTasks(){
             for (Task t: tasks){
                 System.out.println(t.title);
             }

         } public void printCompletedTask(){
             for (Task t: tasks){
                 if (t.isCompleted){
                     System.out.println("Задача: " + t.getTitle() + " Статус: " + t.isCompleted());
                 }
             }
       }

   }
}
