import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public static class Test {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Stack<Integer> integerStack = new Stack<>();

            if (nums2.length ==0) {
                int[] greaterNum = new int[nums1.length];
                Arrays.fill(greaterNum, -1);
                return greaterNum;
            }
            else if (nums2.length == 1) {
                map1.put(nums2[0], -1);
            } else {
                int i = 0;
                integerStack.push(nums2[i]);

                while (i < nums2.length) {
                    while (!integerStack.isEmpty()) {
                        if (nums2[i] > integerStack.peek()) {
                            map1.put(integerStack.peek(), nums2[i]);
                            integerStack.pop();
                        } else {
                            break;
                        }
                    }
                    integerStack.push(nums2[i]);
                    i++;
                }

                while (!integerStack.isEmpty()) {
                    map1.put(integerStack.peek(), -1);
                    integerStack.pop();
                }
            }
            int[] greaterNum = new int[nums1.length];
            for (int j = 0; j < nums1.length; j++) {
                greaterNum[j] = map1.get(nums1[j]);
            }
            return greaterNum;
        }
    }

    public static void main(String args[]) {
        Test test = new Test();
        int[] greaterNum = test.nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4});
        for (int i =0 ; i< greaterNum.length; i++) {
            System.out.println(greaterNum[i]);
        }
    }
}
