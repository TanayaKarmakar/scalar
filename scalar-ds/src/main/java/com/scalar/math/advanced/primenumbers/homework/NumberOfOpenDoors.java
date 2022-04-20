package com.scalar.math.advanced.primenumbers.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class NumberOfOpenDoors {
    private static int solve(int A) {
        boolean[] isOpen = new boolean[A + 1];
        int countOpen = 0;
        for(int i = 1; i <= A; i++) {
            isOpen[i] = !isOpen[i];
            if(isOpen[i]) {
                countOpen++;
            } else {
                countOpen--;
            }
            for(int j = 2 * i; j <= A; j += i) {
                isOpen[j] = !isOpen[j];
                if(isOpen[j]) {
                    countOpen++;
                } else {
                    countOpen--;
                }
            }
        }

        return countOpen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = solve(n);

        System.out.println(ans);
        scanner.close();
    }
}
