package com.scalar.strings.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 20/05/22
 * @project scalar-ds
 */
public class RearrangeStringSuchThatNoBoringString {
    private static String getString(List<Character> oddParity, List<Character> evenParity) {
        char minOdd = oddParity.get(0);
        char maxOdd = oddParity.get(0);
        char minEven = evenParity.get(0);
        char maxEven = evenParity.get(0);
        int minOddIndx = 0;
        int maxOddIndx = 0;
        int minEvenIndx = 0;
        int maxEvenIndx = 0;
        for(int i = 1; i < oddParity.size(); i++) {
            if(oddParity.get(i) < minOdd) {
                minOdd = oddParity.get(i);
                minOddIndx = i;
            }
            if(oddParity.get(i) > maxOdd) {
                maxOdd = oddParity.get(i);
                maxOddIndx = i;
            }
        }

        for(int i = 1; i < evenParity.size(); i++) {
            if(evenParity.get(i) < minEven) {
                minEven = evenParity.get(i);
                minEvenIndx = i;
            }
            if(evenParity.get(i) > maxEven) {
                maxEven = evenParity.get(i);
                maxEvenIndx = i;
            }
        }

        if(Math.abs(minOdd - maxEven) == 1 && Math.abs(maxOdd - minEven) == 1)
            return "";
        if(Math.abs(minOdd - maxEven) > 1) {
            oddParity.remove(minOddIndx);
            evenParity.remove(maxEvenIndx);
            return minOdd + "" + maxEven;
        }
        else {
            oddParity.remove(maxOddIndx);
            evenParity.remove(minEvenIndx);
            return maxOdd + "" + minEven;
        }
    }

    private static String rearrange(String str) {
        List<Character> evenParity = new ArrayList<>();
        List<Character> oddParity = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch % 2 == 0) {
                evenParity.add(ch);
            } else {
                oddParity.add(ch);
            }
        }

        String middle = getString(oddParity, evenParity);
        if(middle.isEmpty())
            return "";
        StringBuilder first = new StringBuilder();
        for(char currentEven: evenParity) {
            first.append(currentEven);
        }

        first.append(middle);

        for(char currentOdd: oddParity) {
            first.append(currentOdd);
        }

        return first.toString();

        /*char ch = evenParity.get(0);
        StringBuilder middle = new StringBuilder();

        for(char currentOddChar: oddParity) {
            if(Math.abs(currentOddChar - ch) > 1) {
                middle.append(ch);
                middle.append(currentOddChar);
                oddParity.remove(currentOddChar);
                break;
            }
        }
        if(middle.toString().isEmpty()) {
            middle.append(ch);
        }
        evenParity.remove(0);

        StringBuilder first = new StringBuilder();
        for(char currentEvenChar: evenParity) {
            first.append(currentEvenChar);
        }
        first.append(middle);

        StringBuilder last = new StringBuilder();
        for(char currentOddChar: oddParity) {
            last.append(currentOddChar);
        }
        first.append(last);
        return first.toString();*/
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(rearrange(str));

        scanner.close();
    }
}
