package HomeWork1;

public class DayFive {
    public static void main(String[] args) {
        Method method = new Method();
        method.printGreeting();
        System.out.println(method.isEven(12));
        System.out.println(method.maxOfTwo(5, 9));
        double tempToday = 21.1;
        double tempTodayF = method.celsiusToFahrenheit(tempToday);
        System.out.println("градусов цельсия " + tempToday + " градусов фаренгейта " + tempTodayF);


    }

    static class Method {

        public void printGreeting() {
            System.out.println("Привет! Я изучаю Java!");
        }

        public static int maxOfTwo(int a, int b) {
            if (a > b) {
                return a;
            } else {
                return b;
            }


        }

        public static boolean isEven(int number) {
            return number % 2 == 0;
        }

        public double celsiusToFahrenheit(double celsius) {
            double fahrenheit = (celsius * 1.8) + 32;
            return fahrenheit;
        }
    }
}


