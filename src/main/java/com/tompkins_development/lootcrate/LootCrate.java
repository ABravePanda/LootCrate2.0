package com.tompkins_development.lootcrate;

import com.tompkins_development.lootcrate.objects.Crate;
import com.tompkins_development.lootcrate.objects.Reward;
import com.tompkins_development.lootcrate.serialization.Serializer;
import com.tompkins_development.lootcrate.utils.NumberUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class LootCrate extends JavaPlugin {

    private Serializer serializer;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        serializer = new Serializer(this);
        List<Reward> rewardList = new ArrayList<>();
        rewardList.add(new Reward(NumberUtils.generateRandomInt(3)));
        rewardList.add(new Reward(NumberUtils.generateRandomInt(3)));
        rewardList.add(new Reward(NumberUtils.generateRandomInt(3)));
        rewardList.add(new Reward(NumberUtils.generateRandomInt(3)));
        Crate crate = new Crate(-1, "&6&lBlue Crate", null, rewardList, null);
        try {
            serializer.save(crate);
            serializer.load("s");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
