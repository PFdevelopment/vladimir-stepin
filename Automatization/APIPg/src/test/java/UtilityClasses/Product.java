package UtilityClasses;

public class Product {
    private String name;
    private String type;
    private String upc;
    private double price;
    private String description;
    private String model;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUpc() {
        return upc;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getModel() {
        return model;
    }

}
