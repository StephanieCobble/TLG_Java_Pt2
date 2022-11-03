package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */


public class Board implements Serializable { // Board objects can now be written to file
    private static final String dataFilePath = "data/board.dat";
    private static final String studentIdFilePath = "conf/student-ids.csv";


    // if data/board.dat exists, read board Object from binary file.
    // if not, create new
    // finally return it
    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(dataFilePath))) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else { // fires if file doesn't exist
            board = new Board();
        }

        return board;
    }

    //instance variables (fiels) - this is a Board object's "state"
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    //no outside instantiation - getInstance() is the sole access point
    private Board() {
    }


    /*
     * Updates the board (racerMap) by making a DuckRacer win.
     * This could mean fetching an existing DuckRacer from racerMap,
     * or we might need to create a new DuckRacer (first-time winner),
     * put it in the map, and then make it win.
     * NOTE: either way, it needs to win!
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) { // existing DuckRacer, fetch & call win()
            racer = racerMap.get(id);
        } else { //not it map, create new & put in map
            racer = new DuckRacer(id, studentIdMap.get(id)); // name next to ID
            racerMap.put(id, racer);
        }
        racer.win(reward);
        save();
    }



    // testing purposes
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("The board is currently empty");
        } else {

            Collection<DuckRacer> racers = racerMap.values();
            System.out.println("ID      Name       Wins            Rewards");
            System.out.println("--------------------------------------------------------------");
            for (DuckRacer racer : racers) {
//            System.out.println(racer);
                System.out.printf("%2s %9s %9s %30s\n",
                        racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
            }
        }
    }

    /*
     * Loads studentIdMap from conf/student-ids.csv
     * more accurately, it creates a Map<Integer,String>, populates it, & returns it
     */
    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(studentIdFilePath));

            //for each line, we "split" it on the comma into two "tokens"
            for (String line : lines) {
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                idMap.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }

    // writes this board object to binary file "data/board.dat
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this); // write me a Board obj to binary file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}