# 3501. Maximize Active Section with Trade II

## Problem
You are given a binary string `s` consisting of active (`1`) and inactive (`0`) sections, along with multiple substring queries. For each query, determine the maximum number of active sections that can be obtained after performing at most one valid trade within the specified substring.

## Approach
- Count the total number of active sections (`1`s) in the original string.
- Extract all contiguous segments of `0`s using Run-Length Encoding (RLE).
- For every adjacent pair of zero segments, precompute the total gain obtained by merging them.
- Build a Sparse Table over these gains to answer range maximum queries efficiently.
- For each query:
  - Use binary search to locate the first and last zero segments intersecting the query range.
  - Evaluate the boundary pairs separately since they may be partially covered.
  - Use the Sparse Table to obtain the maximum gain among fully contained pairs.
  - Add the maximum gain to the initial number of active sections.

## Algorithm
1. Count the total number of active sections.
2. Extract all contiguous zero segments and store their start index, end index, and length.
3. Compute the gain for every adjacent pair of zero segments.
4. Build a Sparse Table for Range Maximum Query (RMQ).
5. For each query:
   - Locate the relevant zero segments using binary search.
   - Compute gains for boundary pairs with truncation.
   - Query the Sparse Table for interior pairs.
   - Return the initial active sections plus the maximum gain.

## Complexity
- **Preprocessing:** `O(n + m log m)`
- **Each Query:** `O(log m)`
- **Space Complexity:** `O(m log m)`

Where:
- `n` = Length of the binary string
- `m` = Number of contiguous zero segments

## Topics
- String
- Binary Search
- Run-Length Encoding
- Sparse Table
- Range Maximum Query (RMQ)
- Greedy
- Data Structures

## Language
Java