package frogger;

import jplay.Collision;
import jplay.GameObject;
import jplay.Sprite;

import java.util.ArrayList;
import java.util.Random;

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

    public boolean canChangeLane(Lane lane) {
        double currentY = this.getY();
        this.setY(lane.getY_position());
        for(int i = 0; i < lane.getVehicles().size(); i++) {
            if (collided_with(lane.getVehicles().get(i))) {
                this.setY(currentY);
                return false;
            }
        }
        this.setY(currentY);
        return true;
    }

    public void setBase_speed(double base_speed) {
        this.base_speed = base_speed;
    }

    public boolean collided_with(GameObject object){
        return Collision.collided(this, object);
    }
}