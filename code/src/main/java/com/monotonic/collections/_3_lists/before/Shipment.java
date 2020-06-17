package com.monotonic.collections._3_lists.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product>
{
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int MISSING_PRODUCT = -1; //if you code his way with index out of bounds in replace section

    private final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts = new ArrayList<>();
    private List<Product> heavyVanProducts = new ArrayList<>();

    public void add(Product product)
    {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct) {
        if (products.contains(oldProduct)) {
            int position = products.indexOf(oldProduct);
            products.set(position, newProduct);
            return true;
        } else {
            return false;
        }

        //teacher codes it this way-not a big fan of this.
//        int position = products.indexOf(oldProduct);
//        if (position == MISSING_PRODUCT) {
//            return false;
//        } else {
//            products.set(position, newProduct);
//            return true;
//        }
    }

    public void prepare()
    {
        //few ways to do this-His way first which is showcasing the use of different methods in collections
        //Sort the product list
        //Collections.sort(products, Product.BY_WEIGHT); //old way before java 8. provide the object AND how it should sort.

        //java 8 forward, do it this way.
        products.sort(Product.BY_WEIGHT);

        //find the split point between the weights
        int splitPoint = findSplitPoint();

        //create two subviews of the list using subList() which returns based on index start and finish
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());

        //MY KNEE JERK REACTION WAY WOULD BE TO JUST ITERATE OVER THE ARRAY, AND ADD IT TO THE APPROPRIATE VAN VARIABLE AS YOU GO.
    }

    private int findSplitPoint() {
        int size = products.size();
        for (int i = 0; i < size; i++) {
            Product product = products.get(i);
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }
        return 0;
    }

    public List<Product> getHeavyVanProducts()
    {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProducts()
    {
        return lightVanProducts;
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}
