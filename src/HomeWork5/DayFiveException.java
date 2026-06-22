package HomeWork5;

public class DayFiveException {
    public static void main(String[] args) {
        OrderTerminal.confirmOrder(-1);
       OrderTerminal.processUserInput("9");
       OrderTerminal.processUserInput("семь");
    }
}

   class OrderTerminal{
    public static void confirmOrder(int quantity){
        if (quantity == 0 ){
            System.out.println("Вы не можете заказать 0 порций.");
            return;
        } else if (quantity < 0 ) {
            throw new IllegalArgumentException("Критическая ошибка: количество не может быть отрицательным! Передано: " + quantity);

        }
        System.out.println("Заказ успешно оформлен. Количество порций: " + quantity);
    }
    public static void processUserInput(String input){
        try{
    int count = Integer.parseInt(input);
            confirmOrder(count);
} catch (NumberFormatException e){
            System.out.println("Извините, терминал принимает только цифры. Вы ввели текст.");
        }
    }
}
