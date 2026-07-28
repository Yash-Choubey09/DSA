# 3517. Smallest Palindromic Rearrangement I

## Problem
You are given a palindromic string `s`.

Return the lexicographically smallest palindromic permutation of `s`.

## Approach
- Count the frequency of each character.
- Construct the left half of the palindrome by placing half of each character's occurrences in lexicographical order.
- If a character has an odd frequency, place it in the middle.
- Append the reverse of the left half to form the right half.
- The resulting string is the lexicographically smallest palindrome.

## Algorithm
1. Count the frequency of every character.
2. Traverse characters from `'a'` to `'z'`:
   - Append `count[i] / 2` copies of each character to the left half.
   - If `count[i]` is odd, store it as the middle character.
3. Construct the answer as:
   - `leftHalf + middleCharacter + reverse(leftHalf)`
4. Return the resulting palindrome.

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

Where:
- `n` = Length of the string

## Topics
- String
- Greedy
- Counting
- Two Pointers

## Language
Java