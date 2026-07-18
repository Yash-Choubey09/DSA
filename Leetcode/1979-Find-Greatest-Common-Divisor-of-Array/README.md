# 1979. Find Greatest Common Divisor of Array

## Problem
Given an integer array `nums`, return the greatest common divisor (GCD) of the smallest and largest numbers in the array.

## Approach
- Traverse the array once to find the minimum and maximum elements.
- Compute the GCD of these two numbers using the Euclidean Algorithm.
- Return the computed GCD.

## Algorithm
1. Initialize `min` and `max`.
2. Traverse the array:
   - Update `min` if a smaller element is found.
   - Update `max` if a larger element is found.
3. Apply the Euclidean Algorithm to compute `gcd(min, max)`.
4. Return the result.

## Complexity
- **Time Complexity:** `O(n + log(max(nums)))`
- **Space Complexity:** `O(1)`

## Topics
- Array
- Math
- Number Theory
- Euclidean Algorithm
- GCD

## Language
Java