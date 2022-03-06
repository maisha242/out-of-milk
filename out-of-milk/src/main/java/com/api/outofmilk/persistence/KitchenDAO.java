package com.api.outofmilk.persistence;

import com.api.outofmilk.model.Item;
import com.api.outofmilk.model.Kitchen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class KitchenDAO {
    private JdbcTemplate jdbcTemplate;

    private Map<Integer, Kitchen> kitchens;
    private int nextId;

    RowMapper<Item> itemrowMapper = (rs, rowNum) -> {
        Item i = new Item();
        i.setId(rs.getInt("id"));
        i.setName(rs.getString("id"));
        i.setDate(rs.getDate("buydate"));
        i.setQuantity(rs.getInt("quantity"));
        return i;
    };

    RowMapper<Kitchen> rowMapper = (rs, rowNum) -> {
        Kitchen k = new Kitchen();
        k.setId(rs.getInt("id"));
        List<Item> itemz = new ArrayList<Item>();
        String sql1 = "SELECT itemone FROM kitchen INNER JOIN items ON kitchen.itemone = items.id";
        String sql2 = "SELECT itemtwo FROM kitchen INNER JOIN items ON kitchen.itemtwo = items.id";
        String sql3 = "SELECT itemthree FROM kitchen INNER JOIN items ON kitchen.itemthree = items.id";
        itemz.addAll(jdbcTemplate.query(sql1, itemrowMapper));
        itemz.addAll(jdbcTemplate.query(sql2, itemrowMapper));
        itemz.addAll(jdbcTemplate.query(sql3, itemrowMapper));
        //k.setItems(itemz.stream().map(Item::getId).collect(Collectors.toList()));
        k.setItems(itemz);
        this.kitchens.put(k.getId(), k);
        return k;
    };

    public KitchenDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.kitchens = new HashMap<Integer, Kitchen>();
    }

    public Kitchen createKitchen(int kid, int i1, int i2, int i3) {
        String sql = "INSERT INTO kitchen VALUES (" + Integer.toString(kid) + ", " + i1 + ", " + i2 + ", " + i3 + ");";
        jdbcTemplate.execute(sql);
        String sql1 = "SELECT id FROM kitchen WHERE id = " + kid;
        List<Kitchen> i = jdbcTemplate.query(sql1, rowMapper);
        return i.get(0);
    }



}
