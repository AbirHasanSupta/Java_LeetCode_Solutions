public class SolutionJuly29 {
    public int numTeams(int[] rating) {
        int res = 0;


        for(int m = 1; m < rating.length - 1; m ++){
            int left = 0;
            int right = 0;
            for(int i = 0; i < m; i ++){
                if (rating[i] < rating[m]){
                    left ++;
                }
            }
            for(int i = m + 1; i < rating.length; i ++){
                if(rating[i] > rating[m]){
                    right ++;
                }
            }
            res += left * right;
            res += (m - left) * (rating.length - m - 1 - right);
        }
        return res;

    }
    public static void main(String[] args){
        SolutionJuly29 sol = new SolutionJuly29();
        System.out.println(sol.numTeams(new int[]{2,5,3,4,1}));
    }
}
