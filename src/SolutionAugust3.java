import java.util.HashMap;

public class SolutionAugust3 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i: target){
            if(!hash.containsKey(i)){
                hash.put(i, 1);
            }else{
                hash.put(i, hash.get(i) + 1);
            }
        }
        for(int i: arr){
            if(!hash.containsKey(i)){
                return false;
            }else{
                hash.put(i, hash.get(i) -1);
                if(hash.get(i) == 0){
                    hash.remove(i);
                }
            }
        }
        if(hash.keySet().isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        SolutionAugust3 sol = new SolutionAugust3();
        boolean ans = sol.canBeEqual(new int[] {3,7,9, 11, 9}, new int[] {3,7,11, 9});
        System.out.print(ans);
    }
}
