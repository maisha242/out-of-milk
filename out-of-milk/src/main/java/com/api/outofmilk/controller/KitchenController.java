package com.api.outofmilk.controller;

import com.api.outofmilk.model.Kitchen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kitchen")
public class KitchenController {

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> getKitchen(@PathVariable int id) {

    }
}
