package frogger;

import static frogger.Settings.*;

public class Car extends Vehicle{
    public Car(int x, int y, double base_speed) {
        super(x, y, CAR_SPRITE, base_speed);
    }
}
