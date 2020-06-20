import java.util.Stack;

public class BaseballGame {

    public static class Test {
        public int calPoints(String[] ops) {
            int sum = 0;
            Stack<Integer> integerStack = new Stack<>();
            for(int i=0; i< ops.length; i++) {
                String op = ops[i];
                if("C".equals(op)) {
                    integerStack.pop();
                }
                else if ("D".equals(op)) {
                    Integer val = integerStack.peek() * 2;
                    integerStack.push(val);
                }
                else if ("+".equals(op)) {
                    Integer val1 = integerStack.get(integerStack.get(integerStack.size()-1));
                    Integer val2 = integerStack.get(integerStack.get(integerStack.size()-2));
                    integerStack.push(val1 + val2);
                }
                else {
                    Integer val = Integer.parseInt(op);
                    integerStack.push(val);
                }
            }
            while (!integerStack.isEmpty()) {
                sum += integerStack.pop();
            }
            return sum;
        }
    }

    public static void main(String args[]) {
        Test test = new Test();
        String[] ops = {"5","2","C","D","+"};
        System.out.println(test.calPoints(ops));
    }

}
