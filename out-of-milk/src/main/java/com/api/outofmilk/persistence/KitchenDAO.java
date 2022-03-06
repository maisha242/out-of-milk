package com.api.outofmilk.persistence;

import com.api.outofmilk.model.Item;
import com.api.outofmilk.model.Kitchen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Component
public class KitchenDAO {
    private JdbcTemplate jdbcTemplate;

    private Map<Integer, Kitchen> kitchens;
    private int nextItemId;

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
        String sql1 = "SELECT * FROM items WHERE itemid IN (SELECT kitchen.itemone FROM kitchen);";

        String sql2 = "SELECT * FROM items WHERE itemid IN (SELECT kitchen.itemtwo FROM kitchen);";
        String sql3 = "SELECT * FROM items WHERE itemid IN (SELECT kitchen.itemthree FROM kitchen);";
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
        List<Item> i = jdbcTemplate.query("SELECT * FROM items", itemrowMapper);
        this.nextItemId = 0;
        for (Item j : i) {
            if (j.getId() > this.nextItemId) {
                this.nextItemId = j.getId();
            }
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


    public Item createItem(int kid, Item item) {
        synchronized(kitchens) {
            LocalDateTime current = LocalDateTime.now();
            Item newItem = new Item(++nextItemId, item.getName(), item.getQuantity());
            java.sql.Date newDate = new java.sql.Date(current.toInstant(ZoneOffset.UTC).toEpochMilli());
            newItem.setDate(newDate);
            Item oldItem = kitchens.get(kid).getItems().remove(2);
            kitchens.get(kid).getItems().add(newItem);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


                //Date java_date = sdf.parse(newItem.getDate());
                //java.sql.Date sql_date = new java.sql.Date(());
                jdbcTemplate.execute("INSERT INTO items VALUES (" + newItem.getId() + ", " + "'" + newItem.getName() + "'" + ", " + newItem.getQuantity() + ", " + "'" + sdf.format(newDate) + "'" + ");");
                jdbcTemplate.execute("UPDATE kitchen SET itemthree = " + newItem.getId() + " WHERE kitchenid = " + kid + ";");

            return newItem;
        }
    }



}
