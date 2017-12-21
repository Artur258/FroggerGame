package frogger;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import static frogger.Settings.*;

public class Lane {
    private int y_position;
    private ArrayList<Vehicle> vehicles;
    private int lastSecond;
    private double speed;


    public Lane(int y_position, double speed) {
        this.y_position = y_position;
        this.speed = speed;
        vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    
    public void draw(){
        for (int i = 0; i < vehicles.size(); i++){
            vehicles.get(i).draw();
        }
    }

    public void spawn_vehicles(int time) {
        int random = new Random().nextInt() % VEHICLE_MAX_SPAWN_RATE;
        if( (time % VEHICLE_RESPAWN_TIME == 0 && random % 2 == 0) || random % 3 == 0){
            if(random <= CAR_SPAWN_RANGE) {
                vehicles.add(new Car(SPAWN_X_POSTION, this.y_position, this.speed));
            }
            else if (random <= MOTORCYLCE_SPAWN_RANGE){
                vehicles.add(new Motorcycle(SPAWN_X_POSTION, this.y_position, this.speed));
            }
            else if (random <= TRUCK_SPAWN_RANGE){
                vehicles.add(new Truck(SPAWN_X_POSTION, this.y_position, this.speed));
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

    public void changeLane(Lane lane) {
        Random randChance = new Random();
        double chance;

        for(int i = 0; i < vehicles.size(); i++) {
            chance = randChance.nextInt(MAX_CHANCE);
            if (chance <= CHANCE && vehicles.get(i).canChangeLane(lane)) {
                lane.pushVehicle(vehicles.get(i));
                this.popVehicle(i);
                return ;
            }
        }
    }

    public void popVehicle(int i) {
        vehicles.remove(i);
    }

    public void pushVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setY(y_position);
        vehicle.setBase_speed(speed);
    }

    public int getY_position() {
        return y_position;
    }

    public void increase_speed(int level) {
        speed += level*SPEED_INCREMENT_PER_LEVEL;
    }
}
