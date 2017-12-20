package frogger;

import jplay.GameImage;
import jplay.Window;

import java.awt.*;
import java.io.*;
import java.util.Vector;

import static java.lang.System.out;
import static frogger.Settings.*;

public class Ranking {

    Vector<String> names;
    Vector<Integer> scores;

    public Ranking() throws IOException {
        names = new Vector<>();
        scores = new Vector<>();
    }

    public void update(String player_name, Integer player_score) throws IOException {
        if (file_exists()) {
            read_ranks();
            names.add(player_name);
            scores.add(player_score);
            sort_ranks();
            write_ranks();
        }
        else {
            names.add(player_name);
            scores.add(player_score);
            sort_ranks();
            write_ranks();
        }
    }

    private void sort_ranks() {
        for(int i=0; i<scores.size(); i++){
            for(int j=0; j<scores.size() - 1; j++){
                if(scores.get(j) < scores.get(j+1)){
                    Integer aux1 = scores.get(j);
                    scores.set(j, scores.get(j+1));
                    scores.set(j+1, aux1);

                    String aux2 = names.get(j);
                    names.set(j, names.get(j+1));
                    names.set(j+1, aux2);
                }
            }
        }
    }

    public void draw(Window window) {
        window.clear(Color.BLACK);
        GameImage background = new GameImage(RANKINGS_BACKGROUND_FILE);
        Font font = new Font("Arial", FONT_STYLE, FONT_SIZE);

        background.draw();
        String rank;
        for(int i=0; i< RANKINGS_TOP_SCORES; i++) {
            rank = names.get(i) + " - " + scores.get(i).toString();
            window.drawText(rank, MIDDLE_DRAW_X,   3*i*LINE_WIDTH, Color.YELLOW, font);
        }
    }

    private void write_ranks() {
        try {
            FileWriter file_writer = new FileWriter(RANKINGS_FILE);
            PrintWriter print_writer = new PrintWriter(file_writer);

            for(int i=0; i < names.size(); i++) {
                print_writer.println(names.get(i));
                print_writer.println(scores.get(i));
            }

            print_writer.close();
        } catch (IOException exception) {
            out.println("Error creating rankings file!");
        }
    }

    private void read_ranks() throws IOException {
        FileReader fileReader = new FileReader(RANKINGS_FILE);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;

        while ((line = bufferedReader.readLine()) != null)
        {
            names.add(line);
            line = bufferedReader.readLine();
            scores.add(Integer.parseInt(line));
        }
        bufferedReader.close();
    }

    private boolean file_exists() {
        File file = new File(RANKINGS_FILE);
        if(file.exists() && !file.isDirectory()) {
            return true;
        }
        else
            return false;
    }
}
