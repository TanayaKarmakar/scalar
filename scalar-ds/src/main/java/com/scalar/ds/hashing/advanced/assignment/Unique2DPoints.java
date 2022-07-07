package com.scalar.ds.hashing.advanced.assignment;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author t0k02w6 on 14/05/22
 * @project scalar
 */
class Item {
    private int x;
    private int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return x == item.x && y == item.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Unique2DPoints {
    private static int solve(int[][] A) {
        Set<Item> set = new HashSet<>();
        for(int i = 0; i < A.length; i++) {
            set.add(new Item(A[i][0], A[i][1]));
        }
        return set.size();
    }

    public static void main(String[] args) {

    }
}
