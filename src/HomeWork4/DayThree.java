package HomeWork4;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class DayThree {
   public  static void main(String[] args) {
Task task1 = new Task("Анализ проекта", "Проверка на баги и ошибки");
Task task2 = new Task("Откат фичи","Отмена проделанной работы");
Task task3 = new Task("Релиз проекта -1", "Провести релиз проекта и контроль");

TaskManager taskManager = new TaskManager();
taskManager.addTask(task1);
taskManager.addTask(task2);
taskManager.addTask(task3);
taskManager.newStatus("Анализ проекта",TaskStatus.REVIEW);
taskManager.printTask();


Movie movie1 = new Movie("Погром",2009,MovieGenre.THRILLER);
Movie movie2 = new Movie("Няня",2003,MovieGenre.COMEDY);
Movie movie3 = new Movie("Смешарики",2015,MovieGenre.ANIMATION);

MovieManager movieManager = new MovieManager();
movieManager.addMovie(movie1);
movieManager.addMovie(movie2);
movieManager.addMovie(movie3);

movieManager.printMovies();
int result = movieManager.countMoviesByGenre(MovieGenre.ACTION);
       System.out.println("Количество фильмов с таким жанром: " + result);

       Student st1 = new Student("Alica","dsasdasd@mail.ru",StudentLevel.EXPERT);
       Student st2 = new Student("Ivan","uerueu@gicloud.com",StudentLevel.BEGINNER);
       Student st3 = new Student("Mila","okollok@gmail.ru",StudentLevel.ADVANCED);

       StudentManager studentManager = new StudentManager();
       studentManager.addStudent(st1);
       studentManager.addStudent(st2);
       studentManager.addStudent(st3);
       studentManager.studentNewsletter();
       studentManager.searchStudentGrades(StudentLevel.BEGINNER);

       DeliveryOrder deliveryOrder1 = new DeliveryOrder("City-1",119873);
       DeliveryOrder deliveryOrder2 = new DeliveryOrder("City-2",176889);
       DeliveryOrder deliveryOrder3 = new DeliveryOrder("City-3",786676);

       DeliveryManager deliveryManager = new DeliveryManager();
       deliveryManager.addOrder(deliveryOrder1);
       deliveryManager.addOrder(deliveryOrder2);
       deliveryManager.addOrder(deliveryOrder3);

       deliveryManager.printDeliveryOrder();
       deliveryManager.cancelOrder(119873);



       User user1 = new User("Daniil","77787",UserRole.USER);
       User user2 = new User("Oleg","90887",UserRole.MODERATOR);
       User user3 = new User("Misha", "76656", UserRole.ADMIN);

       UserManager userManager = new UserManager();
       userManager.addUser(user1);
       userManager.addUser(user2);
       userManager.addUser(user3);

       userManager.changeUserRole("Daniil",UserRole.GUEST);
       userManager.printAccessAudit();
   }
}
class Task{
    private String title;
    private String description;
    private TaskStatus status = TaskStatus.IN_PROGRESS;

    Task(String title, String description){
setTitle(title);
setDescription(description);
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        if (title !=null && !title.trim().isEmpty()){
            this.title = title;
        } else {
            System.out.println("Название не может быть пустое.");
        }
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        if (description != null && !description.trim().isEmpty()){
            this.description = description;
        } else {
            System.out.println("Описание не может быть пустое.");
        }
    }
    public TaskStatus getStatus(){
        return status;
    }
    public void setStatus(TaskStatus status){
        this.status = status;
    }
}
enum TaskStatus{
    TODO,IN_PROGRESS,REVIEW,DONE
}
class TaskManager{
    private ArrayList<Task> tasksArray = new ArrayList<>();

    public void addTask(Task task){
        tasksArray.add(task);

    }
    public void newStatus(String name, TaskStatus status){
        boolean isFound= false;
        for (Task t:tasksArray){
            if (name.equals(t.getTitle())){
                t.setStatus(status);
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("Совпадений не было найдено.");
        }
    }
    public void printTask(){
        for (Task t:tasksArray){
            switch (t.getStatus()){
                case DONE -> System.out.println(t.getTitle() +  " Задача выполнена.");
                case TODO -> System.out.println(t.getTitle() + " Нужно выполнить.");
                case IN_PROGRESS -> System.out.println(t.getTitle() + " В процессе выполнения.");
                case REVIEW -> System.out.println(t.getTitle() + " В процессе проверки.");
            }
        }
    }
}

class Movie{
    private String title;
    private int releaseYear;
    private MovieGenre movieGenre;


    Movie(String title, int releaseYear,MovieGenre movieGenre){
        setTitle(title);
        setReleaseYear(releaseYear);
        setMovieGenre(movieGenre);

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()){
            this.title = title;
        } else{
            System.out.println("Название не может быть пустым.");
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear >= 1895 && releaseYear <=2026){
            this.releaseYear = releaseYear;
        } else {
            System.out.println("Год выпуска указан некорректно.");
        }
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }
}
enum MovieGenre{
    ACTION, COMEDY, DRAMA, THRILLER, ANIMATION
}

class MovieManager{
    private ArrayList<Movie>  movieArray = new ArrayList<>();


