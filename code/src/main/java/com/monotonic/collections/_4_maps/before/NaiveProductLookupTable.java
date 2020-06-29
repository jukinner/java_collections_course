package com.monotonic.collections._4_maps.before;

import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(final Product productToAdd) {
        int id = productToAdd.getId();
        for (Product product : products) {
            if (product.getId() == id); {
                throw new IllegalArgumentException("Unable to add product = dubplice id for " + product);
            }
        }
        products.add(productToAdd);
    }

    @Override
    public Product lookupById(final int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void clear()
    {
        products.clear();
    }
}

//this class is a naive way to handle this scenario and is a bit bulky. Instead of using array, use a map.
