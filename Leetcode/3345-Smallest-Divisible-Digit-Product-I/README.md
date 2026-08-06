# 3345. Smallest Divisible Digit Product I

## Problem
Given two integers `n` and `t`, return the smallest integer greater than or equal to `n` such that the product of its digits is divisible by `t`.

## Approach
- Start checking numbers from `n`.
- Compute the product of the digits of the current number.
- If the product is divisible by `t`, return the current number.
- Otherwise, increment the number and repeat.

Since the constraints are small, a simple brute-force search is sufficient.

## Algorithm
1. Initialize the current number as `n`.
2. Compute the product of its digits.
3. If the product is divisible by `t`, return the number.
4. Otherwise, increment the number and repeat.
5. Use a helper function to calculate the product of digits.

## Complexity
- **Time Complexity:** `O(k × d)`
- **Space Complexity:** `O(1)`

Where:
- `k` = number of integers checked until a valid answer is found.
- `d` = number of digits in the current number.

## Topics
- Math
- Brute Force
- Simulation

## Language
Java