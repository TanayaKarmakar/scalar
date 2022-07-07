package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 04/06/22
 * @project scalar
 */
public class AddTwoNumbersAsList {
    private static ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(A == null)
            return B;
        if(B == null)
            return A;
        ListNode t1 = A;
        ListNode t2 = B;

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode t3 = result;

        int carry = 0;
        while(t1 != null && t2 != null) {
            int sum = t1.val + t2.val;
            if(carry > 0) {
                sum += carry;
            }
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            t3.next = newNode;
            t3 = t3.next;

            t1 = t1.next;
            t2 = t2.next;
        }

        while(t1 != null) {
            int sum = t1.val;
            if(carry > 0) {
                sum += carry;
            }
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            t3.next = newNode;
            t3 = t3.next;
            t1 = t1.next;
        }

        while(t2 != null) {
            int sum = t2.val;
            if(carry > 0) {
                sum += carry;
            }
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            t3.next = newNode;
            t3 = t3.next;
            t2 = t2.next;
        }

        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            t3.next = newNode;
        }
        result = result.next;
        return result;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(9);
        h1.next = new ListNode(9);
        h1.next.next = new ListNode(1);

        ListNode h2 = new ListNode(1);

        ListNode h3 = addTwoNumbers(h1, h2);

        ListUtil.printLL(h3);
    }
}
