# 1081. Smallest Subsequence of Distinct Characters

## Problem
Given a string `s`, return the lexicographically smallest subsequence of `s` that contains all the distinct characters of `s` exactly once.

## Approach
- Store the last occurrence index of every character.
- Traverse the string while maintaining a stack.
- If the current character is already included, skip it.
- Otherwise, remove larger characters from the top of the stack if they appear again later, ensuring the subsequence remains lexicographically smallest.
- Add the current character to the stack and mark it as visited.
- Return the final stack as the answer.

## Algorithm
1. Record the last occurrence of each character.
2. Initialize an empty stack and a visited array.
3. Traverse the string:
   - Skip characters already present in the stack.
   - While the top character is greater than the current character and appears later in the string:
     - Remove it from the stack.
     - Mark it as not visited.
   - Push the current character and mark it as visited.
4. Return the stack as a string.

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Topics
- String
- Stack
- Greedy
- Monotonic Stack

## Language
Java