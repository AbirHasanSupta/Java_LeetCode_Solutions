import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeetCode719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = Arrays.stream(nums).max().getAsInt();
        while (l < r){
            int m = (l + r) /2 ;
            int dif = dif_calc(m, nums, k);
            if(dif >= k){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }

    public int dif_calc(int dif, int[] nums, int k){
        int l = 0;
        int res = 0;
        for(int r = 0; r < nums.length; r ++){
            while (nums[r] - nums[l] > dif){
                l ++;
            }
            res += r - l;
        }
        return res;
    }
}
