# 1406. Stone Game III

## Problem
Alice and Bob play a game with a row of stones, where each stone has an associated integer value.

- Alice starts first.
- On each turn, a player may take the first **1, 2, or 3 stones** from the remaining row.
- Both players play optimally.
- The player with the higher total score wins. If both scores are equal, the result is a tie.

Return:
- `"Alice"` if Alice wins.
- `"Bob"` if Bob wins.
- `"Tie"` if both players finish with the same score.

## Approach
- Use Dynamic Programming to store the maximum score difference the current player can achieve from each position.
- At every index, the player has three possible choices:
  - Take 1 stone.
  - Take 2 stones.
  - Take 3 stones.
- For each choice, subtract the opponent's best possible score difference from the collected stone values.
- Since only the next three DP states are required, use a rolling array of size `4` to optimize space.

## Algorithm
1. Initialize a rolling DP array of size `4`.
2. Traverse the array from right to left.
3. For each index:
   - Compute the score difference after taking 1, 2, or 3 stones.
   - Store the maximum among these choices.
4. After processing all indices:
   - If the final score difference is positive, Alice wins.
   - If negative, Bob wins.
   - Otherwise, it's a tie.

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Topics
- Dynamic Programming
- Game Theory
- Arrays

## Language
Java