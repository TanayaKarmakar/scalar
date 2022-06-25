package com.scalar.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/06/22
 * @project scalar
 */
public class DecryptString {
    private static boolean isDigit(char ch) {
        try {
            Integer.parseInt(ch + "");
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static char kThCharAfterDecrypt(String str, int k) {
        Queue<String> txtQ = new LinkedList<>();
        StringBuilder sb = null;

        for(int i = 0; i < str.length(); ) {
            sb = new StringBuilder();
            while(i < str.length()) {
                char ch = str.charAt(i);
                if(!isDigit(ch)) {
                    sb.append(ch);
                } else {
                    break;
                }
                i++;
            }

            Integer num = Integer.parseInt(str.charAt(i) + "");
            i++;
            String newStr = sb.toString();
            sb = new StringBuilder();

            while(!txtQ.isEmpty()) {
                sb.append(txtQ.poll());
            }
            sb.append(newStr);

            newStr = sb.toString();

            sb = new StringBuilder();

            while(num > 0) {
                sb.append(newStr);
                num--;
            }

            txtQ.add(sb.toString());
        }

        String resultStr = txtQ.poll();
        System.out.println("Result String - " + resultStr);

        return resultStr.charAt(k);
    }

    public static void main(String[] args) {
        String str = "ab3c5";
        int k = 5;

        System.out.println(kThCharAfterDecrypt(str, k));
    }
}
