package frogger;

import java.util.Vector;

public class Lane {
    private int y_position;
    private Vector<Vehicle> vehicles;

    public Vector<Vehicle> getVehicles() {
        return vehicles;
    }

    public Lane(int y_position) {
        this.y_position = y_position;
        vehicles = new Vector<>();
    }

    public void draw(){
        for (int i = 0; i < vehicles.size(); i++){
            vehicles.get(i).draw();
        }
    }

    public void spawn_vehicles(int time) {
        if(time % Settings.VEHICLE_RESPAWN_TIME == 0){
            System.out.println(time);
            vehicles.add(new Car(Settings.FIRST_X, this.y_position));
        }
    }

    public void update(int time) {
        this.spawn_vehicles(time);
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).move();
        }
    }

}
