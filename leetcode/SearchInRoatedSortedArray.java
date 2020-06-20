public class SearchInRoatedSortedArray {

    public static class Test {
        public int search(int[] nums, int target) {
            if(nums.length == 0) {
                return -1;
            }
            return binarysearch(nums, 0, nums.length-1, target);
        }

        public int binarysearch(int[] nums, int lower, int higher, int target) {

            if (lower <= higher) {
                int mid = lower + (higher - lower) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[lower] <= target && nums[mid] > target) { //lower than left and lower than mid
                    return binarysearch(nums, lower, mid - 1, target);
                } else if (nums[mid] < target && nums[higher] > target){ // target is greater than mid and less than higher
                    return binarysearch(nums, mid + 1, higher, target);
                } else { //
                    return binarysearch(nums, lower, mid - 1, target);
                }
            }
            return -1;
        }
    }

    public static void main(String args[]) {
        Test test = new Test();
        System.out.println(test.search(new int[]{7,8,9,1,2,3,4,5,6}, 9));
    }
}


// lower < target < mid
// lower < target > mid
// mid < target < higher
//mid <target > higher