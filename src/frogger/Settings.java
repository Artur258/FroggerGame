package frogger;


import jplay.Time;
import java.awt.*;

//TODO create constants for the lines and refactor this shit cause it is ugly
public final class Settings {

    //GENERAL GAMEPLAY
    public static final Time STARTING_TIME = new Time(0, 0, 30, Settings.FIRST_X, Settings.FIRST_Y, false);
    public static final int TIME_LIMIT = 30;
    public static final int STARTING_SCORE = 0;
    public static final int STARTING_LIVES = 3;
    public final static int STARTING_POSITION_X = 400;
    public final static int STARTING_POSITION_Y = 400;
    public final static double PLAYER_SPEED = 10;
    public static final int FIRST_LEVEL = 0;
    public final static String COVER_IMAGE = "cover2.jpg";
    //VEHICLES'S - Gameplay
    public static final int VEHICLE_RESPAWN_TIME = 3;
    public static final double VEHICLE_SPEED = 0.3;

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
    public static final int LANE_5_Y = 320;
    public static final int LANE_6_Y = 344;
    public static final double LANE_1_SPEED = 1;
    public static final double LANE_2_SPEED = 1.3;
    public static final double LANE_3_SPEED = 1.5;
    public static final double LANE_4_SPEED = 1.7;
    public static final double LANE_5_SPEED = 2;
    public static final double LANE_6_SPEED = 2.1;
    public static final int NUMBER_OF_LANES = 6;

    //SPRITES
    public final static int PLAYER_SPRITE_FRAMES = 8;
    public final static String PLAYER_SPRITE = "frog2.png";
    public static final String CAR_SPRITE = "car.png";
    public static final String MOTORCYLCE_SPRITE = "motorcycle.png";
    public static final String TRUCK_SPRITE = "truck.png";

    //WINDOW'S
    public final static int WINDOW_WIDTH = 960;
    public final static int WINDOW_LENGTH = 480;
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

    //MISC
    public static final int FIRST_Y = 32;
    public static final int FIRST_X = 32;
    public static final int MIDDLE_DRAW_X = 360;
    public static final int FINISHING_LINE = 48;
    public final static String SCENARIO_FILE = "scenario/scenario1.scn";
    public static final long FRAME_DURATION = 2000;
    public static final int TILE = 32;



}