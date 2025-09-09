import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvalRpnRecursSolution {
    public int evalRpnRecurs(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        return recurse(tokenList);
    }

    public int recurse(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);

        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int right = recurse(tokens);
        int left = recurse(tokens);

        switch (token) {
            case "+":
                return (left + right);
            case "-":
                return (left - right);
            case "*":
                return (left * right);
            case "/":
                return (left / right);
            default:
                return 0;
        }
    }
}
