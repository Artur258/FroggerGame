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
            if(x > WINDOW_LEFT_BOUNDARY) {
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
            if(x < WINDOW_RIGHT_BOUNDARY) {
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
            if( y > WINDOW_UPPER_BOUNDARY) {
                y -= PLAYER_SPEED;
                if(direction != UP){
                    setSequence(13, 15);
                    direction = UP;
                };
                isMoving = true;
            }
        }

        else  if (keyboard.keyDown(Keyboard.DOWN_KEY))
        {
            if( y < WINDOW_LOWER_BOUNDARY) {
                y += PLAYER_SPEED;
                if(direction != DOWN){
                    setSequence(1, 4);
                    direction = DOWN;
                };
                isMoving = true;
            }
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

    /*
    public void draw(){
        super.draw();

        if(!isMoving && direction == LEFT){
            setSequence(10, 12);
        }
        if(!isMoving && direction == RIGHT){
            setSequence(12, 14);
        }
        if(!isMoving && direction == UP){
            setSequence(8, 9);
        }
        if(direction == DOWN){
            setSequence(8, 10);
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

    public void setLives(int lives) {
        this.lives = lives;
    }
}
