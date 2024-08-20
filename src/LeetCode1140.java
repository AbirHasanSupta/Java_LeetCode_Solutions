import java.util.HashMap;
import java.util.Map;

public class LeetCode1140 {
    public int stoneGameII(int[] piles) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(true, 0, 1, piles, cache);
    }
    public int dfs(boolean a, int i, int m, int[] piles, Map<String, Integer> cache){
        if (i == piles.length){
            return 0;
        }
        String key = a + "," + i + "," + m;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int res = 0;
        if(a == true){
            res = 0;
        }else{
            res = Integer.MAX_VALUE;
        }
        int tot = 0;
        for(int x = 1; x <= 2*m; x++){
            if(i + x > piles.length){
                break;
            }
            tot += piles[i + x - 1];
            if (a == true){
                res = Math.max(res, tot + dfs(!a, i + x, Math.max(m,x), piles,cache));
            }else{
                res = Math.min(res, dfs(!a, i + x, Math.max(m, x), piles,cache));
            }
        }
        cache.put(key, res);
        return res;
    }
}
