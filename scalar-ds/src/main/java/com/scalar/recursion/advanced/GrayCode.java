package com.scalar.recursion.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 20/04/22
 * @project scalar
 */
public class GrayCode {
    private static List<Integer> grayCode(int n) {
        List<String> grayCodeStr = grayCodeRec(n);
        List<Integer> result = new ArrayList<>();
        for(String str: grayCodeStr) {
            result.add(Integer.parseInt(str, 2));
        }
        return result;
    }

    private static List<String> grayCodeRec(int n) {
        if(n == 1) {
            List<String> str = new ArrayList<>();
            str.add("0");
            str.add("1");
            return str;
        }
        List<String> smallerList = grayCodeRec(n - 1);
        List<String> biggerList = new ArrayList<>();
        for(String currentItem: smallerList) {
            String newItem = "0" + currentItem;
            biggerList.add(newItem);
        }

        for(int i = smallerList.size() - 1; i >= 0; i--) {
            String newItem = "1" + smallerList.get(i);
            biggerList.add(newItem);
        }
        return biggerList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> result = grayCode(n);
        System.out.println(result);
        scanner.close();
    }
}
