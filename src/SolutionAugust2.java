public class SolutionAugust2 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totOne = 0;
        for(int i = 0; i < n; i ++){
            if(nums[i] == 1){
                totOne ++;
            }
        }
        int l = 0;
        int windowOnes = 0;
        int maxWindowOnes = 0;
        for(int r = 0; r < 2*n; r ++){
            if(nums[r % n] == 1){
                windowOnes += 1;
            }
            if (r - l + 1 > totOne) {
                windowOnes -= nums[l % n];
                l ++;
            }
            maxWindowOnes = Math.max(maxWindowOnes, windowOnes);

        }
        return totOne - maxWindowOnes;

    }
    public static void main(String[] args){
        SolutionAugust2 sol = new SolutionAugust2();
        int ans = sol.minSwaps(new int[]{1,1,0,0,1});
        System.out.print(ans);
    }
}
