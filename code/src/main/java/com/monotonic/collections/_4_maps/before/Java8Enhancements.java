package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements
{
    public static void main(String[] args)
    {
        Product defaultProd = new Product(
            -1, "Whatever the customer wants", 100);

        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        //look up by id and it doensn't exist, you get a null value.
//        Product product = idToProduct.get(3);
        Product product = idToProduct.getOrDefault(4, defaultProd); //does not change the original Map. as you can see below, id 4 still returns null.
        System.out.println(product);
        System.out.println(idToProduct.get(4)); // returns null since 4 doesn't exist at this time. Doesn't error, returns null

        //Java8 added in default value.

//        Replacing
        Product oldValue = idToProduct.replace(1, new Product(1, "Big Door", 35));
        System.out.println(oldValue);
        System.out.println(idToProduct.get(1)); //printing this shows that the number 1 has been replaced.


//        Replace All-it's a bi function. takes a key and the product, and using a function, replace each. He uses a lambda here. He adds 10 to every weight.
        idToProduct.replaceAll((id, prod) -> {
            return new Product(id, prod.getName(), prod.getWeight() + 10);
        });
            System.out.println(idToProduct);


        //ComputeIfAbsent-unlike getOrDefault; this uses a function to create a new value. It actually puts the value into the Map ONLY IF IT DOESN"T EXIST already (absent).
        //if you try with an ID that exists already, it will
        idToProduct.computeIfAbsent(4,
                                    id -> new Product(id, "door handle", 5));
            System.out.println(product);
            System.out.println(idToProduct.get(4)); //This was added because 4 doesn't exist at first. but below wont.

        idToProduct.computeIfAbsent(3,
                                    id -> new Product(id, "test of computeIfAbsent", 5));
        System.out.println(idToProduct.get(3));//the record in the Map did not change.


        //ForEach method-take s a bi consumer. function that takes 2 arguments and returns void.
        idToProduct.forEach((id, prod) -> {
            System.out.println(prod.getName() + " has an id of " + id);
        });


    }
}
