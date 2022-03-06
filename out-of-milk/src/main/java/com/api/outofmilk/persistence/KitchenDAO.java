package com.api.outofmilk.persistence;

import com.api.outofmilk.model.Item;
import com.api.outofmilk.model.Kitchen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class KitchenDAO {
    private JdbcTemplate jdbcTemplate;

    private Map<Integer, Kitchen> kitchens;
    private int nextId;

    RowMapper<Item> itemrowMapper = (rs, rowNum) -> {
        Item i = new Item();
        i.setId(rs.getInt("itemid"));
        i.setName(rs.getString("name"));
        i.setDate(rs.getDate("buydate"));
        i.setQuantity(rs.getInt("quantity"));
        return i;
    };

    RowMapper<Kitchen> rowMapper = (rs, rowNum) -> {
        Kitchen k = new Kitchen();
        k.setId(rs.getInt("kitchenid"));
        List<Item> itemz = new ArrayList<Item>();
        String sql1 = "SELECT * FROM items WHERE items.itemid = 1";

        String sql2 = "SELECT * FROM items WHERE items.itemid = 2";
        String sql3 = "SELECT * FROM items WHERE items.itemid = 3";
        itemz.addAll(jdbcTemplate.query(sql1, itemrowMapper));
        itemz.addAll(jdbcTemplate.query(sql2, itemrowMapper));
        itemz.addAll(jdbcTemplate.query(sql3, itemrowMapper));
        //k.setItems(itemz.stream().map(Item::getId).collect(Collectors.toList()));
        k.setItems(itemz);
        this.kitchens.put(k.getId(), k);
        return k;
    };

    private void load() {
        List<Kitchen> k = jdbcTemplate.query("SELECT * FROM kitchen", rowMapper);
        for (Kitchen i : k) {
            this.kitchens.put(i.getId(), i);
        }
    }
    public KitchenDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.kitchens = new HashMap<Integer, Kitchen>();
        load();
    }

    public Kitchen createKitchen(int kid, int i1, int i2, int i3) {
        String sql = "INSERT INTO kitchen VALUES (" + Integer.toString(kid) + ", " + i1 + ", " + i2 + ", " + i3 + ");";
        jdbcTemplate.execute(sql);
        String sql1 = "SELECT kitchenid FROM kitchen WHERE kitchenid = " + kid;
        List<Kitchen> i = jdbcTemplate.query(sql1, rowMapper);
        return i.get(0);
    }

    public List<Item> getItems(int kid) {
        return this.kitchens.get(kid).getItems();
    }



}
