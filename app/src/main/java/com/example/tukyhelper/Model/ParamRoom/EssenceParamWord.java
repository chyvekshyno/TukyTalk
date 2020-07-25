package com.example.tukyhelper.Model.ParamRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PARAMS_DIC")
public class EssenceParamWord {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    int id;

    @ColumnInfo(name = "ESSENCE_TYPE_ID")
    String essenceTypeId;

    @ColumnInfo(name = "PARAM_NAME")
    String paramName;

    @ColumnInfo(name = "ORDER")
    int order;

    @ColumnInfo(name = "IS_NUMERIC")
    Boolean isNumeric;

    //region Constructors
    public EssenceParamWord(String paramName, Boolean isNumeric) {
        this.isNumeric = isNumeric;
        this.paramName = paramName;
    }

    //endregion

    //region Accessors

    public String getParamName() {
        return paramName;
    }

    public Boolean getNumeric() {
        return isNumeric;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    //endregion


}
