package frogger;

import jplay.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

public class Game {
    private Player player = new Player(Settings.PLAYER_STARTING_POSITION_X, Settings.PLAYER_STARTING_POSITION_Y);
    private Scene scenario = new Scene();
    private boolean game_running = true;
    private Lane lane1 = new Lane(14*Settings.LINE_WIDTH);
    private Time time_left = new Time(0, 0, 30, Settings.FIRST_X, Settings.FIRST_Y, false);

    public Game(Window window){
        Keyboard input = window.getKeyboard();
        scenario.loadFromFile(Settings.SCENARIO_FILE);

        while(game_running){
            scenario.draw();
            player.draw();
            player.move(input);
            lane1.draw();
            lane1.update(time_left.getSecond());
            draw_hud(window);
            check_accident(player, lane1.getVehicles());

            if(input.keyDown(Keyboard.ENTER_KEY) || game_over()){
                game_running = false;
            }

            window.update();
        }
    }

    private boolean game_over() {
        if(player.getLives() == 0 || time_left.timeEnded()){
            return true;
        }
        else
            return false;
    }

    private void draw_hud(Window window) {
        Font font = new Font("Arial", Settings.FONT_STYLE, Settings.FONT_SIZE);
        String HUD_text = time_left.toString() + "  Score: " + player.getScore() + "   Lives: " + player.getLives();
        window.drawText(HUD_text, Settings.FIRST_X, Settings.FIRST_Y, Color.YELLOW, font);
    }

    public void check_accident(Player player, Vector<Vehicle> vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            if(player.collided_with(vehicles.get(i))){
                player.kill();
            }
        }
    }

}
