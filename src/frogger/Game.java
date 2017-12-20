package frogger;

import jplay.*;

public class Game {
    private Player player = new Player(Settings.PLAYER_STARTING_POSITION_X, Settings.PLAYER_STARTING_POSITION_Y);
    private Scene scenario = new Scene();
    private boolean game_running = true;

    public Game(Window window){
        Keyboard input = window.getKeyboard();
        scenario.loadFromFile(Settings.SCENARIO_FILE);

        while(game_running){
            scenario.draw();
            player.draw();
            player.move(input);

            if(input.keyDown(Keyboard.ENTER_KEY)){
                game_running = false;
            }

            window.update();
        }
    }

}
