package LessonProblems.ObjectSortImp;

import LessonProblems.Lesson22MinSpanTree.KruskalScaler;

import java.io.*;
import java.util.*;
//https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/

/*
With this when we have class of object and I want to sort based on qty so using comparable
interface for sorting

Important: just by heart this code of using compareTo and implementing it's interface
don't try to debug with breakpoint you will get confused just see it's example with below links
like that only it works don't run comparators with breakpoint waste of time.

Just remember below things
if s1 > s2, it returns positive number
if s1 < s2, it returns negative number
if s1 == s2, it returns 0

#1) there are different ways we can sort them for object type one is inside
our object class itself by compareTo method using interface

#2) next type https://dzone.com/articles/how-to-sort-objects-in-java
above is good link all different type of sorting is there
creating another class i

#3) third type directly sorting inside main method not inside class
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectSort {
    public static class Fruit implements Comparable<Fruit> {
        public String fruitName;
        public String fruitDesc;
        public int qty;

        public  Fruit(String fruitName, String fruitDesc, int qty) {
            this.fruitName = fruitName;
            this.fruitDesc = fruitDesc;
            this.qty = qty;
        }

        //first option to sort inside class itself
        public int compareTo(Fruit fruit) {
            return this.qty - fruit.qty;
        }
    }

    public static class FruitsQtyComparator implements Comparator<Fruit> {
        @Override
        public int compare(Fruit fruit1, Fruit fruit2) {
            return fruit1.qty - fruit2.qty;
        }
    }

    public static void main(String[] args) throws Exception {
//        Fruit[] fruits = new Fruit[4];
        List<Fruit> fruits = new ArrayList<Fruit>(4);

        fruits.add(new Fruit("Orange","Orange", 50));
        fruits.add(new Fruit("Catberry","Catberry", 40));
        fruits.add(new Fruit("Banana","Banana", 30));
        fruits.add(new Fruit("Apple","Apple", 20));

        /*option1 inside class itself using compareTo we're doing so
        just use sort inbuild
         */
//        Collections.sort(fruits); //this will sort basead on qty

        /*option2 not inside class but now creating another class and implementing
        comparator interface in that and after that calling that class inside void main
        while calling we call using collection.sort also
         */
//        Collections.sort(fruits, new FruitsQtyComparator());


        /*
        Option3 directly sorting without creating any separate class for sorting with
        comparator using collections.sort and passing list and pa
        Here also don't run comparator with breakpoint and try to debug it does it's job of sorting
        But it's important: while creating like below it's imp that you must pass 2 arguments to
        compare method now, we're not creating any separate comparator class outside main for sorting
        like this
         */
        Collections.sort(fruits,
                new Comparator<Fruit>(){
                    public int compare(Fruit fruit1, Fruit fruit2){
                        return fruit1.qty-fruit2.qty;
                    }
                }
        );

        for(Fruit fruit : fruits){
            System.out.println(fruit.fruitName + " " + fruit.fruitDesc + " " + fruit.qty);
        }
    }
}
