package com.tompkins_development.lootcrate.serialization;

public interface Serializable {

    void serialize(Object object);

    Object deserialize(String data);

}
