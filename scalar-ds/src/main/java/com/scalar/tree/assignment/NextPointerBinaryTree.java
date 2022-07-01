package com.scalar.tree.assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class NextPointerBinaryTree {
    static class TreeLinkNode {
       int val;
       TreeLinkNode left, right, next;
       TreeLinkNode(int x) { val = x; }
   }

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.size() > 1) {
            TreeLinkNode node = q.poll();
            if(node == null) {
                q.add(null);
                continue;
            }
            if(q.peek() != null)
                node.next = q.peek();
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
    }

    public static void main(String[] args) {


    }
}
