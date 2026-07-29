# 3518. Smallest Palindromic Rearrangement II

## Problem
You are given a palindromic string `s` and an integer `k`.

Return the `k`-th lexicographically smallest palindromic permutation of `s`. If fewer than `k` distinct palindromic permutations exist, return an empty string.

## Approach
- Count the frequency of each character.
- Construct the character counts for the left half of the palindrome and determine the middle character (if any).
- Compute the total number of distinct palindromic permutations using multinomial coefficients.
- If the total number of permutations is smaller than `k`, return an empty string.
- Otherwise, build the first half of the palindrome one character at a time:
  - Try each character in lexicographical order.
  - Temporarily place the character and count how many valid permutations remain.
  - If the count is at least `k`, keep the character.
  - Otherwise, subtract the count from `k` and try the next character.
- Finally, append the middle character (if present) and the reverse of the first half to obtain the palindrome.

## Algorithm
1. Count the frequency of each character.
2. Compute the frequencies for the left half.
3. Determine the total number of distinct half-string permutations.
4. If the number of permutations is less than `k`, return an empty string.
5. Build the first half greedily using permutation counting.
6. Append the middle character if the string length is odd.
7. Append the reverse of the first half.
8. Return the resulting palindrome.

## Complexity
- **Time Complexity:** `O(26 × n)`
- **Space Complexity:** `O(n)`

Where:
- `n` = Length of the input string

## Topics
- String
- Greedy
- Combinatorics
- Backtracking
- Counting
- Lexicographical Ordering

## Language
Java