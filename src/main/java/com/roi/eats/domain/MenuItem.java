package com.roi.eats.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.Objects;

@MappedSuperclass
public abstract class MenuItem {
    private float cost;
    private float price;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String itemTitle;
    private Category itemCategory;

    public MenuItem(){
        this.id = Instant.now().getEpochSecond();
    }

    public MenuItem(String itemTitle, Category itemCategory, float cost, float price) {
        this();
        this.itemTitle = itemTitle;
        this.itemCategory = itemCategory;
        this.cost = cost;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return Float.compare(menuItem.getCost(), getCost()) == 0 &&
                Float.compare(menuItem.getPrice(), getPrice()) == 0 &&
                getId() == menuItem.getId() &&
                getItemTitle().equals(menuItem.getItemTitle()) &&
                getItemCategory() == menuItem.getItemCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCost(), getPrice(), getId(), getItemTitle(), getItemCategory());
    }
}
