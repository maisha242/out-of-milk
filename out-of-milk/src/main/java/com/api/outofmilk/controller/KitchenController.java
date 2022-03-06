package com.api.outofmilk.controller;

import com.api.outofmilk.model.Item;
import com.api.outofmilk.model.Kitchen;
import com.api.outofmilk.persistence.KitchenDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("kitchen")
public class KitchenController {
    private static final Logger LOG = Logger.getLogger(KitchenController.class.getName());

    private KitchenDAO kitchenDao;

    public KitchenController(KitchenDAO kitchenDao) {
        this.kitchenDao = kitchenDao;
    }

    @GetMapping("/{kid}")
    public ResponseEntity<Item[]> getKitchenItems(@PathVariable int kid) {
        LOG.info("Getting items!");
        System.out.println(kitchenDao.getItems(kid));
        return new ResponseEntity<Item[]>(kitchenDao.getItems(kid).toArray(new Item[0]), HttpStatus.OK);
    }
}
