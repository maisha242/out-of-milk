package com.api.outofmilk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("pass") private String pass;
    @JsonProperty("email") private String email;

    public User(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("pass") String pass,
                @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
