import java.util.List;

class LeetCode624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int curMax = arrays.getFirst().getLast();
        int curMin = arrays.getFirst().getFirst();
        int result = 0;

        for(int i = 1; i < arrays.size(); i ++){
            List<Integer> arr = arrays.get(i);
            result = Math.max(result, Math.max( curMax - arr.getFirst(), arr.getLast() - curMin));
            curMax = Math.max(curMax, arr.getLast());
            curMin = Math.min(curMin, arr.getFirst());
        }
        return result;
    }
}