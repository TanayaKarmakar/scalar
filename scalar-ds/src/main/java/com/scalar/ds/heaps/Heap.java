package com.scalar.ds.heaps;

/**
 * @author t0k02w6 on 08/07/22
 * @project scalar
 */
public class Heap {
    private static int size = 0;

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void heapify(int[] nums) {
        int i = 0;
        int lastIndx = (size - 1) / 2;
        while(i <= lastIndx) {
            int leftIndx = 2 * i + 1;
            int rightIndx = 2 * i + 2;
            if(leftIndx <= size && nums[leftIndx] < nums[rightIndx]) {
                swap(nums, i, leftIndx);
                i = leftIndx;
            } else {
                swap(nums, i, rightIndx);
                i = rightIndx;
            }
        }
    }

    private static void delete(int[] nums) {
        swap(nums, 0, size);
        int min = nums[size];
        size--;
        heapify(nums);
        System.out.println("Deleted Element - " + min);
    }

    public static void main(String[] args) {
        int[] heap = {2,4,5,11,6,7,8,20,12};
        size = heap.length - 1;

        delete(heap);

        for(int i = 0; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
