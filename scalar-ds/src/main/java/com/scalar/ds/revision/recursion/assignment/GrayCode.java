package com.scalar.ds.revision.recursion.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author t0k02w6 on 28/08/22
 * @project scalar-ds
 */
public class GrayCode {
    private static ArrayList<Integer> grayCode(int a) {
        List<String> list = grayCodeRec(a);
        return (ArrayList<Integer>) list.stream().map(item -> Integer.parseInt(item, 2))
                .collect(Collectors.toList());
    }

    private static List<String> grayCodeRec(int a) {
        if(a == 1) {
            List<String > result = new ArrayList<>();
            result.add("0");
            result.add("1");
            return result;
        }
        List<String > smallList = grayCodeRec(a - 1);
        List<String> largeList = new ArrayList<>();
        for(String item: smallList) {
            largeList.add("0" + item);
        }

        for(int i = smallList.size() - 1; i >= 0; i--) {
            largeList.add("1" + smallList.get(i));
        }

        return largeList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> result = grayCode(n);

        System.out.println(result);

        scanner.close();
    }
}
