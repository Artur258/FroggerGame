package frogger;


import jplay.Time;

//TODO create constants for the lines and refactor this shit cause it is ugly
public final class Settings {
    public final static String COVER_IMAGE = "cover2.jpg";
    public final static String MAP_IMAGE = "new_map.png";
    public final static String PLAYER_SPRITE = "frog2.png";
    public final static String SCENARIO_FILE = "scenario/scenario1.scn";
    public final static int PLAYER_SPRITE_FRAMES = 8;
    public final static double PLAYER_HORIZONTAL_SPEED = 10;
    public final static double PLAYER_VERTICAL_SPEED = 10;
    public final static int PLAYER_STARTING_POSITION_X = 400;
    public final static int PLAYER_STARTING_POSITION_Y = 400;
    public final static int WINDOW_WIDTH = 960;
    public final static int WINDOW_LENGTH = 480;
    public static final long FRAME_DURATION = 2000;
    public static final String CAR_SPRITE = "car.png";
    public static final int PLAYER_STARTING_SCORE = 0;
    public static final int PLAYER_STARTING_LIVES = 3;
    public static final double VEHICLE_SPEED = 0.3;
    public static final int LINE_WIDTH = 32;
    public static final int COLUMN_WIDTH = 32;
    public static final int SPAWN_X_POSTION = -64;
    public static final int VEHICLE_RESPAWN_TIME = 3;
    public static final String MOTORCYLCE_SPRITE = "motorcycle.png";
    public static final int VEHICLE_MAX_SPAWN_RATE = 100;
    public static final int CAR_SPAWN_RANGE = 50;
    public static final int MOTORCYLCE_SPAWN_RANGE = 80;
    public static final int TRUCK_SPAWN_RANGE = 100;
    public static final String TRUCK_SPRITE = "truck.png";
    public static final int FIRST_Y = 32;
    public static final int FIRST_X = 32;
    public static final int MIDDLE_DRAW_X = 360;
    public static final int FONT_SIZE = 32;
    public static final int FONT_STYLE = 1;
    public static final int RANKINGS_TOP_SCORES = 4;
    public static final int FIRST_LEVEL = 0;
    public static final int FINISHING_LINE = 48;
    public static final String RANKINGS_FILE = "rankings.txt";
    public static final String RANKINGS_BACKGROUND_FILE = "rankings_background.png";
    public static final Time STARTING_TIME = new Time(0, 0, 30, Settings.FIRST_X, Settings.FIRST_Y, false);;
}