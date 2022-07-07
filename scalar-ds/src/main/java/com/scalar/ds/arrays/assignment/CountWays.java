package com.scalar.ds.arrays.assignment;

/**
 * @author t0k02w6 on 15/01/22
 * @project scalar-ds
 */
public class CountWays {
    private static int[] copyArrayExceptIndx(int[] source, int exclusionIndx) {
        int[] destination = new int[source.length - 1];
        int k = 0;
        for(int i = 0; i < source.length; i++) {
            if(i == exclusionIndx)
                continue;
            destination[k++] = source[i];
        }
        return destination;
    }

    private static int solve(int[] A) {
//        int count = 0;
//        for(int i = 0; i < A.length; i++) {
//            int[] newArray = copyArrayExceptIndx(A, i);
//            int oddIndxSum = 0;
//            int evenIndxSum = 0;
//            for(int j = 0; j < newArray.length; j++) {
//                if(j % 2 == 0) {
//                    evenIndxSum += newArray[j];
//                } else
//                    oddIndxSum += newArray[j];
//            }
//            if(oddIndxSum == evenIndxSum)
//                count++;
//        }
//        return count;

        int[] evenPrefix = new int[A.length];
        int[] oddPrefix = new int[A.length];
        evenPrefix[0] = A[0];
        oddPrefix[1] = A[1];

        for(int i = 1; i < A.length; i++) {
            if(i%2 == 0) {
                evenPrefix[i] = evenPrefix[i - 1] + A[i];
                oddPrefix[i] = oddPrefix[i - 1];
            } else {
                oddPrefix[i] = oddPrefix[i - 1] + A[i];
                evenPrefix[i] = evenPrefix[i - 1];
            }
        }


        int count = 0;
        for(int i = 0; i < A.length; i++) {
            int oddSum1 = 0;
            int evenSum1 = 0;
            if(i > 0) {
                oddSum1 = oddPrefix[i - 1];
                evenSum1 = evenPrefix[i - 1];
            }
            int oddSum2 = evenPrefix[A.length - 1] - evenPrefix[i];
            int evenSum2 = oddPrefix[A.length - 1] - oddPrefix[i];

            if(oddSum1 + oddSum2 == evenSum1 + evenSum2)
                count++;
        }

        return count;
    }



    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,1,6,4}));
        System.out.println(solve(new int[]{1,1,1}));
    }
}
