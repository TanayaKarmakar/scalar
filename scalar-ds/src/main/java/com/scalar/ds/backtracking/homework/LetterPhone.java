package com.scalar.ds.backtracking.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 19/07/22
 * @project scalar
 */
public class LetterPhone {
    private static Map<Integer, String> map;

    private static void initMap() {
        map = new HashMap<>();
        map.put(0,"0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    private static ArrayList<String> letterCombinations(String A) {
        initMap();
        ArrayList<String> result = letterCombinationsRec(A, 0);
        return result;
    }

    private static ArrayList<String> letterCombinationsRec(String a, int indx) {
        if(indx == a.length()) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        ArrayList<String> smallList = letterCombinationsRec(a, indx + 1);
        int currentVal = Integer.parseInt(a.charAt(indx) + "");
        String value = map.get(currentVal);
        ArrayList<String> bigList = new ArrayList<>();
        for(int i = 0; i < value.length(); i++) {
            for(String el: smallList) {
                bigList.add(value.charAt(i) + el);
            }
        }
        return bigList;
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> list = letterCombinations(str);
        System.out.println(list);
    }
}
