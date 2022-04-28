package com.scalar.sorting.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 27/04/22
 * @project scalar
 */

//Given an array of size n, sort the array
    // given - all the even valued elements are sorted
    // all the odd valued elements are sorted
public class SortArrayOddEven {
    private static int[] sortTheArray(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        int m = even.size();
        int n = odd.size();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n) {
            if(even.get(i) < odd.get(j)) {
                nums[k++] = even.get(i);
                i++;
            } else {
                nums[k++] = odd.get(j);
                j++;
            }
        }

        while(i < m) {
            nums[k++] = even.get(i++);
        }

        while(j < n) {
            nums[k++] = odd.get(j++);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,2,4,12,15,16};

        nums = sortTheArray(nums);

        System.out.println(Arrays.toString(nums));
    }
}
