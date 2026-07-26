# 628. Maximum Product of Three Numbers

## Problem
Given an integer array `nums`, return the maximum product that can be obtained by multiplying any three numbers in the array.

## Approach
- Sort the array in ascending order.
- There are two possible candidates for the maximum product:
  - The product of the three largest numbers.
  - The product of the two smallest numbers (possibly negative) and the largest number.
- Return the larger of these two values.

## Algorithm
1. Sort the array.
2. Compute:
   - `prod1 = nums[n-1] * nums[n-2] * nums[n-3]`
   - `prod2 = nums[0] * nums[1] * nums[n-1]`
3. Return `max(prod1, prod2)`.

## Complexity
- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(1)` *(excluding the sorting implementation used by the language)*

## Topics
- Array
- Sorting
- Math
- Greedy

## Language
Java