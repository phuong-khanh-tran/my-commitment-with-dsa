import java.util.HashMap;
import java.util.Map;

public class LongestRepeatCharacterReplaceSolution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequent = new HashMap<>();
        int l = 0;
        int res = 0;
        int maxCount = 0;
        for (int r = 0; r < s.length(); r++) {
            frequent.put(s.charAt(r), frequent.getOrDefault(s.charAt(r), 0) + 1);
            maxCount = Math.max(maxCount, frequent.get(s.charAt(r)));

            while ((r - l) + 1 - maxCount > k) {
                frequent.put(s.charAt(l), frequent.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, (r - l) + 1);
        }
        return res;
    }
}
