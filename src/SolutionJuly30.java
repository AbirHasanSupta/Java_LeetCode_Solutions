public class SolutionJuly30 {
    public int minimumDeletions(String s) {
        int aCount = 0;
        int bCount = 0;
        int res = s.length();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'a'){
                aCount += 1;
            }
        }

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'a'){
                aCount --;
            }
            res = Math.min(res, bCount + aCount);
            if(s.charAt(i) == 'b'){
                bCount ++;
            }
        }
        return res;

    }

    public static void main(String[] args){
        String s = "aababbab";
        SolutionJuly30 sol = new SolutionJuly30();
        System.out.println(sol.minimumDeletions(s));
    }
}

