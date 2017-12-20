package frogger;

import jplay.*;

public class Main {

    public static void main(String[] args) {
        
            Window start_window = new Window(Settings.WINDOW_WIDTH, Settings.WINDOW_LENGTH);
            GameImage cover = new GameImage(Settings.COVER_IMAGE);
            Keyboard input = start_window.getKeyboard();

            boolean not_started = true;

            while(not_started){
                cover.draw();

                if(input.keyDown(Keyboard.ENTER_KEY)){
                    new Game(start_window);
                    not_started = false;
                }
                start_window.update();
            }
            start_window.exit();
        }

}