package com.scalar.recursion.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 20/04/22
 * @project scalar
 */
public class GenerateSequence {
    private static int getValue(int n, int k) {
        if(k == 0)
            return 0;
        int parentNode = getValue(n - 1, k /2);
        if(k % 2 == 0)
            return parentNode;
        else
            return (1 - parentNode);
    }


    private static char genSequence(int n, int k) {
        List<String> list = new ArrayList<>();
        list.add("0");

        for(int i = 1; i < n; i++) {
            String prev = list.get(i - 1);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < prev.length(); j++) {
                if(prev.charAt(j) == '0')
                    sb.append("01");
                else
                    sb.append("10");
            }
            list.add(sb.toString());
        }

        return list.get(n - 1).charAt(k - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        char ans = genSequence(n, k);

        System.out.println(ans);

        scanner.close();
    }
}
