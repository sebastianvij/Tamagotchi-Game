package Tamagotchi;

import java.util.Random;

public class Dog extends Tamagotchi {
    public Dog(String name, int age, String gender, int mood, int energy) {
        super(name, age, gender, mood, energy);
    }

    @Override
    public void play() {
        Random random = new Random();

        int moodIncrease = random.nextInt(1, 4);
        increaseMood(moodIncrease);

        int energyUsed = random.nextInt(1, 4);
        decreaseEnergy(energyUsed);

        System.out.println("You played catch with " +getName()+ ", now it's energy when down by " +energyUsed+
                " and it's mood went up by " +moodIncrease);
    }

    @Override
    public void feed() {
        if (getEnergy() >= 9) {
            System.out.println(getName() + " isn't hungry right now.");
        } else {
            increaseEnergy(2);
            increaseMood(3);
            System.out.println(getName() + " has been fed. Energy is now " + getEnergy() + " and mood is now " +getMood());
        }
    }

    @Override
    public void sleep() {
       increaseEnergy(4);
    }
}
