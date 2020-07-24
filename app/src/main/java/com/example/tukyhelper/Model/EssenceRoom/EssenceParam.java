package com.example.tukyhelper.Model.EssenceRoom;

public class EssenceParam {

    String paramName = "Parameter";
    String value = "";
    Boolean isNumber;

    //region Constructors
    public EssenceParam(String paramName, String value, Boolean isNumeric) {
        this.isNumber = isNumeric;

        try {
            ValueTypeCheck(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        this.paramName = paramName;
        this.value = value;
    }

    public EssenceParam(String paramName, double value) {
        this(paramName, String.valueOf(value), true);
    }

    public EssenceParam(String paramName, Boolean isNumeric) {
        this.paramName = paramName;
        this.isNumber = isNumeric;
    }

    //endregion

    //region Accessors

    public String getParamName() {
        return paramName;
    }

    public String getValue() {
        return value;
    }

    public Boolean getNumeric() {
        return isNumber;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public void setValue(String value) {
        try {
            ValueTypeCheck(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        this.value = value;
    }

    public void setValue(double value) throws NumberFormatException{
        if (!isNumber){
            throw new NumberFormatException("value of parameter [ "
                    + paramName + " ] is NOT numeric");
        }
        setValue(String.valueOf(value));
    }

    //endregion

    void ValueTypeCheck(String value) throws NumberFormatException, NullPointerException{
        if (value == null) {
            throw new NullPointerException("value of parameter [ "
                    + paramName + " ] is null");
        }
        if (isNumber && !value.matches("-?\\d+(\\.\\d+)?")) {
            throw new NumberFormatException("value of parameter [ "
                    + paramName + " ] is Numeric but contains non number symbols");
        }
    }
}
