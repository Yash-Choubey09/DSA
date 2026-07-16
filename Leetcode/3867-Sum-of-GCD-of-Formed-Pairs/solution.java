class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long[] prefixGcd = new long[n];
        
        long maxSoFar = 0;
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }
        java.util.Arrays.sort(prefixGcd);
        long totalGcdSum = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            totalGcdSum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        
        return totalGcdSum;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}