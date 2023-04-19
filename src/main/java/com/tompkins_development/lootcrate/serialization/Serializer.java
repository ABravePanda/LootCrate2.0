package com.tompkins_development.lootcrate.serialization;

import com.tompkins_development.lootcrate.Conts;
import com.tompkins_development.lootcrate.LootCrate;
import com.tompkins_development.lootcrate.objects.Crate;

import com.tompkins_development.lootcrate.utils.StringUtils;

import java.io.*;

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
        FileOutputStream f = new FileOutputStream(path);
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(crate);

        o.close();
        f.close();
    }

    public void load(String s) throws Exception {
        File path = new File(cratesDirectory + File.separator + "blue_crate" + Conts.CRATE_EXTENSION);
        FileInputStream f = new FileInputStream(path);
        ObjectInputStream o = new ObjectInputStream(f);

        Crate crate = (Crate) o.readObject();
        System.out.println(crate);

        o.close();
        f.close();
    }




}
