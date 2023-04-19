package com.tompkins_development.lootcrate.objects;

import java.io.Serializable;

public class Reward implements Serializable {
    int id;

    public Reward(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                '}';
    }
}
