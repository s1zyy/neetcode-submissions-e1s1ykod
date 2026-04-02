class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n1; 
        int n2;

        for(String token : tokens) {
            switch(token) {
                case "+":                         
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    if(n1 != 0) {
                        stack.push(n2 / n1);
                    }
                    break;
                default:
                    System.out.println(token);
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
