package frogger;

import jplay.*;

import java.io.IOException;

import static frogger.Settings.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
            Window start_window = new Window(WINDOW_WIDTH, WINDOW_LENGTH);
            GameImage cover = new GameImage(COVER_IMAGE);
            Keyboard input = start_window.getKeyboard();

            boolean game_running = true;

            while(game_running){
                cover.draw();

                if(input.keyDown(Keyboard.ENTER_KEY)){
                    new Game(start_window);
                }
                start_window.update();
            }
            start_window.exit();
        }
}