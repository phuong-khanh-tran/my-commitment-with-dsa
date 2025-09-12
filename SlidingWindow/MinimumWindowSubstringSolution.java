import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringSolution {
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int[] res = { -1, -1 };
        int max = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l) + 1 < max) {
                    max = (r - l) + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char charL = s.charAt(l);
                window.put(charL, window.getOrDefault(charL, 0) - 1);
                if (countT.containsKey(charL) && window.get(charL) < countT.get(charL)) {
                    have--;
                }
                l++;
            }
        }
        return max == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
