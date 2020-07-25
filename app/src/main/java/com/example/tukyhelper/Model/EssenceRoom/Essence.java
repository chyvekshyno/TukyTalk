package com.example.tukyhelper.Model.EssenceRoom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.tukyhelper.Model.ParamRoom.EssenceParamWord;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "essence",
        foreignKeys = @ForeignKey(entity = EssenceType.class
                , parentColumns = "id"
                , childColumns = "TYPE"))
public class Essence {

    //region Parameters
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    @ColumnInfo(name = "TYPE")
    private int type;

    @ColumnInfo(name = "NAME") @NonNull
    private String name = "Essence";

    @ColumnInfo(name = "ICON") @NonNull
    private String icon = "essence_icon";

    @ColumnInfo(name = "NTF", defaultValue = "2")
    private int nftCount;

    //endregion

    //region Constructors

    @Ignore
    public Essence(int type) {
        this.type = type;
    }

    public Essence(int id, int type, @NonNull String name, @NonNull String icon, int nftCount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.icon = icon;
        this.nftCount = nftCount;
    }

    //endregion
    //region Accessors
    //region Getters
    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getIcon() {
        return icon;
    }

    public int getNftCount() {
        return nftCount;
    }

    //endregion

    //region Setters
    public void setName(@NonNull String name){
        this.name = name;
    }

    public void setNftCount(int nftCount){
        this.nftCount = nftCount;
    }

    public void setIcon(@NonNull String iconpath){
        this.icon = iconpath;
    }

    //endregion

    //endregion
}
