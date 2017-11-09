package entity;

/**
 * Created by alex60070 on 27.07.17.
 */
public class Product {
    String name;
    String model;
    int id;

    public Product(String name, String model, int id) {
        this.name = name;
        this.model = model;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }
}
