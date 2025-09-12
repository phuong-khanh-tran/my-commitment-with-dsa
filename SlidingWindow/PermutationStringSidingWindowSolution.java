public class PermutationStringSidingWindowSolution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Frequent = new int[26];
        int[] s2Frequent = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Frequent[s1.charAt(i) - 'a']++;
            s2Frequent[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Frequent[i] == s2Frequent[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int indexR = s2.charAt(r) - 'a';
            s2Frequent[indexR]++;
            if (s1Frequent[indexR] == s2Frequent[indexR]) {
                matches++;
            } else if (s1Frequent[indexR] + 1 == s2Frequent[indexR]) {
                matches--;
            }

            int indexL = s2.charAt(l) - 'a';
            s2Frequent[indexL]--;
            if (s1Frequent[indexL] == s2Frequent[indexL]) {
                matches++;
            } else if (s1Frequent[indexL] - 1 == s2Frequent[indexL]) {
                matches--;
            }
            l++;
        }

        return matches == 26;
    }
}
