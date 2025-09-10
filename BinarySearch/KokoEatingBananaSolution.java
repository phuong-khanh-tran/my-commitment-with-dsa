import java.util.Arrays;

class KokoEatingBananaSolution {
    public int kokoEatingBanana(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int min = 1;
        int res = max;

        while (min <= max) {
            int mid = (min + max) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (int) Math.ceil((double) pile / mid);
            }
            if (hours <= h) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }
}