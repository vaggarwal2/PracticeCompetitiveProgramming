import java.util.Stack;

public class PreorderSerializer {

    public static class Test {
        public boolean isValidSerialization(String preorder) {
//            if(preorder.length() ==1) {
//                if ("#".equals(preorder)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//            Stack<String> stack = new Stack<>();
//            String[] preorder_char = preorder.split(",");
////            stack.push(preorder_char[0]);
//            int i=0;
//            while(i<preorder_char.length) {
//                stack.push(preorder_char[i]);
//                i++;
//            }
////            while (i < preorder_char.length) {
////                if (i+1 < preorder_char.length && "#".equals(preorder_char[i]) && "#".equals(preorder_char[i+1])) {
////                    stack.pop();
////                    stack.push("#");
////                    i = i+2;
////                } else  {
////                    stack.push(preorder_char[i]);
////                    i++;
////                }
////            }
//            Stack<String> newStack =  new Stack<>();
//            while (!stack.isEmpty() && stack.size() != 1) {
//                if(stack.get(stack.size()-1).equals("#") && stack.get(stack.size()-2).equals("#") ) {
//                    stack.pop();
//                    stack.pop();
//                    newStack.push(stack.pop());
//                }
//                else if(stack.get(stack.size()-1).equals("#")) {
//                    stack.pop();
//                    newStack.push(stack.pop());
//                }
//
//                if (newStack.size() ==2) {
//                        stack.push(newStack.pop());
//                        stack.push(newStack.pop());
//                    }
//            }
//            if (stack.isEmpty() && newStack.size() ==1) {
//                    return true;
//                }
//            return false;
//        }
            String[] nodes = preorder.split(",");
            Stack<String> stack = new Stack<>();
            int i = 0;
            while (i < nodes.length) {
                if (!nodes[i].equals("#")) {
                    stack.push(nodes[i]);
                    i++;
                } else {
                    if (i == nodes.length - 1) return stack.isEmpty();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String args[]) {
        Test test = new Test();
        System.out.println(test.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
