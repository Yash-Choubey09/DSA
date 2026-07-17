# 3312. Sorted GCD Pair Queries

## Problem
Given an integer array `nums` and an array of queries, compute the GCD of every possible pair, sort these GCD values in ascending order, and return the value at each queried index.

## Approach
- Find the maximum value in the array.
- Count the frequency of each number.
- For every possible GCD `g` (from largest to smallest):
  - Count how many numbers are divisible by `g`.
  - Compute the total number of pairs.
  - Remove pairs already counted for multiples of `g` using inclusion-exclusion.
- Build a prefix sum array of GCD pair counts.
- Answer each query using binary search on the prefix sum array.

## Algorithm
1. Count the frequency of every number.
2. Iterate from `maxValue` down to `1`.
3. Count elements divisible by the current GCD.
4. Calculate the number of valid pairs.
5. Exclude pairs belonging to multiples of the current GCD.
6. Store the exact number of pairs for each GCD.
7. Build prefix sums.
8. Use binary search to answer each query.

## Complexity
- **Time Complexity:** `O(M log M + Q log M)`
  - `M` = Maximum value in `nums`
  - `Q` = Number of queries
- **Space Complexity:** `O(M)`

## Topics
- Math
- Number Theory
- GCD
- Inclusion-Exclusion
- Prefix Sum
- Binary Search
- Counting

## Language
Java