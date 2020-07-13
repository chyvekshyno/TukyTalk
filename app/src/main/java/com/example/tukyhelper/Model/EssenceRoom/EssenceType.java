package com.example.tukyhelper.Model.EssenceRoom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "essence_type")
public class EssenceType {

    @PrimaryKey private int id;

    @ColumnInfo(name = "TYPENAME", defaultValue = "Essence") @NonNull
    private String type_name = "Essence";

    @Ignore
    public EssenceType(int id) {
        this.id = id;
    }

    public EssenceType(int id, @NonNull String type_name) {
        this.id = id;
        this.type_name = type_name;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTypeName() {
        return type_name;
    }

    public void setTypeName(@NonNull String type_name) {
        this.type_name = type_name;
    }
}
