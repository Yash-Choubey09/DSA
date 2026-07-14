# 1. Two Sum

**Platform:** LeetCode

**Difficulty:** Easy

## Problem Statement

Given an integer array `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.

---

## Approach

### Brute Force

- Iterate through every element in the array.
- For each element, check all remaining elements.
- If the sum equals the target, return their indices.
- Since every pair is checked once, the solution guarantees finding the answer.

---

## Time Complexity

O(n²)

## Space Complexity

O(1)

---

## Status

✅ Solved