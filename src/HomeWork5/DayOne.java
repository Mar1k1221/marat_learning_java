package HomeWork5;

public class DayOne {
    public static void main(String[] args) {
Animal animal = new Animal(true,"Тигр",5);
Cat cat = new Cat(true,"Барсик",9,false);
Dog dog = new Dog(true,"Чарльз",7,"Немецкая овчарка");
animal.makeSound();
cat.makeSound();
dog.makeSound();
    }
}
class Animal{
    private boolean isPredatory;
    private String speciesName;
    private int animalAge;

    public Animal(boolean isPredatory, String speciesName, int animalAge) {
        this.isPredatory = isPredatory;
        this.speciesName = speciesName;
        this.animalAge = animalAge;
    }

    public boolean isPredatory() {
        return isPredatory;
    }

    public void setPredatory(boolean predatory) {
        isPredatory = predatory;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }
    public void makeSound(){
        System.out.println("Животное издает звук.");
    }
}
class Cat extends Animal{
    private boolean isWild;

    Cat(boolean isPredatory, String speciesName,int animalAge,boolean isWild){
        super(isPredatory, speciesName, animalAge);
        this.isWild = isWild;
    }
    public boolean IsWild(){
        return isWild;
    }
    public void setWild(boolean isWild){
        this.isWild = isWild;


    }
    public void makeSound(){
        System.out.println("-Мяу-");
    }
}
class Dog extends Animal{
    private String breed;
    Dog(boolean isPredatory, String speciesName,int ageAnimal, String breed){
        super(isPredatory,speciesName,ageAnimal);
        this.breed = breed;
    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    public void makeSound(){
        System.out.println("-Гав-Гав-");
    }
}

