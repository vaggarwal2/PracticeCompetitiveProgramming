public class ContainerWithMostWater {

    public static class Test {
        public int maxArea(int[] height) {
            int[] max_height = new int[height.length];
            int i = 0;
            int j = height.length-1;
            while(i!=j) {
                if (height[i] < height[j]) {
                    max_height[j-i]=height[i];
                    i++;
                } else if (height[i] > height[j]) {
                    max_height[j-i]=height[j];
                    j--;
                } else {
                    max_height[j-i] = height[i];
                    if (Math.abs(height[i]-height[i+1]) < Math.abs(height[j]-height[j-1])) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }

            int max_area = 0;
            for (int k=0; k < max_height.length;k++) {
                if (max_area < max_height[k] * k) {
                    max_area =  max_height[k] * k;
                }
            }
            return max_area;
        }
    }


    public static void main(String args[]) {
        Test test = new Test();
        int[] height = {1,8,9,2,5,4,8};
        System.out.println(test.maxArea(height));
    }
}
