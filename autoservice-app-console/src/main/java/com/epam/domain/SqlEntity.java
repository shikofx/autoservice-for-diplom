package com.epam.domain;

import java.lang.reflect.Field;

public abstract class SqlEntity implements Entity {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE";
    public static final String SQL_DROP_TABLE = "DROP TABLE";
    public static final String SQL_INSERT_INTO = "INSERT INTO";

    @Override
    public String dbTableName() {
        return String.format("%s", this.getClass().getSimpleName().toUpperCase());
    }

    @Override
    public String dbColumnsName() {
        Field[] fields = this.getClass().getDeclaredFields();
        String fieldsString = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (i < fields.length - 2 && fields.length > 0) {
                fieldsString += field.getName() + " " + typeConversion(field.getType().getName()) + ", ";
            } else if (i == fields.length - 2) {
                fieldsString += field.getName() + " " + typeConversion(field.getType().getName());
            }
        }
        return fieldsString;
    }

    @Override
    public String dbValues() throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        String fieldsString = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String mark = "";
            String type = field.getType().getTypeName();
            if (type.equals("java.lang.String") || type.equals("java.util.Date")) {
                mark = "'";
            }
            if (i < fields.length - 2 && fields.length > 0) {
                fieldsString += mark + field.get(this) + mark + ", ";
            } else if (i == fields.length - 2) {
                fieldsString += mark + field.get(this) + mark;
            }
        }
        return fieldsString;
    }

    @Override
    public String typeConversion(String toString) {
        switch (toString) {
            case "java.util.Date":
                return "VARCHAR(30)";
            case "java.lang.String":
                return "VARCHAR(40)";
            case "int":
                return "INT";
            case "long":
                return "BIGINT";
            case "double":
                return "DOUBLE";
        }
        return null;
    }

}
