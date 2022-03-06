package com.api.outofmilk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Kitchen {

    @JsonProperty("id") private int id;
    @JsonProperty("items") private List<Item> items;

    
}
