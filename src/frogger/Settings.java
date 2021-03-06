package frogger;

import jplay.Time;
import java.awt.*;

public final class Settings {

    //GENERAL GAMEPLAY
    public static final Time STARTING_TIME = new Time(0, 0, 30, Settings.FIRST_X, Settings.FIRST_Y, false);
    public static final int TIME_LIMIT = 30;
    public static final int STARTING_SCORE = 0;
    public static final int STARTING_LIVES = 3;
    public final static int STARTING_POSITION_X = 400;
    public final static int STARTING_POSITION_Y = 445;
    public final static double PLAYER_SPEED = 32;
    public final static double SPEED_INCREMENT_PER_LEVEL = 0.3;
    public static final int FIRST_LEVEL = 1;
    public static final int POINTS_PER_LEVEL = 100;
    public static final int POINTS_PER_SECOND_LEFT = 4;
    public final static String COVER_IMAGE = "cover2.jpg";
    //VEHICLES'S - Gameplay
    public static final int VEHICLE_RESPAWN_TIME = 5;
    public static final double VEHICLE_SPEED = 0.2;
    public static final int VEHICLE_SPAWN_SPLITTER = 1;
    public static final int VEHICLE_SPAWN_RATE = 6;

    //VEHICLE'S - Technical
    public static final int VEHICLE_MAX_SPAWN_RATE = 100;
    public static final int CAR_SPAWN_RANGE = 50;
    public static final int MOTORCYLCE_SPAWN_RANGE = 80;
    public static final int TRUCK_SPAWN_RANGE = 100;
    public static final int SPAWN_X_POSTION = -64;

    //LANE'S
    public static final int LANE_1_Y = 96;
    public static final int LANE_2_Y = 128;
    public static final int LANE_3_Y = 160;
    public static final int LANE_4_Y = 192;
    public static final int LANE_5_Y = 288;
    public static final int LANE_6_Y = 320;
    public static final int LANE_7_Y = 344;
    public static final int LANE_8_Y = 376;
    public static final double LANE_1_SPEED = 1;
    public static final double LANE_2_SPEED = 1.3;
    public static final double LANE_3_SPEED = 1.8;
    public static final double LANE_4_SPEED = 2.1;
    public static final double LANE_5_SPEED = 2.4;
    public static final double LANE_6_SPEED = 2.7;
    public static final double LANE_7_SPEED = 3.0;
    public static final double LANE_8_SPEED = 3.3;

    public static final int NUMBER_OF_LANES = 7;

    //SPRITES
    public final static int PLAYER_SPRITE_FRAMES = 15;
    public final static String PLAYER_SPRITE = "frog.png";
    public static final String CAR_SPRITE = "car.png";
    public static final String MOTORCYLCE_SPRITE = "motorcycle.png";
    public static final String TRUCK_SPRITE = "truck.png";

    //ANIMATION
    public final static int FRAMEMS_PER_MOVING_SEQUENCE = 3;
    public final static int FRAMEMS_PER_STATIC_SEQUENCE = 2;

    //WINDOW'S
    public final static int WINDOW_WIDTH = 960;
    public final static int WINDOW_LENGTH = 480;
    public final static int WINDOW_TOP = 0;
    public final static int WINDOW_BOTTOM = 480;
    public final static int WINDOW_LEFT_SIDE = 0;
    public final static int WINDOW_RIGHT_SIDE = 960;
    public final static int EXTRA_PIXELS = 30;
    public static final int LINE_WIDTH = 32;
    public static final int COLUMN_WIDTH = 32;

    //TEXT'S
    public static final int FONT_SIZE = 32;
    public static final int FONT_STYLE = 1;
    public static final Color TEXT_COLOR = Color.WHITE;

    //RANKING'S
    public static final int RANKINGS_TOP_SCORES = 5;
    public static final String RANKINGS_FILE = "rankings.txt";
    public static final String RANKINGS_BACKGROUND_FILE = "rankings_background.png";

    //SOUNDS
    public static final String MENU_SONG = "menu_theme.wav";
    public static final String FROG_SOUND = "frog_sound.wav";
    public static final String LEVEL_UP_SOUND = "level_up_sound.wav";
    public static final String GAME_SONG = "game_song.wav";

    //MISC
    public static final int FIRST_Y = 32;
    public static final int FIRST_X = 32;
    public static final int MIDDLE_DRAW_X = 360;
    public static final int FINISHING_LINE = 48;
    public final static String SCENARIO_FILE = "scenario/scenario1.scn";
    public static final long FRAME_DURATION = 2000;
    public static final int TILE = 32;
    public static final int CHANGE_UP = 0;
    public static final int CHANGE_DOWN = 1;
    public static final int MAX_CHANCE = 100;
    public static final int CHANCE = 25;


}