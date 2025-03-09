package Tamagotchi;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to Tamagotchi World.");
        Thread.sleep(2000);
        System.out.println("Would you like to create a dog or a cat? Press '1' for dog or '2' for cat");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("1")) {
                adoptTamagotchi("Dog", scanner);
                break;
            } else if (input.equals("2")) {
                adoptTamagotchi("Cat", scanner);
                break;
            } else {
                System.out.println("Invalid input! Please type '1' or '2'.");
            }
        }
    }

    public static void adoptTamagotchi(String petType, Scanner scanner) throws InterruptedException {
        Random random = new Random();
        System.out.println("You have chosen to adopt a " + petType + "!");
        Thread.sleep(1500);

        int age = random.nextInt(1, 5);

        int gender = random.nextInt(1, 3);
        String genderString;
        if (gender == 1) {
            genderString = "male";
        } else {
            genderString = "female";
        }
        int mood = random.nextInt(5, 11);
        int energy = random.nextInt(5, 11);

        System.out.println("Your pet is a " + genderString + " " + petType.toLowerCase() + " aged " + age + ".");
        Thread.sleep(1500);

        String tamagotchiName;
        while(true) {
            System.out.println("What would you like your " + petType.toLowerCase() + "'s name to be?");
            tamagotchiName = scanner.nextLine();

            if (isValidName(tamagotchiName)) {
                System.out.println(tamagotchiName + " is a great name for a " + petType.toLowerCase() + "!");
                break;
            } else {
                System.out.println("Invalid name! Please only use letters.");
            }
        }

        Thread.sleep(1500);
        System.out.println("Initial mood is: " + mood + ", initial energy is: " + energy);
        Thread.sleep(1500);

        Tamagotchi tamagotchi = null;

        if (petType.equalsIgnoreCase("Dog")) {
            tamagotchi = new Dog(tamagotchiName, age, genderString, mood, energy);
        } else if (petType.equalsIgnoreCase("Cat")) {
            tamagotchi = new Cat(tamagotchiName, age, genderString, mood, energy);
        } else {
            System.out.println("Invalid pet type!");
        }

        if (tamagotchi != null) {
            interactWithTamagotchi(tamagotchi, scanner);
        }
    }

    public static void interactWithTamagotchi(Tamagotchi tamagotchi, Scanner scanner) {
        while(true) {
            System.out.println("What would you like to do with " + tamagotchi.getName() + "?");
            System.out.println("1 - Play");
            System.out.println("2 - Feed");
            System.out.println("3 - Sleep");
            System.out.println("4 - Check Status");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    tamagotchi.play();
                    break;
                case "2":
                    tamagotchi.feed();
                    break;
                case "3":
                    tamagotchi.sleep();
                    break;
                case "4":
                    displayTamagotchiHealth(tamagotchi);
                    break;

                default:
                    System.out.println("Invalid input! Please type '1', '2', '3' or '4'. ");
            }
        }
    }

    public static void displayTamagotchiHealth(Tamagotchi tamagotchi) {
        System.out.println(tamagotchi.getName() + "'s info:");
        System.out.println("Gender: " + tamagotchi.getGender());
        System.out.println("Age: " + tamagotchi.getAge());
        System.out.println("Energy: " + tamagotchi.getEnergy());
        System.out.println("Mood: " + tamagotchi.getMood());
    }

    public static boolean isCharLetter(char ch) {
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
    }
    public static boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            boolean isValidChar = isCharLetter(currentChar);
            if (!isValidChar) {
                return false;
            }
        }
        return true;
    }
}