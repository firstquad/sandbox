package com.firstquad.sandbox;

/**
 * Created by DVFirstov
 */
public class Replicat {
    private String name;
    private String schema;
    private String table;
    private String sourceTime;
    private String lag;
    private String isWarning;

    public Replicat(String name, String schema, String table, String sourceTime, String lag, String isWarning) {
        this.name = name;
        this.schema = schema;
        this.table = table;
        this.sourceTime = sourceTime;
        this.lag = lag;
        this.isWarning = isWarning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getSourceTime() {
        return sourceTime;
    }

    public void setSourceTime(String sourceTime) {
        this.sourceTime = sourceTime;
    }

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag;
    }

    public String getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(String isWarning) {
        this.isWarning = isWarning;
    }
}
