
public class Evaluate {
    public static void main(String[] args) {
        String expression = "(1+((2+3)*(3+4)))";
        System.out.println(evaluate(expression));
    }

    public static int evaluate(String expression) {
        ChainStack<Character> optStack = new ChainStack<Character>();
        ChainStack<Integer> valStack = new ChainStack<Integer>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                optStack.push(c);
                continue;
            }

            if (c == ')') {
                char opt = optStack.pop();
                int rightVal = valStack.pop();
                switch(opt) {
                  case '+':
                      valStack.push(valStack.pop() + rightVal);
                      break;
                  case '-':
                      valStack.push(valStack.pop() - rightVal);
                      break;
                  case '*':
                      valStack.push(valStack.pop() * rightVal);
                      break;
                  case '/':
                      valStack.push((int) valStack.pop() / rightVal);
                      break;
                }
            } else {
                valStack.push(c - '0');
            }
        }

        return valStack.pop();
    }

}
