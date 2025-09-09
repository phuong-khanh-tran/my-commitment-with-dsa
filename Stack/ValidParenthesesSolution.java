import java.util.Map;
import java.util.Stack;

public class ValidParenthesesSolution {
    public boolean isValid(String strs) {
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> openStack = new Stack<>();

        for (int i = 0; i < strs.length(); i++) {
            char c = strs.charAt(i);
            if (pairs.containsKey(c)) {
                if (openStack.isEmpty() || openStack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                openStack.push(c);
            }
        }
        return openStack.isEmpty();
    }

}
