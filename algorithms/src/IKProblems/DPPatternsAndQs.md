# Dynamic Programming Patterns

Dynamic Programming (DP) is a powerful technique for solving optimization problems. While DP itself is a paradigm, there are distinct patterns within DP that help in recognizing and solving different types of problems.

## 1. Fibonacci / Recurrence Pattern

**Description:**
Problems where the solution is built by combining results from one or two previous states. These problems often have a simple recurrence relation.

**Famous Problems:**

* **Fibonacci Numbers:** Each number is the sum of the two preceding ones.
* **Climbing Stairs:** Number of ways to climb a staircase where you can take one or two steps at a time.

## 2. 0/1 Knapsack Pattern

**Description:**
Problems that involve making binary decisions (to include or exclude an item) with a constraint (like weight capacity) to maximize or minimize some value.

**Famous Problems:**

* **0/1 Knapsack Problem:** Choose a subset of items with given weights and values to maximize total value without exceeding the weight limit.
* **Subset Sum:** Determine if there exists a subset that sums to a given target.
* **Partition Equal Subset Sum:** Partition a set into two subsets with equal sum.

## 3. Longest Common Subsequence (LCS) / Edit Distance Pattern

**Description:**
Problems that compare two sequences (strings, arrays, etc.) and build up the solution by considering the match/mismatch or insert/delete operations.

**Famous Problems:**

* **Longest Common Subsequence (LCS):** Find the longest subsequence common to two sequences.
* **Edit Distance (Levenshtein Distance):** Compute the minimum number of operations (insertions, deletions, substitutions) needed to convert one string into another.
* **Longest Palindromic Subsequence:** Find the longest subsequence of a string that is also a palindrome.

## 4. Longest Increasing Subsequence (LIS) Pattern

**Description:**
Problems that involve finding a subsequence within a sequence where the elements are in a sorted (usually increasing) order.

**Famous Problems:**

* **Longest Increasing Subsequence (LIS):** Identify the longest subsequence where each element is greater than the preceding one.

## 5. DP on Intervals / Partitioning Pattern

**Description:**
Problems that require partitioning a sequence or interval into segments in such a way that a cost is minimized or a value is maximized. They typically involve considering every possible partition point.

**Famous Problems:**

* **Matrix Chain Multiplication:** Determine the most efficient way to multiply a chain of matrices.
* **Burst Balloons:** Choose the order of bursting balloons to maximize coins.
* **Palindromic Partitioning:** Partition a string into palindromic substrings while minimizing the number of cuts.
* **Word Wrap:** Determine where to break lines to minimize the cost associated with extra spaces.

## 6. Bitmask DP

**Description:**
Problems where the state can be represented as a bitmask, typically when dealing with subsets or combinations of items. This pattern is common when the problem size (n) is small (usually n ≤ 20).

**Famous Problems:**

* **Traveling Salesman Problem (TSP):** Find the shortest possible route that visits each city exactly once and returns to the origin.
* **Assigning Tasks:** Problems that involve assigning tasks to workers with various constraints.

## 7. DP on Trees

**Description:**
Problems involving tree structures where the solution for a node is computed based on the solutions of its children.

**Famous Problems:**

* **Tree Diameter:** Find the longest path between any two nodes in a tree.
* **Maximum Path Sum in a Binary Tree:** Find the path with the maximum sum of node values.
* **House Robber III:** Choose nodes in a tree such that no two adjacent nodes are robbed, maximizing the total amount.

## 8. DP on Graphs / Shortest Path Pattern

**Description:**
Problems where dynamic programming is used to compute the optimal path in a graph, often using iterative relaxation.

**Famous Problems:**

* **Bellman-Ford Algorithm:** Finds shortest paths in a weighted graph (even with negative weights).
* **Floyd-Warshall Algorithm:** Computes shortest paths between every pair of vertices in a graph.

## 9. DP with Combinatorics / Counting

**Description:**
Problems that count the number of ways to arrange, partition, or sequence elements subject to certain rules.

**Famous Problems:**

* **Unique Paths:** Count the number of ways to reach the bottom-right corner of a grid.
* **Decode Ways:** Count the number of ways to decode a string of digits into letters.
* **Interleaving Strings:** Determine if a string is an interleaving of two other strings.