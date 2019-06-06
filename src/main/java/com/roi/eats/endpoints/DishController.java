package com.roi.eats.endpoints;

import com.roi.eats.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.roi.eats.domain.Dish;
import com.roi.eats.domain.Category;



@RestController
@RequestMapping(path="eats/sumtin/v0/",
produces= MediaType.APPLICATION_JSON_VALUE)
public class DishController {

    private final DishRepository dbCtxt;

    @Autowired
    public DishController(DishRepository dbCtxt) {
        this.dbCtxt = dbCtxt;
    }

    @PostMapping(path="menu",
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMenuItem(@RequestBody Dish meanItem){
        Dish addedItem = this.dbCtxt.save(meanItem);
        return new ResponseEntity(addedItem, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCurrentMenuItems(){
        return new ResponseEntity(this.dbCtxt.findAll(), HttpStatus.OK);
    }

    @GetMapping(path= "sample/dish")
    public Dish getSamplePlate(){
        return new Dish("Hot Wings", Category.PROTEIN, "Truly Spicey Wings", 6.50f, 12.99f);
    }

    @GetMapping(path= "sample/drink")
    public Dish getSampleDrink(){
        return new Dish("Martini", Category.LIQUID, "Truly Spicey Martini", 6.50f, 12.99f);
    }


}
