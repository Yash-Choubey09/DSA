import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] seen = new boolean[2048];
        List<Integer> uniqueNums = new ArrayList<>();
        for (int num : nums) {
            if (!seen[num]) {
                seen[num] = true;
                uniqueNums.add(num);
            }
        }

        boolean[] currentSet = new boolean[2048];
        currentSet[0] = true;

        for (int round = 0; round < 3; round++) {
            boolean[] nextSet = new boolean[2048];
            for (int val = 0; val < 2048; val++) {
                if (currentSet[val]) {
                    for (int x : uniqueNums) {
                        nextSet[val ^ x] = true;
                    }
                }
            }
            currentSet = nextSet;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 2048; i++) {
            if (currentSet[i]) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}