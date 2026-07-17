import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int[] counts = new int[maxVal + 1];
        for (int num : nums) {
            counts[num]++;
        }
        
        long[] gcdPairsCount = new long[maxVal + 1];
        
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = 0;
            for (int j = i; j <= maxVal; j += i) {
                totalMultiples += counts[j];
            }

            long totalPairs = totalMultiples * (totalMultiples - 1) / 2;
            
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdPairsCount[j];
            }
            
            gcdPairsCount[i] = totalPairs;
        }
        
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdPairsCount[i];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIdx = queries[i];
            int low = 1, high = maxVal, res = maxVal;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] > targetIdx) {
                    res = mid;      
                    high = mid - 1;
                } else {
                    low = mid + 1;   
                }
            }
            answer[i] = res;
        }
        
        return answer;
    }
}

