package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer implements Serializable {
    //instance variables/fields
    private final int id;
    private String name;
//    private int wins; // rewards.size() - it's a derived property
    private final List<Reward> rewards = new ArrayList<>();

    //ctors
    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    // action methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    // accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return rewards.size(); //derived property
    }

    // NOTE we are returning a direct reference to our internal List<Reward>; need a read-only
    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public String toString() {
        return String.format("%s: id = %s, name = %s, wins = %s, rewards = %s\n",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}