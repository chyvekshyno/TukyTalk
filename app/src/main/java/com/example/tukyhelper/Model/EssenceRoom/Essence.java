package com.example.tukyhelper.Model.EssenceRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class Essence {
    @PrimaryKey(autoGenerate = true)
    private final int id;

    @ColumnInfo(name = "TYPE")
    private int type;

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "ICON")
    private String icon;

    @ColumnInfo(name = "NTF")
    private int nftCount;

    public Essence(int id, int type, String name, String icon, int nftnum) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.icon = icon;
        this.nftCount = nftnum;
    }

    public int getId() {
        return id;
    }

    public int getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public int getNftCount() { return nftCount;}

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String iconpath) {
        this.icon = iconpath;
    }

}
