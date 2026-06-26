package HomeWork6;

import java.util.ArrayList;
import java.util.Scanner;

public class DayOnePartTwo {
    public static void main(String[] args) {
StudentService studentService = new StudentService();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("0 - Выйти из меню. ");
            System.out.println("1 - Добавить студента.");
            System.out.println("2 - Найти средний балл студента. ");
            System.out.println("3 - Вывести студентов выше среднего.");
            System.out.println("4 - Найти лучшего студента.");
            int resultMenu = Integer.parseInt(sc.nextLine());
            switch (resultMenu){
                case 1:
                    try {
                        System.out.println("Введите имя студента...");
                        String newName = sc.nextLine();
                        System.out.println("Введите балл студента...");
                        double newBall = Double.parseDouble(sc.nextLine());
                        Student newStudent = new Student(newName, newBall);
                        studentService.addStudent(newStudent);
                    } catch (Exception e){
                        System.out.println("Данные внесены некорректно, попробуйте снова.");
                    } break;
                case 2:
                   double  resultAverageBall =  studentService.averageBall();
                    System.out.println("Средний балл всех студентов = "  +resultAverageBall);
                    break;
                case 3:
                          ArrayList<Student> arrayList = studentService.findStudentsAboveAverage();
                          for (Student s: arrayList){
                              System.out.println("Имя студента: " + s.getName() + " Балл: " + s.getBall());
                          } break;
                case 4:
                    Student bestStudent = studentService.findBestStudent();
                    if (bestStudent != null){
                    System.out.println("Имя лучшего студента " + bestStudent.getName() + " Балл:" + bestStudent.getBall());}
                    else {
                        System.out.println("Список пуст.");
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}

class StudentService {
    private ArrayList<Student> studentArrayList = new ArrayList<>();
public void addStudent(Student student){
    studentArrayList.add(student);
}
    public double averageBall(){
        if (studentArrayList.isEmpty()){
            return 0.0;
        }
        double sum = 0;

        for (Student s: studentArrayList){
            sum+=s.getBall();
        }
        return sum / studentArrayList.size();
    }
    public ArrayList<Student> findStudentsAboveAverage(){
        ArrayList <Student> newArray = new ArrayList<>();
        double resultAverage = averageBall();
        for (Student s: studentArrayList){
            if (s.getBall() > resultAverage){
                newArray.add(s);
            }
        }
        return newArray;
    }
    public Student findBestStudent(){
        double max = 0;
        Student maxStudent = null;
        for (Student s: studentArrayList){
            if (s.getBall() > max){
                max = s.getBall();
                maxStudent = s;
            }
        }
        return maxStudent;
    }
}


class Student {
    private String name;
    private double ball;

    public Student(String name, double ball) {
        setName(name);
        setBall(ball);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым..");
        }
    }

    public double getBall() {
        return ball;
    }

    public void setBall(double ball) {
        if (ball > 0.0 && ball <= 10.0) {
            this.ball = ball;
        } else {
            throw new IllegalArgumentException("Вы ввели некорректные данные об оценке студента");
        }
    }
}