package com.scalar.strings;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class ChangeCaseOfCharacters {
    private static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private static String modifyString(String s) {
        char[] sArr = s.toCharArray();

        for(int i = 0; i < sArr.length; i++) {
            if(isLowerCase(sArr[i])) {
                sArr[i] = (char)(sArr[i] - 32);
            } else {
                sArr[i] = (char)(sArr[i] + 32);
            }
        }

        return new String(sArr);
    }

    public static void main(String[] args) {
        String str = "Tanaya";

        System.out.println(modifyString(str));
    }
}
