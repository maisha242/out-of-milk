package com.api.outofmilk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Item {
    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("quantity") private int quantity;
    @JsonProperty("date") private Date date;
    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
