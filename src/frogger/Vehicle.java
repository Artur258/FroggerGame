package frogger;

import jplay.Sprite;
import static frogger.Settings.*;

public class Vehicle extends Sprite {
    private double base_speed;

    public Vehicle(int x, int y, String sprite_file, double base_speed) {
        super(sprite_file);
        this.x = x;
        this.y = y;
        this.base_speed = base_speed;
    }

    public void move(){
        this.setX(this.x + base_speed*VEHICLE_SPEED);
    }
}