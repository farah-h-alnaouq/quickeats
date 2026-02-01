package com.example.quickeats;

public class Food {
    private String name;
    private String price;
    private int image;

    public Food(String name, String price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
    public int getImage() { return image; }
}
