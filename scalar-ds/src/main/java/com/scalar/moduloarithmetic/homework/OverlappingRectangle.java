package com.scalar.moduloarithmetic.homework;

/**
 * @author t0k02w6 on 03/02/22
 * @project scalar-ds
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Reactangle {
    Point topRight;
    Point bottomLeft;

    public Reactangle(Point topRight, Point bottomLeft) {
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }
}

public class OverlappingRectangle {
    private static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        Reactangle r1 = new Reactangle(new Point(A, B), new Point(C, D));
        Reactangle r2 = new Reactangle(new Point(E, F), new Point(G, H));

        if((r1.getTopRight().getY() < r2.getBottomLeft().getY())
            || (r1.getBottomLeft().getY() > r2.getTopRight().getY()))
            return 0;
        if((r1.getTopRight().getX() < r2.getBottomLeft().getX())
            || (r2.getTopRight().getX() < r1.getBottomLeft().getX()))
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(0,0,4,4,2,2,6,6));
        System.out.println(solve(0,0,4,4,2,2,3,3));
    }
}
