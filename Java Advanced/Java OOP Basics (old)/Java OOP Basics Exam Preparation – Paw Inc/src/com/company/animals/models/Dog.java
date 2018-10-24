package com.company.animals.models;

import com.company.animals.Animal;
import com.company.exceptions.InvalidAmountOfCommandsException;

public class Dog extends Animal {

    private int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.setAmountOfCommands(amountOfCommands);
    }

    public int getAmountOfCommands() {
        return amountOfCommands;
    }

    private void setAmountOfCommands(int specialSkill) {
        if (specialSkill < 0) {
            throw new InvalidAmountOfCommandsException();
        }
        this.amountOfCommands = amountOfCommands;
    }
}
