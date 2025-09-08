import java.util.Stack;

public class EvaluateReversePolishNotationSolution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int right = stack.pop();
                int left = stack.pop();

                int res = applyOperation(token, left, right);
                stack.push(res);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid RPN expression");
        }
        return stack.pop();
    }

    private boolean isOperator(String str) {
        return "+-*/".contains(str);
    }

    private int applyOperation(String operator, int left, int right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0)
                    throw new ArithmeticException("Division by zero");
                return left / right;
            default:
                throw new IllegalArgumentException("Unknown operator");
        }
    }
}
