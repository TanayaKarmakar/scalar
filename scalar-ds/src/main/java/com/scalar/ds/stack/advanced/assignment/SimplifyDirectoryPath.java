package com.scalar.ds.stack.advanced.assignment;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class SimplifyDirectoryPath {
    private static String simplifyPath(String A) {
        String[] str = A.split("/+");

        Stack<String> stack = new Stack<>();
        for(String token: str) {
            if(token.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else if(token.equals(".") || token.equals(""))
                continue;
            else
                stack.push(token);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");


        if(!stack.isEmpty()) {
            Iterator<String> sItr = stack.iterator();
            while(sItr.hasNext()) {
                sb.append(sItr.next());
                sb.append("/");
            }
        }

        String ans = sb.toString().substring(0, sb.length() - 1);;

        if(ans.isEmpty())
            ans = "/";
        return ans;
    }

    public static void main(String[] args) {
        String str = "/a/./b/../../c/";

        String ans = simplifyPath(str);

        System.out.println(ans);
    }
}
