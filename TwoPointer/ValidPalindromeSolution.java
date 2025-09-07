public class ValidPalindromeSolution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !isAlphaNum(s.charAt(start))) {
                start++;
            }

            while (start < end && !isAlphaNum(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

    public boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z' || (c > '0' && c <= '9'));
    }

    public static void main(String[] args) {
        ValidPalindromeSolution sol = new ValidPalindromeSolution();
        sol.isPalindrome("Was it a car or a cat I saw?");
    }
}
