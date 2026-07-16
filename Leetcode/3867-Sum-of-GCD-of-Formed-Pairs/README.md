# 3867. Sum of GCD of Formed Pairs

## Problem

You are given an integer array `nums` of length `n`.

Construct an array `prefixGcd` where for each index `i`:

- `mx[i] = max(nums[0], nums[1], ..., nums[i])`
- `prefixGcd[i] = gcd(nums[i], mx[i])`

After constructing `prefixGcd`:

- Sort it in non-decreasing order.
- Form pairs by taking the smallest and largest remaining elements.
- Compute the GCD of each pair.
- Return the sum of all these GCD values.

---

## Approach

### Observation

- Traverse the array while maintaining the maximum value seen so far.
- For every element, compute the GCD of the current number and the prefix maximum.
- Store these values in the `prefixGcd` array.
- Sort the array.
- Use two pointers to pair the smallest and largest elements.
- Compute the GCD of every pair and add it to the final answer.

---

## Algorithm

1. Create a `prefixGcd` array.
2. Maintain `maxSoFar` while traversing `nums`.
3. Store `gcd(nums[i], maxSoFar)` in `prefixGcd`.
4. Sort `prefixGcd`.
5. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
6. While `left < right`:
   - Add `gcd(prefixGcd[left], prefixGcd[right])` to the answer.
   - Move both pointers.
7. Return the accumulated sum.

---

## Complexity Analysis

- Building `prefixGcd`: **O(n)**
- Sorting: **O(n log n)**
- Pair Processing: **O(n)**

**Time Complexity:** `O(n log n)`

**Space Complexity:** `O(n)`

---

## Java Solution

```java
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
```