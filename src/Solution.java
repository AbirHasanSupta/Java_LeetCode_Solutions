public class Solution {
    public double averageWaitingTime(int[][] customers) {
        double res = 0;
        int curr = 0;
        for(int i = 0; i < customers.length; i++){
            if (curr < customers[i][0]){
                curr = customers[i][0] + customers[i][1];
                res += (curr - customers[i][0]);
                System.out.println("if"+res + " "+curr);
            }else{
                curr += customers[i][1];
                res += curr - customers[i][0];
                System.out.println("else"+res +" " + curr);
            }
        }
        return res / customers.length;

    }
}

