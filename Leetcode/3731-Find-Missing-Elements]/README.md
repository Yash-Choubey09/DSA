# 3731. Find Missing Elements

## Problem
You are given an array `nums` containing unique integers.

Originally, the array contained every integer within a continuous range, but some values are now missing. The smallest and largest values of the original range are still present.

Return a sorted list of all missing integers within that range.

## Approach
- Traverse the array once to determine the minimum and maximum values.
- Store every element in a `HashSet` for constant-time lookups.
- Iterate from `min` to `max`.
- If a number is not present in the set, add it to the result list.
- Return the list of missing numbers.

## Algorithm
1. Initialize `min`, `max`, and a `HashSet`.
2. Traverse the array:
   - Update the minimum and maximum values.
   - Insert every element into the set.
3. Iterate from `min` to `max`:
   - If the current number is absent from the set, add it to the answer.
4. Return the resulting list.

## Complexity
- **Time Complexity:** `O(n + (max - min))`
- **Space Complexity:** `O(n)`

## Topics
- Array
- HashSet
- Simulation

## Language
Java