package com.monotonic.collections._2_what_are_collections.before;

import com.monotonic.collections.common.Product;

import java.util.Arrays;

public class TheArrayProblem
{
    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        // Create an array of products
        Product[] products = {door, floorPanel};
        // Print
        System.out.println(Arrays.toString(products));

        // Add an element (regular arrays are not resizable. you can't just add new elements
        //try this with just assigning a value to an index(normal function in any other language) they are fixed length
        //this will not compile. You would have to make a new array and put it in there.
        //products[2] = window; //errors out. primitive arrays are not index based.

//        can create an add method which handles the only way to get this done, new array of products, make length + 1,
//        then add this value to the array. annoying.


        // Duplicate
        products = add(window, products);
        System.out.println(Arrays.toString(products));

//        low level arrays are core to Java but they are not very friendly. Collections are much better
    }

    private static Product[] add(Product product, Product[] array)
    {
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }
}
