package frogger;

import jplay.Collision;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Sprite;
import static frogger.Direction.*;

public class Player extends Sprite {

    private Direction direction;
    private int lives = Settings.PLAYER_STARTING_LIVES;
    private int score = Settings.PLAYER_STARTING_SCORE;
    private boolean isMoving;
    private boolean isAlive;

    public Player(int x, int y) {
        super(Settings.PLAYER_SPRITE, Settings.PLAYER_SPRITE_FRAMES);
        this.isAlive = true;
        this.x = x;
        this.y = y;
        this.setTotalDuration(Settings.FRAME_DURATION);
    }

    public void move(Keyboard keyboard){
        if (keyboard.keyDown(Keyboard.LEFT_KEY))
        {
            this.setX(this.x - Settings.PLAYER_HORIZONTAL_SPEED);
            this.setSequence(2,3);
            this.direction = LEFT;
            isMoving = true;
        }
        else if (keyboard.keyDown(Keyboard.RIGHT_KEY))
        {
            this.setX(this.getX() + Settings.PLAYER_HORIZONTAL_SPEED);
            this.setSequence(4,5);
            this.direction=RIGHT;

            isMoving = true;
        }
        else if (keyboard.keyDown(Keyboard.UP_KEY))
        {
            this.setY(this.getY()- Settings.PLAYER_VERTICAL_SPEED);;
            this.setSequence(6,7);
            this.direction=UP;
            isMoving = true;
        }

        else  if (keyboard.keyDown(Keyboard.DOWN_KEY))
        {
            this.setY(this.getY() + Settings.PLAYER_VERTICAL_SPEED);;
            this.setSequence(0,1);
            this.direction=DOWN;
            isMoving = true;
        }

        if(isMoving){
            update();
            isMoving = false;
        }
    }

    public boolean isDead(){
        if(this.isAlive == false){
            return true;
        }
        else
            return false;
    }

    public void kill(){
        this.isAlive = false;
    }
    public boolean collided_with(GameObject object){
        return Collision.collided(this, object);
    }
}
