package frogger;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Time;
import jplay.Window;

import java.awt.*;
import java.io.IOException;
import java.util.Vector;

import static frogger.Settings.*;

//TODO create a method to instantiate all lanes properly
public class Game {
    private int level;
    private Player player;
    private Scene scenario;
    private Ranking ranking;
    private Keyboard input;
    private Vector<Lane> lanes;
    private Time time_left;
    private boolean playing;

    public Game(Window window) throws IOException {
        ranking = new Ranking();
        input = window.getKeyboard();
        scenario = new Scene();
        scenario.loadFromFile(SCENARIO_FILE);
        lanes = new Vector<>();
        start_lanes();
        time_left = STARTING_TIME;
        level = FIRST_LEVEL;
        player = new Player(STARTING_POSITION_X, STARTING_POSITION_Y);
        playing = true;

        gameloop(window);
    }

    private void gameloop(Window window) throws IOException {
        while (playing) {
            scenario.draw();
            player.draw();
            player.move(input);
            draw_lanes();
            update_lanes();
            draw_hud(window);
            check_accident();

            if (player.reached_finishing_line()) {
                level++;
                time_left.setTime(0, 0, TIME_LIMIT);
                player.setScore(calculate_score());
                player.respawn();
            }

            if (game_over()) {
                playing = false;
                ranking.draw(window);
                window.update();
                while(!input.keyDown(Keyboard.ENTER_KEY));
            }
            window.update();
        }
    }

    private void update_lanes() {
        for (int i = 0; i < lanes.size(); i++) {
            lanes.get(i).update(time_left.getSecond());
        }
    }

    private void draw_lanes() {
        for (int i = 0; i< lanes.size(); i++){
            lanes.get(i).draw();
        }
    }

    private void start_lanes() {
        lanes.add(0, new Lane(LANE_1_Y, LANE_1_SPEED));
        lanes.add(1, new Lane(LANE_2_Y, LANE_2_SPEED));
        lanes.add(2, new Lane(LANE_3_Y, LANE_3_SPEED));
        lanes.add(3, new Lane(LANE_4_Y, LANE_4_SPEED));
        lanes.add(4, new Lane(LANE_5_Y, LANE_5_SPEED));
        lanes.add(5, new Lane(LANE_6_Y, LANE_6_SPEED));
        lanes.add(5, new Lane(LANE_7_Y, LANE_7_SPEED));
    }

    private int calculate_score() {
        return level + player.getScore();
    }

    private boolean game_over() throws IOException {
        if(player.getLives() == 0 || time_left.timeEnded()){
            NameInputWindow name_input = new NameInputWindow();
            String player_name = name_input.get_name();
            ranking.update(player_name,player.getScore());
            return true;
        }
        else
            return false;
    }

    private void draw_hud(Window window) {
        Font font = new Font("Arial", FONT_STYLE, FONT_SIZE);
        String HUD_text = "Level: " + level + "    " + time_left.toString() + "    Score: " + player.getScore() + "    Lives: " + player.getLives();
        window.drawText(HUD_text, FIRST_X, FIRST_Y, TEXT_COLOR, font);
    }

    public void check_accident(){
        Vector<Vehicle> vehicles;
        for(int j = 0; j < lanes.size(); j++) {
            vehicles = lanes.get(j).getVehicles();
            for (int i = 0; i < vehicles.size(); i++) {
                if (player.collided_with(vehicles.get(i))){
                    player.kill();
                }
            }
        }
    }

}
