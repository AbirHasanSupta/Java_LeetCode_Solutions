import java.util.*;

public class Solutionjuly14 {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                i++;
                String count = "";
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count += formula.charAt(i);
                    i++;
                }
                int result = count.isEmpty() ? 1 : Integer.parseInt(count);
                HashMap<String, Integer> curr_map = stack.pop();
                HashMap<String, Integer> prev_map = stack.peek();
                for (String elem : curr_map.keySet()) {
                    prev_map.put(elem, prev_map.getOrDefault(elem, 0) + curr_map.get(elem) * result);
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formula.charAt(i));
                i++;
                if (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i));
                    i++;
                }
                StringBuilder count = new StringBuilder();
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count.append(formula.charAt(i));
                    i++;
                }
                int elemCount = count.length() == 0 ? 1 : Integer.parseInt(count.toString());
                HashMap<String, Integer> curr_map = stack.peek();
                curr_map.put(element.toString(), curr_map.getOrDefault(element.toString(), 0) + elemCount);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder result = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            result.append(key);
            int count = sortedMap.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solutionjuly14 sol = new Solutionjuly14();
        System.out.println(sol.countOfAtoms("K4(ON(SO3)2)2"));
    }
}
