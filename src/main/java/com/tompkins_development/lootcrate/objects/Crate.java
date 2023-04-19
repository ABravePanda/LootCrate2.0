package com.tompkins_development.lootcrate.objects;

import com.tompkins_development.lootcrate.Conts;
import com.tompkins_development.lootcrate.utils.NumberUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crate implements Serializable {

    private int id;
    private String title;
    private Key key;
    private List<Reward> rewards;
    private List<Setting> settings;

    public Crate(int id, String title, Key key, List<Reward> rewards, List<Setting> settings) {
        this.setId(id);
        this.setTitle(title);
        this.setKey(key);
        this.setRewards(rewards);
        this.setSettings(settings);
    }

    public Crate(String title, Key key, List<Reward> rewards, List<Setting> settings) {
        this(-1, title, key, rewards, settings);
    }

    public Crate(String title, Key key, List<Setting> settings, Reward... rewards) {
        this(-1,title, key, Arrays.stream(rewards).toList(), settings);
    }

    public Crate(String title, Key key) {
        this(-1, title, key, null, null);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Key getKey() {
        return key;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setId(int id) {
        if(id == -1)
            id = NumberUtils.generateRandomInt(Conts.CRATE_ID_LENGTH);
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setRewards(List<Reward> rewards) {
        if(rewards == null)
            rewards = new ArrayList<>();
        this.rewards = rewards;
    }

    public void setSettings(List<Setting> settings) {
        if(settings == null)
            settings = new ArrayList<>();
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "Crate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", key=" + key +
                ", rewards=" + rewards +
                ", settings=" + settings +
                '}';
    }
}
