package frogger;

import jplay.*;

import java.io.IOException;

import static frogger.Settings.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
            Window start_window = new Window(WINDOW_WIDTH, WINDOW_LENGTH);
            GameImage cover = new GameImage(COVER_IMAGE);
            Keyboard input = start_window.getKeyboard();
            Sound menu_song = new Sound(FROG_SOUND);
            menu_song.play();
            menu_song.setRepeat(true);

            boolean game_running = true;

            while(game_running){
                cover.draw();

                if(input.keyDown(Keyboard.ENTER_KEY)){
                    menu_song.stop();
                    new Game(start_window);
                }
                start_window.update();
            }
            start_window.exit();
        }
}

