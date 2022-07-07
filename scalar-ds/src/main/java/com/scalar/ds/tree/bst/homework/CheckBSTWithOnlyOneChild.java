package com.scalar.ds.tree.bst.homework;

/**
 * @author t0k02w6 on 24/06/22
 * @project scalar
 */
public class CheckBSTWithOnlyOneChild {
    private static String solve(int[] A) {
        int root = A[0];
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;

        for(int i = 1; i < A.length; i++) {
            if(A[i] > root) {
                l = root;
            } else {
                r = root;
            }
            if(A[i] < l || A[i] > r)
                return "NO";
            root = A[i];
        }
        return "YES";
    }

    public static void main(String[] args) {
        int[] pre = {4,10,5,8};

        String ans = solve(pre);

        System.out.println(ans);

        pre = new int[] {1,5,6,4};

        ans = solve(pre);

        System.out.println(ans);
    }
}
