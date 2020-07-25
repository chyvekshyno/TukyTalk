package com.example.tukyhelper.Model.ParamRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ESSENCE_PARAMS",
        foreignKeys = @ForeignKey(entity = EssenceParamWord.class,
                parentColumns = "ID",
                childColumns = "PARAM_ID"))
public class EssenceParam {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    int id;

    @ColumnInfo(name = "ESSENCE_ID")
    int essenceId;

    @ColumnInfo(name = "PARAM_ID")
    int paramId;

    @ColumnInfo(name = "VALUE")
    String value;

    //region Constructors

    public EssenceParam(int id, int essenceId, int paramId, String value) {
        this.id = id;
        this.essenceId = essenceId;
        this.paramId = paramId;
        this.value = value;
    }

    @Ignore
    public EssenceParam(int id) {
        this.id = id;
    }

    //endregion

    //region Accessors
    //region Getters
    public int getId() {
        return id;
    }

    public int getEssenceId() {
        return essenceId;
    }

    public int getParamId() {
        return paramId;
    }

    public String getValue() {
        return value;
    }
    //endregion

    //region Setters
    public void setEssenceId(int essenceId) {
        this.essenceId = essenceId;
    }

    public void setParamId(int paramId) {
        this.paramId = paramId;
    }

    public void setValue(String value) {
        this.value = value;
    }
    //endregion
    //endregion

//    void ValueTypeCheck(String value) throws NumberFormatException, NullPointerException{
//        if (value == null) {
//            throw new NullPointerException("value of parameter [ "
//                    + paramName + " ] is null");
//        }
//        if (isNumeric && !value.matches("-?\\d+(\\.\\d+)?")) {
//            throw new NumberFormatException("value of parameter [ "
//                    + paramName + " ] is Numeric but contains non number symbols");
//        }
//    }
}
