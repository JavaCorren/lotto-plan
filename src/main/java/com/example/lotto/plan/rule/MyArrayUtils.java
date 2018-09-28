package com.example.lotto.plan.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangGR
 * @created on 2018/9/27
 **/
public class MyArrayUtils {
    
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null) {return null;}

        ArrayList<Integer> integerList = new ArrayList<>();

        while(listNode.next != null) {
            integerList.add(listNode.val);
            listNode = listNode.next;
        }

        int size = integerList.size();

        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = integerList.get(i);
        }

        reverseIntArray(array);
        integerList.clear();

        for(int i = 0; i < size; i++) {
            integerList.add(array[i]);
        }

        return integerList;
    }

    public int[] reverseIntArray(int[] array) {

        int length = array.length;

        int mid = length/2;

        if (mid > 0) {

            for (int i = 0; i < mid; i++) {

                int temp ;

                temp = array[i];

                array[i] = array[length - (i+1)];
                array[length - (i+1)] = temp;
            }
        }

        return array;
    }


}
