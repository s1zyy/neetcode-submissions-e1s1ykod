class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num1;
        int num2;
        for(String part : tokens) {
            switch(part){

                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2-num1);
                    break;
                
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2+num1);
                    break;
                
                case "*":
                    num1 =  stack.pop();
                    num2 =  stack.pop();
                    stack.push(num2*num1);
                    break;
                
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2/num1);
                    break;
                
                default:
                    
                    stack.push(Integer.parseInt(part));
                
            }
            
        

        }
        return stack.pop();
        
    }
}
