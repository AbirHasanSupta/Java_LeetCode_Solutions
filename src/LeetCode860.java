class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int tens = 0;
        int fives = 0;

        for (int i : bills) {
            if (i == 5) {
                fives += 1;
            } else if (i == 10) {
                tens += 1;
                int change = (i / 5) - 1;
                if (change > fives) {
                    return false;
                } else {
                    fives -= change;
                }
            } else {
                if (tens > 0) {
                    tens -= 1;
                    if (fives > 0) {
                        fives -= 1;
                    } else {
                        return false;
                    }
                } else {
                    int change = (i / 5) - 1;
                    if (change > fives) {
                        return false;
                    } else {
                        fives -= change;
                    }
                }
            }
        }
        return true;
    }

}