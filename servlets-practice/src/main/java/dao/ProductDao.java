package dao;

import entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex60070 on 27.07.17.
 */
public class ProductDao {
    private static List<Product> dataBase = new ArrayList<Product>();
    static{
        dataBase.add(new Product("Smartphone", "Samsung", 0));
        dataBase.add(new Product("Computer", "Hp", 1));
        dataBase.add(new Product("Book", "model", 2));
    }
    public static Product getProduct(String name){
        Iterator<Product> iterator = dataBase.iterator();
        Product product;
        while (iterator.hasNext()){
            product = iterator.next();
            if (product.getName().toUpperCase().equals(name.toUpperCase()))
                return product;
        }
        return null;
    }
}
