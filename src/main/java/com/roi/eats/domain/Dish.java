package com.roi.eats.domain;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Dish extends MenuItem {
    private String description;

    public Dish() {
        super();
    }


    public Dish(String itemTitle, Category itemCategory, String description, float cost, float price) {
        super(itemTitle, itemCategory, cost, price);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        if (!super.equals(o)) return false;
        Dish dish = (Dish) o;
        return getDescription().equals(dish.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDescription());
    }
}
