public class LeetCode1894 {

    public int chalkReplacer(int[] chalk, int k) {
        int summ = 0;

        for (int i = 0; i < chalk.length; i++) {
            summ += chalk[i];
            if (summ > k) {
                break;
            }
        }
        k %= summ;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }

}
