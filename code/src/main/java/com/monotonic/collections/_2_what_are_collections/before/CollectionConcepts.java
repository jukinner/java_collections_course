package com.monotonic.collections._2_what_are_collections.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionConcepts
{
    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        //examples of other methods
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(window));
        System.out.println(products.remove(window));
        System.out.println(products.contains(window));

//        System.out.println(products); //prints out 1 line

        Collection<Product> toRemove = new ArrayList<>();
        toRemove.add(door);
        toRemove.add(floorPanel);
        products.removeAll(toRemove);
        System.out.println(products); //this removed all the elements from products that were in toRemove. bulk operation.

        for (Product product : products) {
            if (product.getWeight() > 20) {
//                products.remove(product); //this fails out because you are trying to remove items from collection while it is
////                being iterated on.
            }
//            System.out.println(product);
        }
////        Better way with no errors
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if(product.getWeight() > 20) {
                iterator.remove();
            }
        }
        System.out.println(products);
    }
}
