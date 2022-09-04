package com.scalar.ds.revision.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 26/08/22
 * @project scalar-ds
 */
public class GrayCode {
    private static List<String> grayCode(int n) {
        if(n == 0)
            return new ArrayList<>();
        if(n == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        List<String> smallList = grayCode(n - 1);
        List<String> bigList = new ArrayList<>();
        for(String str: smallList) {
            bigList.add("0" + str);
        }

        List<String> newList = new ArrayList<>(smallList);
        Collections.reverse(newList);
        for(String str: newList) {
            bigList.add("1" + str);
        }
        return bigList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> res = grayCode(n);

        System.out.println(res);

        scanner.close();
    }
}
