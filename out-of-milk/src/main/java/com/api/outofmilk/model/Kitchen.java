package com.api.outofmilk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Kitchen {

    @JsonProperty("id") private int id;
    private List<Item> items;

    public Kitchen(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public Kitchen() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
