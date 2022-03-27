package com.scalar.arrays.advanced;

/**
 * @author t0k02w6 on 26/03/22
 * @project scalar
 */
public class FirstMissingNaturalNumber {
    private static int findMissingNumber1(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                nums[i] = (n + 1);
            }
        }

        for(int i = 0; i < n; i++) {
            int k = Math.abs(nums[i]);
            if((k - 1) < n && nums[k - 1] > 0) {
                nums[k - 1] = -nums[k - 1];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0)
                return (i + 1);
        }
        return (n + 1);
    }

    private static int findMissingNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n) {
                if(nums[i] == (i + 1))
                    break;
                else {
                    int tmp = nums[i];
                    int indx = Math.abs(nums[i] - 1);
                    nums[i] = nums[indx];
                    nums[indx] = tmp;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1))
                return (i + 1);
        }
        return (n + 1);
    }

    public static void main(String[] args) {
        int[] nums = {-8,-7,-6};

        int ans = findMissingNumber1(nums);

        System.out.println(ans);

        nums = new int[] {3, 4, -1, 1};

        ans = findMissingNumber1(nums);

        System.out.println(ans);

        nums = new int[] {2, 3, 1, 2};

        ans = findMissingNumber1(nums);

        System.out.println(ans);
    }
}
