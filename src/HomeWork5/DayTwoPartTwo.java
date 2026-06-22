package HomeWork5;

import java.util.ArrayList;

public class DayTwoPartTwo {
    public static void main(String[] args) {
        System.out.println("---Начало первой задачи.---");

        ArrayList<Dish> arrayDish = new ArrayList<>();
        arrayDish.add(new Dish("Том ям"));
        arrayDish.add(new Soup("Уха", "на рыбном"));
        arrayDish.add(new Dessert("Профитроли",350));
        for (Dish d:arrayDish){
            d.prepare();
        }
        System.out.println();
        System.out.println("---Начало второй задачи.---");

        ArrayList <AutoItem> arrayAuto = new ArrayList<>();
        arrayAuto.add(new AutoItem("Колпачок тормозный колодок",70));
        arrayAuto.add(new CarMats("Коврики для автомобиля",50));
        arrayAuto.add(new DashCam("Видеорегистратор", 100,100));
        for (AutoItem a: arrayAuto){
            a.getInstallationGuide();
        }
        System.out.println();
        System.out.println("---Начало третьей задачи---");
        ArrayList<Reels> arrayReels = new ArrayList<>();
        arrayReels.add(new Reels(30));
        arrayReels.add(new AestheticReel(20,"Miyagi"));
        arrayReels.add(new SpeakingReel(60,"Хобби"));
        for (Reels r:arrayReels){
            r.play();
        }
        System.out.println();
        System.out.println("---Начало четвертой задачи---");
        ArrayList<Workout> arrayWorkout = new ArrayList<>();
        arrayWorkout.add(new Workout(90));
        arrayWorkout.add(new Cardio(30));
        arrayWorkout.add(new WeightLifting(60,17));
        for (Workout w: arrayWorkout){
            int result = w.calculateCalories();
            System.out.println("Количество сожженых каллорий за тренировку " + result);
        }


    }
}
class Dish{
    private String name;
    Dish(String name){
        setName(name);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void prepare(){
        System.out.println("Готовка на обычном бульоне.");
    }
}
class Soup extends Dish{
    private String boulilonType;
    Soup(String name, String boulillonType){
        super(name);
        this.boulilonType=boulillonType;
    }
    @Override
    public void prepare(){
        System.out.println("Готовка  " + boulilonType + " бульоне");
    }
}
class Dessert extends Dish{
    private int sugarGrams;
    Dessert(String name, int sugarGrams){
        super(name);
        this.sugarGrams=sugarGrams;
    }
    public int getSugarGrams(){
        return sugarGrams;
    }
    public void setSugarGrams(int sugarGrams){
        this.sugarGrams=sugarGrams;
    }
    @Override
    public void prepare(){
        System.out.println("Взбивания сливок и добавления сахара в размере " + sugarGrams + " грамм.");
    }
}

class AutoItem{
    private String title;
    private int price;
    AutoItem(String title,int price){
        this.title=title;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void getInstallationGuide(){
        System.out.println("Обычное руководство по установке аксессуаров");
    }
}
class CarMats extends AutoItem{

    CarMats(String title, int price){
        super(title,price);
    }
    @Override
    public void getInstallationGuide(){
        System.out.println("Установка строго в салон, предварительно убрать лишние элементы");
    }
}
class DashCam extends AutoItem{
    private int memoryCardSize;
    DashCam(String title,int price, int memoryCardSize){
        super(title,price);
        this.memoryCardSize=memoryCardSize;
    }
    public int getMemoryCardSize(){
        return memoryCardSize;
    }
    public void setMemoryCardSize(int memoryCardSize){
        this.memoryCardSize=memoryCardSize;
    }
    @Override
    public void getInstallationGuide(){
        System.out.println("Ознакомление с инструкцией по скрытой проводке кабеля");
    }

}
class Reels{
    private int duration;

    public Reels(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void play(){
        System.out.println("Проигрывание короткого видео");
    }
}
class SpeakingReel extends Reels{
    private String topic;

    public SpeakingReel(int duration, String topic) {
        super(duration);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    @Override
    public void play(){
        System.out.println("Разговорное видео на тему " + topic);
    }
}
class AestheticReel extends Reels{
    private String trackName;

    public AestheticReel(int duration, String trackName) {
        super(duration);
        this.trackName = trackName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
    @Override
    public void play(){
        System.out.println("Эстетическое видео сопровождающее музыкой на фоне под названием: " + trackName);
    }

}
class Workout{
    private int durationMinutes;

    public Workout(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int calculateCalories(){
        return durationMinutes;
    }
}
class Cardio extends Workout{
    public Cardio(int durationMinutes) {
        super(durationMinutes);
    }

    @Override
    public int calculateCalories() {
        return getDurationMinutes() * 10;
    }
}
class WeightLifting extends Workout{
    private int averageWeight;

    public WeightLifting(int durationMinutes, int averageWeight) {
        super(durationMinutes);
        this.averageWeight = averageWeight;
    }

    public int getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(int averageWeight) {
        this.averageWeight = averageWeight;
    }
    @Override
    public int calculateCalories(){
        return getDurationMinutes() * 5;
    }
}