package com.scalar.linkedlist.assignment;

import com.scalar.common.ListNode;

/**
 * @author t0k02w6 on 23/02/22
 * @project scalar
 */
public class DesignLinkedList {
    public static ListNode head;

    private static ListNode solve(int[][] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            int[] currentOp = A[i];
            ListNode newNode = new ListNode(currentOp[1]);
            if(currentOp[0] == 0) {
                if(head == null) {
                    head = newNode;
                } else {
                    newNode.next = head;
                    head = newNode;
                }
            } else if(currentOp[0] == 1) {
                if(head == null) {
                    head = new ListNode(currentOp[1]);
                    continue;
                }
                ListNode tmp = head;
                while(tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = newNode;
            } else if(currentOp[0] == 2) {
                int position = currentOp[2];
                if(position == 0) {
                    newNode.next = head;
                    head = newNode;
                    continue;
                }
                ListNode tmp = head;
                ListNode prev = null;
                int count = 0;
                while(tmp != null) {
                    if(count == position) {
                        newNode.next = tmp.next;
                        prev.next = newNode;
                        break;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                    count++;
                }
            } else {
                int position = currentOp[2];
                if(position == 0) {
                    if(head != null)
                        head = head.next;
                    continue;
                }
                ListNode prev = null;
                ListNode tmp = head;
                int count = 0;
                while(tmp != null) {
                    if(count == position) {
                        prev.next = tmp.next;
                        break;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                    count++;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        int[][] A = {{2, 18, 0},
//        {2, 5, 1},
//        {2, 8, 0},
//        {1, 7, -1},
//        {1, 5, -1},
////        {1, 12, -1},
////        {3, 0, -1},
////        {1, 19, -1},
////        {1, 13, -1},
////        {3, 0, -1},
////        {0, 12, -1},
////        {1, 13, -1},
////        {3, 2, -1}
//        };
//
//        head = solve(A);

        System.out.println("next testcase");

        int[][] A = new int[][]{
                  {2, 6, 0},
        {1, 17, -1},
        {1, 19, -1},
        {2, 16, 1},
        {1, 13, -1},
        {3, 3, -1},
        {1, 19, -1}
        };

        head = null;
        head = solve(A);

        ListNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
