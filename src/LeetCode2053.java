import java.util.HashMap;
import java.util.Map;

public class LeetCode2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < arr.length; i ++){
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        for(String s: arr){
            if(hash.get(s) == 1){
                k --;
            }
            if(k ==0){
                return s;
            }
        }
        return "";
    }
    public static void main(String[] args) {
        LeetCode2053 sol = new LeetCode2053();
        System.out.println(sol.kthDistinct(new String[] {"d","b","c","b","c","a"}, 2));
    }
}
