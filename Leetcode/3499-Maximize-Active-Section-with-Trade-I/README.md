# 3499. Maximize Active Section with Trade I

## Problem
Given a binary string `s` representing active (`1`) and inactive (`0`) sections, perform at most one valid trade to maximize the total number of active sections. Return the maximum number of active sections possible after the trade.

## Approach
- Count the initial number of active sections (`1`s).
- Add virtual active sections (`1`) at both ends of the string to simplify boundary handling.
- Compress the string into consecutive groups (run-length encoding), storing:
  - Character type (`0` or `1`)
  - Length of each group
- Traverse the groups and identify every isolated group of `1`s surrounded by `0`s.
- For each such group, calculate the increase obtained by merging the adjacent inactive groups.
- Return the initial count of active sections plus the maximum possible increase.

## Algorithm
1. Count all active sections.
2. Create a new string by adding `1` at both ends.
3. Perform run-length encoding of the string.
4. Traverse each group:
   - If it is a `1` group surrounded by `0` groups,
     compute the gain as:
     `leftZeroLength + rightZeroLength`.
5. Keep the maximum gain.
6. Return `initialActiveSections + maximumGain`.

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

## Topics
- String
- Greedy
- Simulation
- Run-Length Encoding
- Array

## Language
Java