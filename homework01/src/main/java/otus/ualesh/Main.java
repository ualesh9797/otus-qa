package otus.ualesh;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Что хочешь сделать?");
            String command = scanner.nextLine();
            switch (Commands.getByType(command)) {
                case ADD:
                    System.out.println("Какое животное?");
                    String animalType = scanner.nextLine();

                    System.out.println("Какое имя?");
                    String animalName = scanner.nextLine();

                    System.out.println("Какой возвраст?");
                    int animalAge = Integer.parseInt(scanner.nextLine());

                    System.out.println("Какой вес?");
                    int animalWeight = Integer.parseInt(scanner.nextLine());

                    System.out.println("Какой цвет?");
                    String animalColor = scanner.nextLine();


                    Animal animal;
                    switch (animalType) {
                        case "cat":
                            animal = new Cat(animalName, animalAge, animalWeight, animalColor);
                            break;
                        case "dog":
                            animal = new Dog(animalName, animalAge, animalWeight, animalColor);
                            break;
                        case "duck":
                            animal = new Duck(animalName, animalAge, animalWeight, animalColor);
                            break;
                        default:
                            System.out.println("Нет такого животного");
                            continue;
                    }
                    animal.say();
                    animals.add(animal);
                    break;
                case LIST:
                    System.out.println(animals);
                    break;
                case EXIT:
                    return;
            }
        }
    }
}
