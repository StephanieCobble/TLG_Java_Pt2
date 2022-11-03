package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;
import static com.duckrace.Reward.*;

/*
 * Application "controller"
 * Directs overall flow of the application
 * Prompts user for inputs & forwards thse inputs into the systems (model) class
 */
public class DuckRaceApp {
    private final Scanner scanner = new Scanner(System.in); // reads from console input
//    private final Board board = new Board();
    private final Board board = Board.getInstance();
    private static final int maxId = 21;

//    High level overall flow of the application
    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    // user inputs are passed into system, let system classes do the work
    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter your choice of reward. [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.matches("D|P")) {
                validInput = true;
                reward = ("D".equals(input)) ? DEBIT_CARD : PRIZES; // ternary does same as below if else
//                if ("D".equals(input)) {
//                    reward = DEBIT_CARD;
//                } else {
//                    reward = PRIZES;
//                }
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter ID of the winner [1-21]: "); // TODO don't hardcode 21
            String input = scanner.nextLine().trim();
            if (input.matches("\\d{1,2}")) { // any digit 1 or 2 times
                id = Integer.parseInt(input); // safe bc you know you got digits
                if (1 <= id && id <= 21) {
                    validInput = true;
                }
            }
        }
        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("~WELCOME TO THE DUCKRACE APPLICATION~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }


}