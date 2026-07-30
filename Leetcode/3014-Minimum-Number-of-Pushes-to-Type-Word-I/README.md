# 3014. Minimum Number of Pushes to Type Word I

## Problem
You are given a string `word` containing distinct lowercase English letters.

The telephone keypad can be remapped so that each letter is assigned to exactly one key. Determine the minimum number of key presses required to type the given word.

## Approach
- Since there are **8 available letter keys (2–9)**, the first 8 letters can each be assigned to require only **1 key press**.
- The next 8 letters require **2 key presses**, the following 8 require **3 key presses**, and so on.
- Process the characters in groups of at most 8 and accumulate the total key presses.

## Algorithm
1. Let `n` be the length of the word.
2. Initialize the current push cost to `1`.
3. While characters remain:
   - Assign up to `8` characters to the current push cost.
   - Add `(assigned characters × push cost)` to the answer.
   - Reduce the remaining character count.
   - Increment the push cost.
4. Return the total number of key presses.

## Complexity
- **Time Complexity:** `O(1)` (At most 26 characters)
- **Space Complexity:** `O(1)`

## Topics
- Greedy
- Math
- Simulation

## Language
Java