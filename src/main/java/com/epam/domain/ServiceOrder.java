package com.epam.domain;

import java.util.Date;
import java.util.Objects;

public class ServiceOrder {

    int id;
    Date date;
    String ownerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public String getClassName() {
        return String.format("%s", this.getClass().getName());
    }

    public String getFieldsToTable() {
        return String.format("(id, %d), (date,%s), (ownerName,%s)", id, date, ownerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder serviceOrder = (ServiceOrder) o;
        return id == serviceOrder.id &&
                date.equals(serviceOrder.date) &&
                ownerName.equals(serviceOrder.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, ownerName);
    }
}
