package com.tompkins_development.lootcrate.serialization;

import com.tompkins_development.lootcrate.Conts;
import com.tompkins_development.lootcrate.LootCrate;
import com.tompkins_development.lootcrate.objects.Crate;
import com.tompkins_development.lootcrate.objects.Reward;
import com.tompkins_development.lootcrate.utils.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.List;

public class Serializer {

    private LootCrate plugin;
    private File dataDirectory;
    private File cratesDirectory;

    public Serializer(LootCrate plugin) {
        this.plugin = plugin;
        dataDirectory = new File(plugin.getDataFolder() + Conts.SAVE_PATH);
        cratesDirectory = new File(plugin.getDataFolder() + Conts.CRATES_PATH);
        init();
    }

    private void init() {
        if(!dataDirectory.exists())
            dataDirectory.mkdirs();
        if(!cratesDirectory.exists())
            cratesDirectory.mkdirs();
    }

    public void save(Crate crate) throws Exception {
        File path = new File(cratesDirectory + File.separator + StringUtils.strip(crate.getTitle()) + Conts.CRATE_EXTENSION);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        Field[] fields = Crate.class.getDeclaredFields();
        for(Field field : fields) {
            String textToWrite = "";
            System.out.println(field.getName().toLowerCase());
            switch (field.getName().toLowerCase()) {
                case "id":
                    textToWrite = "id: " + crate.getId();
                    break;
                case "title":
                    textToWrite = "title: " + crate.getTitle();
                    break;
                case "rewards":
                    textToWrite = rewards(crate.getRewards());
                    break;
                default:
                    textToWrite = field.getName() + ": None";
            }
            textToWrite+="\n";
            writer.write(textToWrite);
        }
        writer.close();
    }

    private String rewards(List<Reward> rewardList) {
        String returnString = "rewards: \n";

        int index = 0;
        for(Reward reward : rewardList) {
            index++;
            returnString+="\t- " + reward.getId();
            if(index != rewardList.size()) returnString+="\n";
        }
        return returnString;
    }



}
