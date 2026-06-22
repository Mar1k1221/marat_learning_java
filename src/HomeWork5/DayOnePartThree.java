package HomeWork5;

public class DayOnePartThree {
   public  static void main(String[] args) {
User user = new User("hhhh","mmmm@mail.ru");
Admin admin = new Admin("gggg","ssss.ru",4);
Client client = new Client("aaa","sdfsdf@mail.ru",300.3);

user.displayRole();
admin.displayRole();
client.displayRole();
    }
}
class User{
    private String login;
    private String email;
    User(String login, String email){
        this.login=login;
        this.email=email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayRole(){
        System.out.println("Обычный пользователь.");
    }
}
class Admin extends User{
    private int accessLevel;
    Admin(String login, String email, int accessLevel){
        super(login,email);
        this.accessLevel=accessLevel;

    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    public void displayRole(){
        System.out.println("Вход администратора, уровень доступа " + accessLevel);
    }
}
class Client extends User{
    private double walletBalance;
    Client(String login,String email, double walletBalance){
        super(login,email);
        this.walletBalance=walletBalance;

    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }
    @Override
    public void displayRole(){
        System.out.println("Постоянный клиент.");
    }
}