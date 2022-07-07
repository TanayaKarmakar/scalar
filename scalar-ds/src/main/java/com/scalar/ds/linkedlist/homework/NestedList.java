package com.scalar.ds.linkedlist.homework;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 23/02/22
 * @project scalar
 */
class NestedInteger {
    ArrayList<NestedInteger> ni = new ArrayList<>();

    NestedInteger(int x) {
        ni.add(new NestedInteger(x));
    }

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger() {
        return ni.size() == 1;
    }

    // Return the single integer that this NestedInteger holds, if it holds a single integer.
    // The result is 1e9 if this NestedInteger holds a nested list.
    int getInteger() {
        return ni.get(0).getInteger();
    }

    // Return the nested list that this NestedInteger holds, if it holds a nested list.
    // The result is an empty ArrayList if this NestedInteger holds a single integer.
    ArrayList<NestedInteger> getList() {
        return ni;
    }
}

class NestedIterator {
    ArrayList<NestedInteger> flatList;
    int count = 0;

    NestedIterator(ArrayList<NestedInteger> nestedList) {
        flatList = new ArrayList<>();
        flatList(nestedList, 0, flatList);
    }

    void flatList(ArrayList<NestedInteger> nestedList, int indx, ArrayList<NestedInteger> finalList) {
        for(NestedInteger ni: nestedList) {
            if(ni.isInteger()) {
                finalList.add(new NestedInteger(ni.getInteger()));
            }
            else {
                flatList(ni.getList(), 0, finalList);
            }
        }
    }

    int next() {
        return flatList.get(count).getInteger();
    }

    boolean hasNext() {
        return ++count < flatList.size();
    }
}

public class NestedList {
    public static void main(String[] args) {
        ArrayList<NestedInteger> ni = new ArrayList<>();
        NestedInteger part1 = new NestedInteger(1);
    }
}
