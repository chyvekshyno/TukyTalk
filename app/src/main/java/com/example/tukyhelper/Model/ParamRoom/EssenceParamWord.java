package com.example.tukyhelper.Model.ParamRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
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
    @Ignore
    public EssenceParamWord(int id) {
        this.id = id;
    }

    public EssenceParamWord(int id, String essenceTypeId, String paramName, int order, Boolean isNumeric) {
        this.id = id;
        this.essenceTypeId = essenceTypeId;
        this.paramName = paramName;
        this.order = order;
        this.isNumeric = isNumeric;
    }

    //endregion

    //region Accessors
    //region Getters
    public String getParamName() {
        return paramName;
    }

    public Boolean getNumeric() {
        return isNumeric;
    }

    public int getId() {
        return id;
    }

    public String getEssenceTypeId() {
        return essenceTypeId;
    }

    public int getOrder() {
        return order;
    }
    // endregion

    //region Setters
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public void setEssenceTypeId(String essenceTypeId) {
        this.essenceTypeId = essenceTypeId;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setNumeric(Boolean numeric) {
        isNumeric = numeric;
    }

    //endregion
    //endregion


}
