package com.api.outofmilk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Item {
    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("quantity") private int quantity;
    @JsonProperty("date") private String date;
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

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

        this.date = sdf.format(date);
    }
}
