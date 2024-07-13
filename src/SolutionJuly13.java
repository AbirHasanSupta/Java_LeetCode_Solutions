import java.util.*;


public class SolutionJuly13 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < positions.length; i ++){
            index.put(positions[i], i);
        }
        Arrays.sort(positions);
        Stack<Integer> stack = new Stack<>();
        for(int p: positions){
            int i = index.get(p);
            if(directions.charAt(i) == 'R'){
                stack.add(i);
            }else{
                while(!stack.isEmpty() && healths[i]>0){
                    int x = stack.pop();
                    if(healths[x] > healths[i]){
                        healths[x] -= 1;
                        healths[i] = 0;
                        stack.add(x);
                    }else if(healths[i] > healths[x]){
                        healths[i] -= 1;
                        healths[x] = 0;
                    }else{
                        healths[i] = 0;
                        healths[x] = 0;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i: healths){
            if(i > 0){
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args){
        SolutionJuly13 sol = new SolutionJuly13();
        System.out.println(sol.survivedRobotsHealths(new int[] {5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR"));
    }

}
