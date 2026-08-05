# 3310. Remove Methods From Project

## Problem
You are maintaining a project with `n` methods numbered from `0` to `n - 1`.

Method `k` is known to contain a bug. Any method that is directly or indirectly invoked by `k` is considered **suspicious**.

The suspicious methods can only be removed if **no non-suspicious method invokes any suspicious method**.

Return the list of remaining methods after removing all suspicious methods. If removing them is impossible, return all methods.

## Approach
- Build a directed graph representing method invocations.
- Perform a BFS starting from method `k` to mark every suspicious method reachable from it.
- Check every invocation:
  - If a non-suspicious method invokes a suspicious method, the suspicious group cannot be removed.
  - In that case, return all methods.
- Otherwise, return only the methods that are not marked as suspicious.

## Algorithm
1. Build the adjacency list for the invocation graph.
2. Perform BFS from method `k` and mark all reachable methods as suspicious.
3. Traverse every invocation:
   - If an edge exists from a non-suspicious method to a suspicious method, return all methods.
4. Otherwise, collect all non-suspicious methods.
5. Return the resulting list.

## Complexity
- **Time Complexity:** `O(n + m)`
- **Space Complexity:** `O(n + m)`

Where:
- `n` = number of methods
- `m` = number of invocations

## Topics
- Graph
- Breadth-First Search (BFS)
- Queue
- Simulation

## Language
Java