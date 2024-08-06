import java.util.*;

public class LeetCode3016 {
    public int minimumPushes(String word) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < word.length(); i ++){
            hash.put(word.charAt(i), hash.getOrDefault(word.charAt(i), 0)+ 1);
        }
        List<Integer> values= new ArrayList<>(hash.values());
        Collections.sort(values, Collections.reverseOrder());

        int result = 0;
        int i = 0;
        for(int j: values){
            result += j * (1 + i / 8);
            i ++;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode3016 sol = new LeetCode3016();
        System.out.println(sol.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
