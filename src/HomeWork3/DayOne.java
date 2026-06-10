package HomeWork3;

import java.util.Objects;

public class DayOne {
    public static void main(String[] args) {
Student st1 = new Student("Oleg",24,9.3);
Student st2 = new Student("Michael",23,8.9);
Student st3 = new Student("Ivan",18,7.8);
Student st4 = new Student("Igor",20,8.3);

Student [] group = {st1,st2,st3,st4};

Student.minimumAge(group);

if (st1.grade > st2.grade){
    System.out.println("Ученик " + st1.name + " учится лучше, его балл " + st1.grade);
} else {
    System.out.println("Ученик " + st2.name + " учится лучше, его балл " + st2.grade);
}
double newGrade = 5.3;
st3.grade=newGrade;
System.out.println("У ученика " + st3.name +  " был изменен балл на " +st3.grade);
        Student.averageGradee(group);

    }

    static class Student {
        String name;
        int age;
        double grade;



        Student(String name, int age, double grade){
            this.name = name;
            this.age = age;
            this.grade = grade;

        } void print(){
            System.out.println("Имя: " + name + " возраст: " + age + " балл: " + grade);
        }
        static double averageGradee(Student[] group){
            double sum =0;
            for (int i =0; i < group.length; i++){
                group[i].print();
                sum+=group[i].grade;
            } double averageGrade= sum / group.length;
            System.out.println("Общий средний балл всей группы: " + averageGrade);
            return averageGrade;
        } static void minimumAge (Student [] arr){
            Student young= arr[0];
            for (int i = 1; i < arr.length; i++){
                if (arr[i].age < young.age ){
                    young = arr[i];
                }


                }
            System.out.println("Самый младший на потоке " + young.name + ", ему " + young.age + " лет.");



            }
        }
    }

