public class RemoveInPlaceDuplicate {

    public static class Test {
        public int  removeDuplicates(int[] nums) {
            int i = 0, j = 1;
            boolean swap = false;

            while (j < nums.length) {
                if (nums[i] != nums[j]) {
                    i++;
                    if (swap) {
                     //   int temp = nums[i];
                        nums[i] = nums[j];
                        //nums[j] = temp;
                        // swap = false;
                    }
                    j++;
                } else if (nums[i] == nums[j]) {
                    swap = true;
                    j++;
                }
            }
            return i + 1;
        }
    }
    public static void main(String args[]) {
        Test test = new Test();
        int[] a = new int[]{1,1,2,3};
        System.out.println(test.removeDuplicates(a));
        for ( int i = 0 ; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
