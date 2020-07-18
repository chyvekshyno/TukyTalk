package com.example.tukyhelper.Model.EssenceRoom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "essence")
public class Essence {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "TYPE")
    private int type;

    @ColumnInfo(name = "NAME") @NonNull
    private String name = "Essence";

    @ColumnInfo(name = "ICON") @NonNull
    private String icon = "essence_icon";

    @ColumnInfo(name = "NTF", defaultValue = "2")
    private int nftCount;

    @Ignore
    public Essence(int type) {
        this.type = type;
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

    @NonNull
    public String getName() { return name; }
    @NonNull
    public String getIcon() { return icon; }

    public int getNftCount() { return nftCount;}

    public void setName(String name) { this.name = name; }

    public void setNftCount (int nftCount) { this.nftCount = nftCount; }

    public void setIcon(String iconpath) { this.icon = iconpath; }

}
