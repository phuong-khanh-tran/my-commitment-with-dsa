import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatSolution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int pt1 = 0;
        int max = 0;

        for (int pt2 = 0; pt2 < s.length(); pt2++) {
            while (window.contains(s.charAt(pt2))) {
                window.remove(s.charAt(pt1));
                pt1++;
            }
            window.add(s.charAt(pt2));
            max = Math.max(max, pt2 - pt1 + 1);
        }
        return max;
    }
}
