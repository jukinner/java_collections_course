package com.monotonic.collections._4_maps.before;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps
{
    public static void main(String[] args) {
        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        //1st view - keySet();
        Set<Integer> ids = idToProduct.keySet();
        System.out.println(ids);
        System.out.println(idToProduct);
        System.out.println();

        //similar to the "sublist view into ArrayList
        //views modify their backing collections. VERY IMPORTANT
        //removing an entry
        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);

//        ids.add(5); //can't add because this only add's a key, no value associated with it.

        //2nd view - Values view.
        Collection<Product> products = idToProduct.values();
        System.out.println(products);
        System.out.println(idToProduct);

        products.remove(ProductFixtures.window);
//
        System.out.println(products);
        System.out.println(idToProduct);
//
////        products.add(ProductFixtures.window); //this errors into usuported operation exception. You can't add a value without a key and vice versa.

//      3rd type of view. entry set
        Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet(); //this means we have a set, and that set contains entry elements, and those elements are pairs.
        //common is to loop over it and print out the entry
        for (Map.Entry<Integer, Product> entry : entries) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            entry.setValue(ProductFixtures.window);
        }
//
        Map.Entry<Integer, Product> entry = Map.entry(3, ProductFixtures.window);
        entries.add(entry); //this can not be added.
////
        System.out.println(idToProduct);
    }
}
