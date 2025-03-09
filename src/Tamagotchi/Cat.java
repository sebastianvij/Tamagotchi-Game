package Tamagotchi;

import java.util.Random;

public class Cat extends Tamagotchi {
    public Cat(String name, int age, String gender, int mood, int energy) {
        super(name, age, gender, mood, energy);
    }

    @Override
    public void play() {
        Random random = new Random();

        if ((getMood() < 7)  || ((getEnergy() <= 5))) {
            System.out.println(getName() + " doesn't want to play");
            return;
        }

        int moodIncrease = random.nextInt(1, 3);
        if (this.getMood() + moodIncrease > 10) {
            this.setMood(10);
        } else {
            this.setMood(this.getMood() + moodIncrease);
        }

        int energyUsed = random.nextInt(1, 3);
        setEnergy(getEnergy() - energyUsed);
        System.out.println("You threw a mouse toy for " + getName() + " to hunt, now it's energy went down by " +energyUsed+
                " and it's mood went up by " + moodIncrease);
    }

    @Override
    public void feed() {
            setEnergy(getEnergy() + 2);
            setMood(getMood() + 1);
            System.out.println(getName() + " has been fed. Energy is now " + getEnergy() + " and mood is now " +getMood());
    }

    @Override
    public void sleep() {
        if (getEnergy() >= 8) {
            System.out.println(getName() + " doesn't want to sleep >:(");
        }
    }
}