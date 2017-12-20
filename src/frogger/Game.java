package frogger;

import jplay.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Vector;
import static frogger.Settings.*;

//TODO create a main menu functionality in order to test the sorting of the ranking
//TODO create a method to instantiate all lanes properly
public class Game {
    private int level;
    private Player player;
    private Scene scenario;
    private Ranking ranking;
    private Keyboard input;
    private Lane lane1;
    private Time time_left = STARTING_TIME;
    private boolean playing;

    public Game(Window window) throws IOException {
        ranking = new Ranking();
        input = window.getKeyboard();
        scenario = new Scene();
        scenario.loadFromFile(SCENARIO_FILE);
        level = FIRST_LEVEL;
        player = new Player(PLAYER_STARTING_POSITION_X, PLAYER_STARTING_POSITION_Y);
        lane1 = new Lane(14*LINE_WIDTH);
        playing = true;

        gameloop(window);
    }

    private void gameloop(Window window) throws IOException {

        while (playing) {
            scenario.draw();
            player.draw();
            player.move(input);
            lane1.draw();
            lane1.update(time_left.getSecond());
            draw_hud(window);
            check_accident(player, lane1.getVehicles());

            if (player.reached_finishing_line()) {
                level++;
                time_left = STARTING_TIME;
                player.setScore(calculate_score());
                player.respawn();
            }

            if (input.keyDown(Keyboard.ENTER_KEY) || game_over()) {
                playing = false;
                ranking.draw(window);
                window.update();
                while(!input.keyDown(Keyboard.ENTER_KEY));
            }
            window.update();
        }

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
        String HUD_text = "Level: " + level + "  " + time_left.toString() + "  Score: " + player.getScore() + "   Lives: " + player.getLives();
        window.drawText(HUD_text, FIRST_X, FIRST_Y, Color.YELLOW, font);
    }

    public void check_accident(Player player, Vector<Vehicle> vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            if(player.collided_with(vehicles.get(i))){
                player.kill();
            }
        }
    }

}
