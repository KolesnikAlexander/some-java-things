package model;

import dao.ProductDao;
import entity.Product;

/**
 * Created by alex60070 on 27.07.17.
 */
public class ProductModel {

    public Product getProduct(String name){
        return ProductDao.getProduct(name);
    }
}
