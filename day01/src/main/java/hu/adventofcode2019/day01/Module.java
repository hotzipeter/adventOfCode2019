package hu.adventofcode2019.day01;

import lombok.Getter;

@Getter
public class Module {
    private final int mass;

    public Module(String massString) {
        this.mass = Integer.parseInt(massString);
    }

    public int getRequiredFuel() {
        return ((int) Math.floor((double) this.mass / 3)) - 2;
    }

    public static int getRequiredFuelByMass(int mass) {
        return ((int) Math.floor((double) mass / 3)) - 2;
    }

    public int getRequiredFuelWithFuelMass() {
        int sumFuel = 0;
        int accMass = getRequiredFuelByMass(mass);
        while (accMass>0) {
            sumFuel += accMass;
            accMass = getRequiredFuelByMass(accMass);
        }
        return sumFuel;
    }
}
