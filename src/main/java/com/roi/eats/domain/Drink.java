package com.roi.eats.domain;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Drink extends MenuItem {
    private boolean adult;
    private String description;

    public Drink() {
        super();
    }

    public Drink(String itemTitle, Category itemCategory, float cost, float price, boolean adult, String description) {
        super(itemTitle, itemCategory, cost, price);
        this.adult = adult;
        this.description = description;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
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
        if (!(o instanceof Drink)) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return isAdult() == drink.isAdult() &&
                getDescription().equals(drink.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isAdult(), getDescription());
    }
}
