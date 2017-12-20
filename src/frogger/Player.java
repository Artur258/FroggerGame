package frogger;

import jplay.Collision;
import jplay.GameObject;
import jplay.Keyboard;
import jplay.Sprite;
import static frogger.Direction.*;
import static frogger.Settings.*;

//TODO adjust the frame transition
public class Player extends Sprite {

    private Direction direction;
    private int lives;
    private int score;
    private boolean isMoving;

    public Player(int x, int y) {
        super(PLAYER_SPRITE, PLAYER_SPRITE_FRAMES);
        this.x = x;
        this.y = y;
        lives = STARTING_LIVES;
        score = STARTING_SCORE;
        this.setTotalDuration(FRAME_DURATION);
    }

    public void move(Keyboard keyboard){
        if (keyboard.keyDown(Keyboard.LEFT_KEY))
        {
            this.setX(this.x - PLAYER_SPEED);
            this.setSequence(2,3);
            this.direction = LEFT;
            isMoving = true;
        }
        else if (keyboard.keyDown(Keyboard.RIGHT_KEY))
        {
            this.setX(this.getX() + PLAYER_SPEED);
            this.setSequence(4,5);
            this.direction=RIGHT;

            isMoving = true;
        }
        else if (keyboard.keyDown(Keyboard.UP_KEY))
        {
            this.setY(this.getY()- PLAYER_SPEED);;
            this.setSequence(6,7);
            this.direction=UP;
            isMoving = true;
        }

        else  if (keyboard.keyDown(Keyboard.DOWN_KEY))
        {
            this.setY(this.getY() + PLAYER_SPEED);;
            this.setSequence(0,1);
            this.direction=DOWN;
            isMoving = true;
        }

        if(isMoving){
            update();
            isMoving = false;
        }
    }

    public void kill(){
        lives --;
        respawn();
    }

    public boolean reached_finishing_line(){
        if(this.y < FINISHING_LINE){
            return true;
        }
        else
            return false;
    }

    public void respawn() {
        x = STARTING_POSITION_X;
        y = STARTING_POSITION_Y;
    }

    public boolean collided_with(GameObject object){
        return Collision.collided(this, object);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
