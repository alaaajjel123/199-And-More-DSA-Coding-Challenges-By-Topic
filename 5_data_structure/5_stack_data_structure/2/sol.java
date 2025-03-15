import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class ReversePolishNotation {

    public static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Map<String, Operator> operators = new HashMap<>();
        
        operators.put("+", (n1, n2) -> n1 + n2);
        operators.put("-", (n1, n2) -> n1 - n2);
        operators.put("*", (n1, n2) -> n1 * n2);
        operators.put("/", (n1, n2) -> n1 / n2);
        
        for (String token : tokens) {
            if (operators.containsKey(token)) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                int result = operators.get(token).apply(n1, n2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }

    interface Operator {
        int apply(int n1, int n2);
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evaluate(tokens)); 
    }
}