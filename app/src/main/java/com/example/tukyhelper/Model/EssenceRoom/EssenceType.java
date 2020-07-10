package com.example.tukyhelper.Model.EssenceRoom;

import java.util.HashMap;
import java.util.Map;

public enum EssenceType {
    None(0),
    Home(1),
    Car(2),
    Health(3),
    Animal(4);

    private int value;
    private static Map map = new HashMap<>();

    private EssenceType(int value) {
        this.value = value;
    }

    static {
        for (EssenceType pageType : EssenceType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static EssenceType valueOf(int esType) {
        return (EssenceType) map.get(esType);
    }

    public int getValue() {
        return value;
    }
}
