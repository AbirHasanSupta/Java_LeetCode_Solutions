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

//class Solution {
//    public String reverseParentheses(String s) {
//        HashMap<Integer, Integer> pair = new HashMap<>();
//        Stack<Integer> stack = new Stack<>();
//        for(int i = 0; i < s.length(); i ++){
//            if(s.charAt(i) == '('){
//                stack.push(i);
//            }else if(s.charAt(i) == ')'){
//                int j = stack.pop();
//                pair.put(i, j);
//                pair.put(j, i);
//            }
//        }
//
//        StringBuilder res = new StringBuilder();
//        int i = 0;
//        int direction = 1;
//        while(i < s.length()){
//            if(s.charAt(i) == '(' || s.charAt(i) == ')') {
//                direction *= -1;
//                i = pair.get(i);
//
//            }else{
//                res.append(s.charAt(i));
//            }
//            i += direction;
//        }
//        return res.toString();
//    }
//}


class Solution {
    public int maximumGain(String s, int x, int y) {
        class Helper {
            int helper(String pair, int score, StringBuilder s) {
                StringBuilder stack = new StringBuilder();
                int res = 0;
                for (char c : s.toString().toCharArray()) {
                    if (c == pair.charAt(1) && !stack.isEmpty() && stack.charAt(stack.length() - 1) == pair.charAt(0)) {
                        stack.setLength(stack.length() - 1);
                        res += score;
                    } else {
                        stack.append(c);
                    }
                }
                s.setLength(0);
                s.append(stack);
                return res;
            }
        }

        Helper helper = new Helper();
        String pair = x > y ? "ab" : "ba";
        StringBuilder sBuilder = new StringBuilder(s);
        int result = 0;

        result += helper.helper(pair, Math.max(x, y), sBuilder);
        result += helper.helper(new StringBuilder(pair).reverse().toString(), Math.min(x, y), sBuilder);
        return result;
    }
}
