package frogger;

import jplay.Sprite;

public class Vehicle extends Sprite {
    public Vehicle(int x, int y, String sprite_file) {
        super(sprite_file);
        this.x = x;
        this.y = y;
    }

    public void move(){
        this.setX(this.x + Settings.VEHICLE_SPEED);
    }
}