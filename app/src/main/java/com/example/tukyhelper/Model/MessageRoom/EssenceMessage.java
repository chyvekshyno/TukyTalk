package com.example.tukyhelper.Model.MessageRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.tukyhelper.Model.EssenceRoom.Essence;

@Entity(tableName = "MESSAGES"
        , foreignKeys = @ForeignKey(entity = Essence.class
            , parentColumns = "ID"
            , childColumns = "ESSENCE_ID"))
public class EssenceMessage {

    //region Fields
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    int id;

    @ColumnInfo(name = "ESSENCE_ID")
    int essenceId;

    @ColumnInfo(name = "TYPE")
    int type;

    @ColumnInfo(name = "TITLE")
    String title;

    @ColumnInfo(name = "TEXT")
    String text;

    @ColumnInfo(name = "IMAGE")
    String image;
    //endregion

    //region Constructors
    public EssenceMessage(int id, int type, int essenceId, String title, String text, String image) {
        this.id = id;
        this.type = type;
        this.essenceId = essenceId;
        this.title = title;
        this.text = text;
        this.image = image;
    }

    @Ignore
    public EssenceMessage(int id) {
        this.id = id;
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

    public int getEssenceId() {
        return essenceId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
    //endregion

    //region Setters
    public void setType(int type) {
        this.type = type;
    }

    public void setEssenceId(int essenceId) {
        this.essenceId = essenceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(String image) {
        this.image = image;
    }
    //endregion
    //endregion
}
