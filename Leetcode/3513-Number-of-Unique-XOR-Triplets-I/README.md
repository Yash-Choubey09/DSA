# 3513. Number of Unique XOR Triplets I

## Problem
You are given an integer array `nums` of length `n`, where `nums` is a permutation of the integers from `1` to `n`.

A XOR triplet is defined as the XOR of three elements `nums[i] XOR nums[j] XOR nums[k]`, where `i <= j <= k`.

Return the number of distinct XOR values that can be obtained from all possible triplets.

## Approach
- For arrays of length `1` or `2`, every possible triplet produces exactly `n` distinct XOR values.
- For `n >= 3`, the number of distinct XOR triplet values follows a mathematical pattern:
  - The answer is the smallest power of two that is strictly greater than `n`.
- This value can be computed efficiently using the number of leading zeros in the binary representation of `n`.

## Algorithm
1. Let `n` be the length of the array.
2. If `n <= 2`, return `n`.
3. Otherwise, compute:
   - `1 << (32 - Integer.numberOfLeadingZeros(n))`
4. Return the computed value.

## Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`

## Topics
- Bit Manipulation
- Math
- XOR

## Language
Java