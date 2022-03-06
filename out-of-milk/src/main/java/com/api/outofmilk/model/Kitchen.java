package com.api.outofmilk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kitchen {

    @JsonProperty("id") private int id;
    @JsonProperty("items") private List<Items> items;
}
