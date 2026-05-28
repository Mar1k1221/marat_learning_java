package HomeWork2;

public class DayFour {
    public static void main(String[] args) {
        int[] number = {10, 30, 43, 1, 10, 7, 5};
        String string = "Java      2026";
        String palindrome = "Топот";
        sumArray(number);
        maxArray(number);
        containsNumber(string);
        isPalindrome(palindrome);
        countWords(string);
    }

    static void printArray() {
        System.out.println("Привет, я изучаю Java!");
    }

    static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Сумма всех чисел в массиве:  " + sum);
        return sum;
    }

    static int maxArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Максимальное число в массиве: " + max);
        return max;
    }

    static boolean containsNumber(String string) {
        boolean hasDigit = false;
        for (int i = 0; i < string.length(); i++) {
            char currentSymbol = string.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                hasDigit = true;
                break;
            }
        }
        if (hasDigit) {
            System.out.println("В тексте есть цифры: " + hasDigit);
        } else {
            System.out.println("В тексте нет цифр: " + hasDigit);
        }
        return hasDigit;
    }


static boolean isPalindrome(String string) {
    boolean result = false;
    string = string.toLowerCase();
    String revers = "";
    for (int i = string.length() - 1; i >= 0; i--) {
        revers += string.charAt(i);
    }
    if (revers.equals(string)) {
        result = true;
        System.out.println("Слово " + string + " является палиндромом");
    } else {
        System.out.println("Слово " + string + " не является палиндром");
    }
    return result;

}

static int countWords(String string) {
    string = string.trim();
    if (string.isEmpty()) {
        return 0;
    }
    String[] arr = string.split("\\s+");
    System.out.println("Количество слов: " + arr.length);
    return arr.length;
}

}

