package frogger;

import jplay.*;

public class Main {

    public static void main(String[] args) {
        
            Window game_window = new Window(Settings.WINDOW_WIDTH, Settings.WINDOW_LENGTH);
            GameImage cover = new GameImage(Settings.COVER_IMAGE);
            Keyboard input = game_window.getKeyboard();
            boolean game_running = true;
            
            while(game_running){
                cover.draw();
                
                if(input.keyDown(Keyboard.ENTER_KEY)){
                    game_running = false;
                }
                        
                game_window.update();
            }
            game_window.exit();
        }

}