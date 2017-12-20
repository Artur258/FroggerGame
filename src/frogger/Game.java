package frogger;

import jplay.*;

import java.util.Vector;

public class Game {
    private Player player = new Player(Settings.PLAYER_STARTING_POSITION_X, Settings.PLAYER_STARTING_POSITION_Y);
    private Scene scenario = new Scene();
    private boolean game_running = true;
    private Lane lane1 = new Lane(14*Settings.LINE_WIDTH);
    private Time time_left = new Time(0, 0, 30, Settings.LINE_WIDTH, Settings.COLUMN_WIDTH, false);

    public Game(Window window){
        Keyboard input = window.getKeyboard();
        scenario.loadFromFile(Settings.SCENARIO_FILE);

        while(game_running){
            scenario.draw();
            player.draw();
            player.move(input);
            lane1.draw();
            lane1.update(time_left.getSecond());
            time_left.draw("Time left: ");
            check_accident(player, lane1.getVehicles());

            if(input.keyDown(Keyboard.ENTER_KEY) || player.isDead()){
                game_running = false;
            }

            window.update();
        }
    }

    public void check_accident(Player player, Vector<Vehicle> vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            if(player.collided_with(vehicles.get(i))){
                player.kill();
            }
        }
    }

}