    public void addMovie(Movie movie){
        movieArray.add(movie);
    }
    public int countMoviesByGenre(MovieGenre genre){
        int count = 0;
        for (Movie m: movieArray){
            if (m.getMovieGenre() == genre){
                count++;
            }
        }
        return count;
    }
    public void printMovies(){
        for (Movie m: movieArray){
            switch (m.getMovieGenre()){
                case DRAMA -> System.out.println(m.getTitle() + " - 14+");
                case COMEDY -> System.out.println(m.getTitle() + " - 12+");
                case THRILLER -> System.out.println(m.getTitle() + " - 18+");
                case ACTION -> System.out.println(m.getTitle() + " - 18+");
                case ANIMATION -> System.out.println(m.getTitle() + " - 6+");

            }
        }
    }
}
class Student{
    private String name;
    private String email;
    private StudentLevel studentLevel;

    Student(String name, String email, StudentLevel studentLevel){
        setName(name);
        setEmail(email);
        setStudentLevel(studentLevel);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
       if (name != null && !name.trim().isEmpty()){
           this.name = name;
       } else {
           System.out.println("Ошибка. 'Имя' не может быть пустым." );
       }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       if (email != null && !email.trim().isEmpty()){
           this.email = email;
       } else {
           System.out.println("Ошибка. 'email' не может быть пустым.");
       }
    }

    public StudentLevel getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(StudentLevel studentLevel) {
        this.studentLevel = studentLevel;
    }
}
enum StudentLevel{
    BEGINNER, INTERMEDIATE, ADVANCED, EXPERT
}
class StudentManager{
    private ArrayList<Student> arrayStudents = new ArrayList<>();

    public void addStudent(Student student){
        arrayStudents.add(student);
    }
    public void searchStudentGrades(StudentLevel studentLevel){
        for (Student s:arrayStudents){
            if (studentLevel == s.getStudentLevel()){
                System.out.println("Имена подходящих студентов " + s.getName());
            }
        }
    }
    public void studentNewsletter(){
        for (Student s: arrayStudents){
            switch (s.getStudentLevel()){
                case EXPERT -> System.out.println("Опытный эксперт. - Молодец, так держать.");
                case ADVANCED -> System.out.println("Передовой ученик. - Только вперед.");
                case BEGINNER -> System.out.println("Начинающий. - Есть к чему стремиться.");
                case INTERMEDIATE -> System.out.println("Средний. - Нужно подтягивать знания.");

            }
        }
    }
}
class DeliveryOrder{
    private int orderNumber;
    private String address;
    private OrderState orderState = OrderState.CREATED;

    DeliveryOrder(String address, int orderNumber){
        setAddress(address);
        setOrderNumber(orderNumber);

    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
       if (orderNumber > 0){
           this.orderNumber= orderNumber;
       } else {
           System.out.println("Номер заказа должен быть больше 0.");
       }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()){
            this.address = address;
        } else {
            System.out.println("Ошибка. Адрес должен быть указан обязательно.");
        }
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
enum OrderState{
    CREATED, PAID, SHIPPED, DELIVERED, CANCELLED
}
class DeliveryManager{
    private ArrayList<DeliveryOrder> arrayOrder = new ArrayList<>();


    public void addOrder(DeliveryOrder order){
        arrayOrder.add(order);
    }
    public void cancelOrder(int orderNumber){
        boolean isFound = false;
        for (DeliveryOrder d: arrayOrder){
            if (orderNumber == d.getOrderNumber()){
                d.setOrderState(OrderState.CANCELLED);
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("Заказ с таким номером не был найден.");
        }
    }
    public void printDeliveryOrder(){
        for (DeliveryOrder d:arrayOrder){
            switch (d.getOrderState()){
                case PAID :
                    System.out.println("Находится на складе.");
                    break;

                case CREATED:
                    System.out.println(d.getOrderNumber() + " - находится на складе.");
                    break;
                case SHIPPED:
                    System.out.println(d.getOrderNumber() + " - в пути к клиенту.");
                    break;
                case CANCELLED:
                    System.out.println(d.getOrderNumber() + " - возврат на склад");
                    break;
                case DELIVERED:
                    System.out.println(d.getOrderNumber() + " - оставлен. В пункте выдачи.");
                    break;
            }
        }
    }
}
class User{
    private String username;
    private String password;
    private UserRole role;

    User(String username, String password, UserRole role){
        setUsername(username);
        setPassword(password);
        setRole(role);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()){
            this.username = username;
        } else {
            System.out.println("Ошибка. Имя не может быть пустым или null.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >=6 && !password.trim().isEmpty()){
            this.password = password;
        } else{
            System.out.println("Ошибка. Пароль должен содержать минимум 6 символов.");
        }
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
enum UserRole{
    GUEST, USER, MODERATOR, ADMIN
}
class UserManager{
    private ArrayList<User> arrayUser = new ArrayList<>();

    public void addUser(User user){
        arrayUser.add(user);

    }
    public void changeUserRole(String name, UserRole role){
        boolean isFound = false;
        for (User u: arrayUser){
            if (name.equals(u.getUsername())){
                u.setRole(role);
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("Пользователь не найден.");
        }
    }
    public void printAccessAudit(){
        for (User u:arrayUser){
            switch (u.getRole()){
                case USER:
                    System.out.println(u.getUsername() + " - доступ с режимом чтения и с ограничениями выдан.");
                    break;
                case ADMIN:
                    System.out.println(u.getUsername() + " - полный доступ выдан.");
                    break;
                case GUEST:
                    System.out.println(u.getUsername() + " - доступ только для чтения выдан.");
                    break;
                case MODERATOR:
                    System.out.println(u.getUsername() + " - доступ с некоторыми ограничениями выдан.");
            }
        }
    }
}
