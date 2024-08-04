import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1508 {
        public int rangeSum(int[] nums, int n, int left, int right) {
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                for(int j = i; j < n; j ++){
                    if (i == j){
                        arr.add(nums[i]);
                    }else{
                        arr.add(arr.get(arr.size() - 1) + nums[j]);
                    }
                }
            }
            Collections.sort(arr);
            long ans = 0;
            for(int i= left - 1; i < right; i ++){
                ans += arr.get(i);
            }
            return (int) ((ans) % (Math.pow(10, 9) + 7));
        }

    public static void main(String[] args) {
        LeetCode1508 sol = new LeetCode1508();
        System.out.println(sol.rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 5));
    }
}
