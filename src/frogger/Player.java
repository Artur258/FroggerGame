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
    private int frame_counter;

    public Player(int x, int y) {
        super(PLAYER_SPRITE, PLAYER_SPRITE_FRAMES);
        this.x = x;
        this.y = y;
        frame_counter = 0;
        lives = STARTING_LIVES;
        score = STARTING_SCORE;
        this.setTotalDuration(FRAME_DURATION);
    }

    public void move(Keyboard keyboard){
        if (keyboard.keyDown(Keyboard.LEFT_KEY))
        {

            if(x > WINDOW_LEFT_SIDE) {
                x -= PLAYER_SPEED;
                if(direction != LEFT){
                    setSequence(5, 7);
                    direction = LEFT;
                };
                isMoving = true;
            }
        }
        else if (keyboard.keyDown(Keyboard.RIGHT_KEY))
        {
            if(x < WINDOW_RIGHT_SIDE - EXTRA_PIXELS) {
                x += PLAYER_SPEED;
                if(direction != RIGHT){
                    setSequence(9, 11);
                    direction = RIGHT;
                };
                isMoving = true;
            }
        }
        else if (keyboard.keyDown(Keyboard.UP_KEY))
        {
            if( y > WINDOW_TOP) {
                y -= PLAYER_SPEED;
                if(direction != UP){
                    setSequence(12, 14);
                    direction = UP;
                };
                isMoving = true;
            }
        }

        else  if (keyboard.keyDown(Keyboard.DOWN_KEY))
        {
            if( y < WINDOW_BOTTOM - EXTRA_PIXELS) {
                y += PLAYER_SPEED;
                if(direction != DOWN){
                    setSequence(1, 3);
                    direction = DOWN;
                };
                isMoving = true;
            }
        }

        if(isMoving){
            update();
            frame_counter ++;
            if(frame_counter == FRAMEMS_PER_MOVING_SEQUENCE) {
                isMoving = false;
            }
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

/*
    public void draw(){
        super.draw();

        if(!isMoving && direction == LEFT){
            setSequence(7, 8);
        }
        if(!isMoving && direction == RIGHT){
            setSequence(11, 12);
        }
        if(!isMoving && direction == UP){
            setCurrFrame(14);
        }
        if(direction == DOWN){
            setSequence(0, 1);
        }
    }
*/

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

}