# 486. Predict the Winner

## Problem
You are given an integer array `nums`. Two players take turns picking either the first or last element of the array. Both players play optimally.

Return `true` if Player 1 can win or tie the game; otherwise, return `false`.

## Approach
- If the array length is even, Player 1 can always guarantee a win by choosing either all even-indexed or all odd-indexed elements, so return `true`.
- Otherwise, use Dynamic Programming.
- Let `dp[i]` represent the maximum score difference the current player can achieve over the opponent for the subarray currently being processed.
- Initialize `dp[i]` with `nums[i]` for subarrays of length `1`.
- Expand the subarray length from `2` to `n`.
- For every subarray:
  - Pick the left number:
    `nums[i] - dp[i + 1]`
  - Pick the right number:
    `nums[j] - dp[i]`
  - Store the better choice.
- If the final score difference is non-negative, Player 1 can win or tie.

## Algorithm
1. If `n` is even, return `true`.
2. Initialize a DP array with the values of `nums`.
3. Iterate through all possible subarray lengths.
4. Update the DP value using the optimal choice from either end.
5. Return whether `dp[0] >= 0`.

## Complexity
- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(n)`

## Topics
- Dynamic Programming
- Game Theory
- Arrays

## Language
Java