package com.company;

public class Item {
    private String id;
    private String name;
    private String category;
    private String status;

    public Item(String id, String name, String category, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
    }

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
