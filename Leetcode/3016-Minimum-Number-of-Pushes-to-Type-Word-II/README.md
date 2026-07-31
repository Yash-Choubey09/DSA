# 3016. Minimum Number of Pushes to Type Word II

## Problem
You are given a string `word` containing lowercase English letters.

You may remap the letters to the keys numbered `2` through `9` on a telephone keypad. Each key can contain any number of letters, but every letter must be assigned to exactly one key.

Return the minimum number of key presses required to type the given word.

## Approach
- Count the frequency of every character in the string.
- Sort the frequencies in descending order.
- Assign the most frequent letters to positions requiring the fewest key presses.
- The first 8 letters require **1 press**, the next 8 require **2 presses**, then **3 presses**, and so on.
- Multiply each character's frequency by its assigned push cost and accumulate the answer.

## Algorithm
1. Count the frequency of each lowercase letter.
2. Sort the frequency array.
3. Traverse the frequencies from highest to lowest.
4. For the `i-th` most frequent character:
   - Push cost = `(i / 8) + 1`
   - Add `frequency × push cost` to the answer.
5. Return the total number of key presses.

## Complexity
- **Time Complexity:** `O(26 log 26)` (effectively `O(1)`)
- **Space Complexity:** `O(26)` (effectively `O(1)`)

## Topics
- Greedy
- Sorting
- Hashing
- Frequency Counting

## Language
Java