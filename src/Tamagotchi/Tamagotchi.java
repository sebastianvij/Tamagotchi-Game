package Tamagotchi;

import java.util.Random;

public class Tamagotchi {
    private String name;
    private int age;
    private String gender;
    private int mood;
    private int energy;

    public Tamagotchi(String name, int age, String gender, int mood, int energy) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mood = mood;
        this.energy = energy;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = Math.min(Math.max(mood, 0), 10);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.min(Math.max(energy, 0), 10);
    }

    public void increaseMood(int amount) {
        setMood(getMood() + amount);
    }
    public void increaseEnergy(int amount) {
        setEnergy(getEnergy() + amount);
    }

    public void decreaseEnergy(int amount) {
        setEnergy(getEnergy() - amount);
    }

    public void play() {
        Random random = new Random();

        if ((getMood() < 6)  || ((getEnergy() <= 5))) {
            System.out.println(getName() + " doesn't want to play");
            return;
        }

        int moodIncrease = random.nextInt(1, 4);
        increaseMood(moodIncrease);

        int energyUsed = random.nextInt(1, 4);
        decreaseEnergy(energyUsed);
    }

    public void feed() {
        if (getEnergy() > 6) {
            System.out.println(getName() + " isn't hungry right now.");
        }

        increaseMood(2);
        increaseEnergy(3);
    }

    public void sleep() {
        if (getEnergy() >= 6) {
            System.out.println(getName() + " doesn't want to sleep >:(");
        }

        increaseMood(4);
        increaseEnergy(3);

        System.out.println("ZZZzz");
        System.out.println(getName() + " has slept. Energy is now " + getEnergy() + " and mood is now " +getMood());
    }
}
