import java.util.HashMap;
import java.util.Map;

public class valid_anagram_solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            frequency.put(charS, frequency.getOrDefault(charS, 0) + 1);
            frequency.put(charT, frequency.getOrDefault(charT, 0) - 1);
        }

        for (int count : frequency.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        valid_anagram_solution sol = new valid_anagram_solution();
        String s = "abrr";
        String t = "rrab";

        System.out.println(sol.isAnagram(s, t));
    }
}
