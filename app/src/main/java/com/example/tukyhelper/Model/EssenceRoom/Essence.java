package com.example.tukyhelper.Model.EssenceRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
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

    @Ignore
    public Essence(int id) {
        this.id = id;
    }

    public Essence(int id, int type, String name, String icon, int nftCount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.icon = icon;
        this.nftCount = nftCount;
    }

    public int getId() { return id; }

    public int getType() { return type;  }

    public String getName() { return name; }

    public String getIcon() { return icon; }

    public int getNftCount() { return nftCount;}

    public void setName(String name) { this.name = name; }

    public void setNftCount (int nftCount) { this.nftCount = nftCount; }

    public void setIcon(String iconpath) { this.icon = iconpath; }

}
