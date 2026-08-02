# 877. Stone Game

## Problem
Alice and Bob play a game with an even number of stone piles arranged in a row.

- Alice starts first.
- On each turn, a player takes the entire pile from either the beginning or the end.
- Both players play optimally.
- The total number of stones is odd, so there can never be a tie.

Return `true` if Alice wins the game; otherwise, return `false`.

## Approach
- Since the number of piles is always even, Alice can always guarantee a win.
- Before the game starts, Alice can choose to collect either all piles at even indices or all piles at odd indices.
- One of these two sets always contains at least as many stones as the other.
- By choosing the appropriate end on every turn, Alice can force herself to take all piles from the chosen parity.
- Therefore, regardless of the arrangement of stones, Alice always wins.

## Algorithm
1. Observe that the number of piles is even.
2. Alice follows the optimal parity strategy.
3. Since Alice can always guarantee more stones than Bob, return `true`.

## Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`

## Topics
- Game Theory
- Math

## Language
Java