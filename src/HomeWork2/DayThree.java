package HomeWork2;

public class DayThree {
    public static void main(String[] args) {
equalsSales();
splitString();
halfLine();
splitLine();
upperString();
booleanString();
initialsString();
        }
        static void equalsSales() { /// 1
            String promocode = "SALE2026";
            String invPromocode = " sALe2026 ";
            invPromocode = invPromocode.trim().toUpperCase();
            if (promocode.equals(invPromocode)) {
                System.out.println("Промокод применен!");
            } else {
                System.out.println("Промокод не сработал, попробуйте ввести снова");
            }


        } static void splitString(){ /// 2
        String email = "marat.java@gmail.com";
        String [] str = email.split("@");
        System.out.println(str[1]);

    } static void halfLine(){ /// 3
        String string = "Программист";
        int num = string.length() / 2;
        System.out.println(string.substring(0,num));
    } static void splitLine(){ /// 4
        String string = "Java,Git,SQL,Spring,HTML";
        String [] separate = string.split(",");
//        for (String s: separate){
//            System.out.println(s);
//        }
        System.out.println(separate.length);
    } static void upperString(){ /// 5
        String string = "джава";
        string = string.toUpperCase();

        for (int i = 0; i < string.length(); i++){
            System.out.println(string.charAt(i));
        }
    } static void booleanString () { /// 6
        String password = "Marat_123";
        boolean correctPassword = true;
       for (int i = 0; i < password.length();i++){
           if (password.charAt(i) == ' '){
              correctPassword=false;
              break;
           }
           }  if (correctPassword == true){
               System.out.println("Пробел не был найден");
           } else {
               System.out.println("Пробел был найден!");
           }

        } static void initialsString(){ /// 7
        String str = "марат морозов";
        String [] strings = str.split(" ");
        for (String s:strings){
            System.out.println(s);
        } char name = strings[0].charAt(0);
          char surname = strings[1].charAt(0);
        String init = name + "." + surname ;
        String upper = init.toUpperCase();
        System.out.println(upper);
    }


        }





