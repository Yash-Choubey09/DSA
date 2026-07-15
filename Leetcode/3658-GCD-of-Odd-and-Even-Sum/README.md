# 3658. GCD of Odd and Even Sums

## Problem

Given an integer `n`, find the GCD of:

- Sum of the first `n` odd numbers
- Sum of the first `n` even numbers

## Approach

### Observation

- Sum of first `n` odd numbers = `n²`
- Sum of first `n` even numbers = `n(n + 1)`

Therefore,

GCD(n², n(n + 1))
= n × GCD(n, n + 1)
= n × 1
= n

Hence, the answer is simply `n`.

## Complexity Analysis

- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`

## Solution

```java
class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}
```