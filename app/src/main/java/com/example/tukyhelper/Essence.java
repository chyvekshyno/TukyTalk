package com.example.tukyhelper;


public class Essence {
    private EssenceType _type;
    private String _name;
    private String _id;
    private String _iconpath;

    public Essence(EssenceType type, String name, String id, String iconpath) {
        _type = type;
        _name = name;
        _id = id;
        _iconpath = iconpath;
    }

    public EssenceType type(){
        return _type;
    }

    public String name(){
        return _name;
    }

    public String icon() {
        return _iconpath;
    }
}
