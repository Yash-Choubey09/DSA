# 1464. Maximum Product of Two Elements in an Array

## Problem
Given an integer array `nums`, choose two different indices `i` and `j` such that the value of `(nums[i] - 1) * (nums[j] - 1)` is maximized.

Return the maximum possible value.

## Approach
- Traverse the array once while maintaining the largest (`max1`) and second largest (`max2`) elements.
- Update these two values whenever a larger element is encountered.
- The required answer is `(max1 - 1) * (max2 - 1)`.

## Algorithm
1. Initialize `max1` and `max2` to `0`.
2. Traverse each element in the array:
   - If the current element is greater than `max1`:
     - Update `max2 = max1`
     - Update `max1 = current element`
   - Otherwise, if it is greater than `max2`, update `max2`.
3. Return `(max1 - 1) * (max2 - 1)`.

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Topics
- Array
- Greedy
- Simulation

## Language
Java