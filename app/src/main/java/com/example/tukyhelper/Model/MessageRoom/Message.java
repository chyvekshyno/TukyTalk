package com.example.tukyhelper.Model.MessageRoom;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity
public class Message {

    //region Fields
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    int id;

    @ColumnInfo(name = "TITLE")
    String title;

    @ColumnInfo(name = "TEXT")
    String text;

    @ColumnInfo(name = "IMAGE")
    String image;
    //endregion

    //region Constructors
    public Message(int id, String title, String text, String image) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.image = image;
    }

    @Ignore
    public Message(int id) {
        this.id = id;
    }
    //endregion

    //region Accessors
    //region Getters
    public int getId() {
        return id;
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
