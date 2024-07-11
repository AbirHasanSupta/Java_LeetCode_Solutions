//public class Solution {
//    public double averageWaitingTime(int[][] customers) {
//        double res = 0;
//        int curr = 0;
//        for(int i = 0; i < customers.length; i++){
//            if (curr < customers[i][0]){
//                curr = customers[i][0] + customers[i][1];
//                res += (curr - customers[i][0]);
//                System.out.println("if"+res + " "+curr);
//            }else{
//                curr += customers[i][1];
//                res += curr - customers[i][0];
//                System.out.println("else"+res +" " + curr);
//            }
//        }
//        return res / customers.length;
//
//    }
//}

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> pair = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                int x = stack.pop();
                pair.put(x, i);
                pair.put(i, x);
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        int dir = 1;
        while(i < s.length()){
            if(s.charAt(i) == ')' || s.charAt(i) == '('){
                i = pair.get(i);
                dir = dir * -1;

            }else{
                res.append(s.charAt(i));
            }
            i += dir;
        }
        return res.toString();

    }
}