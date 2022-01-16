package com.scalar.arrays.assignment;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 14/01/22
 * @project scalar-ds
 */
public class PickFromBothSides {
    private static int solve(ArrayList<Integer> A, int B) {
        if(A.isEmpty() || A.size() < B)
            return Integer.MAX_VALUE;

        int B2 = B;
        int sum = 0;
        int ans = 0;
        int n = A.size();
        int i = 0, j = n - 1;
        while(B > 0) {
            sum += A.get(i);
            i++;
            B--;
        }

        ans = sum;
        while(B2 > 0) {
            sum -= A.get(--i);
            sum += A.get(j);
            ans = Integer.max(ans, sum);
            j--;
            B2--;
        }
        return ans;
//        int n = A.size();
//       int[] prefixFront = new int[n];
//       int[] prefixRear = new int[n];
//
//       prefixFront[0] = A.get(0);
//       prefixRear[n - 1] = A.get(n - 1);
//
//       for(int i = 1; i < n; i++) {
//           prefixFront[i] = prefixFront[i - 1] + A.get(i);
//           prefixRear[n - i - 1] = prefixRear[n - i] + A.get(n - i - 1);
//       }
//
//       int leftIndx = B;
//       int rightIndx = n;
//       int max = Integer.MIN_VALUE;
//
//       int left = 0;
//       int right = 0;
//       while(leftIndx > 0) {
//           left = prefixFront[leftIndx - 1];
//           if(rightIndx < n)
//               right = prefixRear[rightIndx];
//           max = Integer.max(max, left + right);
//           leftIndx--;
//           rightIndx--;
//       }
//       max = Integer.max(max, left + right);
//       return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-584, -714, -895, -512, -718, -545, 734, -886, 701, 316, -329, 786, -737, -687, -645, 185, -947, -88, -192, 832, -55, -687, 756, -679, 558, 646, 982, -519, -856, 196, -778, 129, -839, 535, -550, 173, -534, -956, 659, -708, -561, 253, -976, -846, 510, -255, -351, 186, -687, -526, -978, -832, -982, -213, 905, 958, 391, -798, 625, -523, -586, 314, 824, 334, 874, -628, -841, 833, -930, 487, -703, 518, -823, 773, -730, 763, -332, 192, 985, 102, -520, 213, 627, -198, -901, -473, -375, 543, 924, 23, 972, 61, -819, 3, 432, 505, 593, -275, 31, -508, -858, 222, 286, 64, 900, 187, -640, -587, -26, -730, 170, -765, -167, 711, 760, -104, -333};
        int B = 32;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        int ans = solve(list, B);

        System.out.println(ans);

        System.out.println(nums.length);

    }
}
