# 3536. Maximum Product of Two Digits

## Problem
Given a positive integer `n`, return the maximum product of any two digits in `n`.

A digit may be used twice only if it appears at least twice in the number.

## Approach
- Traverse all digits of the number.
- Maintain the largest (`max1`) and second largest (`max2`) digits encountered.
- Update these values while extracting each digit.
- The answer is simply the product of the two largest digits.

## Algorithm
1. Initialize `max1` and `max2` to `0`.
2. Extract each digit using modulo (`% 10`).
3. If the digit is greater than `max1`:
   - Update `max2 = max1`
   - Update `max1 = digit`
4. Otherwise, if the digit is greater than `max2`, update `max2`.
5. Return `max1 * max2`.

## Complexity
- **Time Complexity:** `O(d)`
- **Space Complexity:** `O(1)`

Where:
- `d` = Number of digits in `n`

## Topics
- Math
- Greedy
- Simulation

## Language
Java