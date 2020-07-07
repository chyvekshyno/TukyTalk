package com.example.tukyhelper;


public class Essence {
    private EssenceType _type;
    private String _name;
    private String _iconpath;
    private int _nftnum;

    public Essence(EssenceType type, String name, String iconpath, int nftnum) {
        _type = type;
        _name = name;
        _iconpath = iconpath;
        _nftnum = nftnum;
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

    public int NotificationCount() { return _nftnum;}
}
