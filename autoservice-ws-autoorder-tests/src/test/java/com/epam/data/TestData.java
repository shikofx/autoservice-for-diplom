package com.epam.data;

public class TestData {

    private String orderDate;
    private String ownerName;

    public String orderDate() {
        return orderDate;
    }

    public String ownerName() {
        return ownerName;
    }

    public TestData withOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public TestData withOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    @Override
    public String toString() {
        return "TestData{" +
               "orderDate='" + orderDate + '\'' +
               ", ownerName='" + ownerName + '\'' +
               '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.ownerName == null) ? 0 : this.ownerName.hashCode()));
        result = ((result * 31) + ((this.orderDate == null) ? 0 : this.orderDate.hashCode()));
        return result;
    }

}
