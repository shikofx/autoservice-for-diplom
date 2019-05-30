
package com.epam.beans;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "order_date",
    "ownerName"
})
public class AutoOrderBean {

    @JsonProperty("id")
    private int id;
    @JsonProperty("order_date")
    private String orderDate;
    @JsonProperty("ownerName")
    private String ownerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public AutoOrderBean withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("order_date")
    public String getOrderDate() {
        return orderDate;
    }

    public AutoOrderBean withOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    @JsonProperty("ownerName")
    public String getOwnerName() {
        return ownerName;
    }

    public AutoOrderBean withOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AutoOrderBean withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AutoOrderBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("orderDate");
        sb.append('=');
        sb.append(((this.orderDate == null) ? "<null>" : this.orderDate));
        sb.append(',');
        sb.append("ownerName");
        sb.append('=');
        sb.append(((this.ownerName == null) ? "<null>" : this.ownerName));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + this.id);
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.ownerName == null) ? 0 : this.ownerName.hashCode()));
        result = ((result * 31) + ((this.orderDate == null) ? 0 : this.orderDate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AutoOrderBean) == false) {
            return false;
        }
        AutoOrderBean rhs = ((AutoOrderBean) other);
        return ((((this.id == rhs.id) && ((this.additionalProperties == rhs.additionalProperties) || (
            (this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && (
                     (this.ownerName == rhs.ownerName) || ((this.ownerName != null) && this.ownerName
                         .equals(rhs.ownerName)))) && ((this.orderDate == rhs.orderDate) || ((this.orderDate != null)
                                                                                             && this.orderDate.equals(
            rhs.orderDate))));
    }

}
