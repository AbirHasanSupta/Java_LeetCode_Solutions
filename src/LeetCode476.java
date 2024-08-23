public class LeetCode476{
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder res = new StringBuilder();

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                res.append('0');
            } else {
                res.append('1');
            }
        }
        return Integer.parseInt(res.toString(), 2);
    }
}