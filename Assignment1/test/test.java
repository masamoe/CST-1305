package Assignment1.test;

import org.junit.Test;

import Assignment1.ArrayList;
import Assignment1.LinkedList;

public class test {
    @Test
    public void test() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
            list2.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list1.remove(i);
            list2.remove(i);
        }
        System.out.println(list1.getCurrentSize());
        System.out.println(list2.getCurrentSize());
    }
}