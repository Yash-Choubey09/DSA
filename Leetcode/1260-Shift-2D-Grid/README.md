# 1260. Shift 2D Grid

## Problem
Given an `m x n` 2D grid and an integer `k`, shift the grid `k` times according to the following rules:

- Each element moves one position to the right.
- The last element of a row moves to the first position of the next row.
- The bottom-right element moves to the top-left position.

Return the resulting grid after performing `k` shifts.

## Approach
- Treat the 2D grid as a flattened 1D array.
- Since shifting is cyclic, compute `k % (m * n)`.
- For every position in the resulting grid, determine the corresponding original position using modular arithmetic.
- Convert the 1D index back into 2D coordinates and place the value accordingly.

## Algorithm
1. Calculate the total number of elements in the grid.
2. Reduce `k` using modulo operation.
3. Traverse every position in the result grid.
4. Compute the original index:
   - `originalIndex = (currentIndex - k + total) % total`
5. Convert the original index to row and column.
6. Insert the corresponding value into the result grid.
7. Return the shifted grid.

## Complexity
- **Time Complexity:** `O(m × n)`
- **Space Complexity:** `O(m × n)`

## Topics
- Array
- Matrix
- Simulation
- Modular Arithmetic

## Language
Java