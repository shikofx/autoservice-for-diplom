package com.epam.domain;

public interface Entity {

    String dbTableName();

    String dbColumnsName();

    String typeConversion(String toString);

    String dbValues() throws IllegalAccessException;
}
