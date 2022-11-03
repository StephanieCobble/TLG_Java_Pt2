package com.duckrace;

import java.util.List;

import static com.duckrace.Reward.*;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer3 = new DuckRacer(3, "Chris");
        System.out.println(racer3);

        // make it win
        racer3.win(PRIZES);
        racer3.win(PRIZES);
        racer3.win(DEBIT_CARD);
        System.out.println(racer3);

        // let's find out what the rewards are for this DuckRacer object
        List<Reward> rewards = racer3.getRewards();
        System.out.println(rewards);

//        rewards.add(DEBIT_CARD);
//        rewards.add(DEBIT_CARD);
//        System.out.println(racer3);

        racer3.win(DEBIT_CARD);
        racer3.win(PRIZES);
        System.out.println(rewards);
        System.out.println(racer3);
    }
}