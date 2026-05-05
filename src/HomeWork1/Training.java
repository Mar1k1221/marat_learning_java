package HomeWork1;

public class Training {
    public static void main(String[] args) {
 int num= 22;
 Calculator calculator = new Calculator();
 calculator.twice(num);
        System.out.printf("num в методе мейне (после) : %d\n", num);

    }
    static class Calculator{
        void twice(int a){
            a = a + a;
            System.out.printf("a в методе twice: %d\n",a);
        }
    }
}
