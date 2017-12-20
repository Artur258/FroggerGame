package frogger;

import java.util.Random;
import java.util.Vector;

public class Lane {
    private int y_position;
    private Vector<Vehicle> vehicles;
    private int lastSecond;


    public Lane(int y_position) {
        this.y_position = y_position;
        vehicles = new Vector<>();
    }

    public Vector<Vehicle> getVehicles() {
        return vehicles;
    }
    
    public void draw(){
        for (int i = 0; i < vehicles.size(); i++){
            vehicles.get(i).draw();
        }
    }

    public void spawn_vehicles(int time) {
        int random = new Random().nextInt() % Settings.VEHICLE_MAX_SPAWN_RATE;
        if(time % Settings.VEHICLE_RESPAWN_TIME == 0){
            if(random <= Settings.CAR_SPAWN_RANGE) {
                vehicles.add(new Car(Settings.SPAWN_X_POSTION, this.y_position));
            }
            else if (random <= Settings.MOTORCYLCE_SPAWN_RANGE){
                vehicles.add(new Motorcycle(Settings.SPAWN_X_POSTION, this.y_position));
            }
            else if (random <= Settings.TRUCK_SPAWN_RANGE){
                vehicles.add(new Truck(Settings.SPAWN_X_POSTION, this.y_position));
            }
        }
    }

    public void update(int currentSecond) {
        if (lastSecond != currentSecond) {
            this.spawn_vehicles(currentSecond);
        }

        this.lastSecond = currentSecond;
        
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).move();
        }
    }

}
