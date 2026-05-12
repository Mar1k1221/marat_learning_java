package HomeWork1;

public class DayFive {
    public static void main(String[] args) {
        Method method = new Method();
        method.printGreeting();
        System.out.println(method.isEven(12));
        System.out.println(method.maxOfTwo(5, 9));
        double tempToday = 21.1;
        double tempTodayF = method.celsiusToFahrenheit(tempToday);
        int totalSum = method.sumRange(1, 5);
        System.out.println("Сумма чисел от 1 до 5: " + totalSum);
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

        public int sumRange(int start, int end) {
            int sum = 0;


            for (int i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }
    }
}


