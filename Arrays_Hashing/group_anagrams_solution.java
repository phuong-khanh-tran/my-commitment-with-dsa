import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class group_anagrams_solution {
    public List<List<String>> group_anagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<>();

        for (String str : strs) {
            int[] alpha = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(alpha);
            anaMap.putIfAbsent(key, new ArrayList<>());
            anaMap.get(key).add(str);
        }
        return new ArrayList<>(anaMap.values());
    }
}
