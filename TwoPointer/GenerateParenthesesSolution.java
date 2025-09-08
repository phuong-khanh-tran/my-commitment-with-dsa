import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesSolution {

    public void backTrack(int openN, int closeN, int n, List<String> res, StringBuilder stack) {
        if (openN == closeN && closeN == n) {
            res.add(stack.toString());
        }
        if (openN < n) {
            stack.append("(");
            backTrack(openN + 1, closeN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closeN < openN) {
            stack.append(")");
            backTrack(openN, closeN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backTrack(0, 0, n, res, stack);
        return res;
    }
}