package com.example.lotto.plan.rule;

import java.util.Stack;

/**
 * @author ZhangGR
 * @created on 2018/9/27
 **/
public class Solution {

    public static boolean find(int target, int [][] array) {

        boolean found = false;

        int rows = array.length;
        //行列值为0，则返回错误
        if (rows ==0) {return found;}

        int cols = array[0].length;
        //行列值为0，则返回错误
        if (cols ==0) {return found;}

        int posR = 0;

        //当数组每行最后一个值都比目标值小，则跳到下一行判断
        while(array[posR][cols - 1] < target) {
            posR++;

            //需要判断行是否到底，到底都比目标值小，则肯定不存在
            if(posR == rows) {return found;}
        }

        //接下来：当数组每行最后一个值开始比目标值大的时候，判断每行第一个值是否小于等于target
        while(array[posR][0] <= target) {

            //遍历该行所有元素
            for(int i = 0; i < cols; i++) {

                //若发现与target值相等
                if(array[posR][i] == target) {

                    //则修改found为true
                    found = true;
                }

                //若found值为true，跳出当前循环
                if(found) {
                    break;
                }
            }

            //若已经发现等值元素，则不再遍历行
            if(found) {
                break;
            } else {

                //若未发现则将行指针+1
                posR++;

                //若行指针到该数组的行底，则结束
                if (posR == rows) {
                    break;
                }
            }
        }

        return found;

    }

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s+","%20");
    }

//    public static void main(String[] args) {
//
//        int[][] array = {
//                {1,2,8,9},
//                {2,4,8,12},
//                {4,7,10,13},
//                {6,8,11,15}
//        };
//
//        int target = 16;
//
//        System.out.println(find(target, array));
//        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
//    }

}
