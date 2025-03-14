# Programming Questions by Topic

## Sorting
### Brute Force
- **Implement Selection Sort**
- **Implement Bubble Sort**
- **Implement Insertion Sort**

### Divide & Conquer
- **Implement Merge Sort**
- **Implement Quick Sort**

### Transform & Conquer
- **Implement Heap Sort**
- **Implement Counting Sort**
- **Implement Radix Sort**

### Problems
- **Segregate Even And Odd Numbers**
- **Merge One Sorted Array Into Another**
- **Dutch National Flag**
- **2 Sum In A Sorted Array**
- **2 Sum In An Array**
- **Merge K Sorted Linked Lists**
- **Attend Meetings**  
  _Check if a person can attend all the given meetings such that only one meeting can be attended at a time._
- **Sort All Characters**
- **Four Billion**
- **Nearest Neighbors**
- **Top K Frequent Elements**
- **Kth Largest In A Stream**
  ```json
  {
    "k": 2,
    "initial_stream": [4, 6],
    "append_stream": [5, 2, 20]
  }
  ```
- **Kth Largest In An Array**
- **Online Median**
- **Intersection Of Three Sorted Arrays**

## Recursion
- **Lazy Manager Strategy**
- **Count All Subsets Of A Set Of Size N**
- **Fibonacci Number**
- **N Choose K Combinations**
- **Tower Of Hanoi**
- **Generate Binary Strings Of Length N**
- **Permute Array Of Unique Integers**
- **Generate All Subsets Of A Set**
- **Palindromic Decomposition Of A String**
- **How Many Binary Search Trees With N Nodes**
- **Calculate Power**
- **Strings From Wild Card**
- **Letter Case Permutation**
- **Sudoku Solver**
- **N Queen Problem**
- **Generate All Possible Expressions That Evaluate To The Given Target Value**
  ~~~json
  {
    "s": "202",
    "target": 4
  }
  ~~~
- **Permute Array Of Integers Duplicates Allowed**
- **Subsets With Duplicate Characters**
- **Words From Phone Number**
- **Generate All Combinations With Sum Equal To Target**

## Tree
- **Search A Node In Binary Search Tree**
- **Insert In BST**
- **Maximum Valued Node In Binary Search Tree**
- **Delete From BST**
- **Level Order Traversal Of A Binary Tree**
- **Preorder, Inorder, Postorder Traversal Of A Binary Tree**
- **Print All Paths Of A Tree**
- **PostOrder Traversal Without Recursion**
- **Lowest Common Ancestor**
- **In-order Binary Tree Iterator**
- **Mirror Image Of Binary Tree**
- **Clone A Binary Tree**
- **Populate Sibling Pointers**
- **Reverse Level Order Traversal Of A Binary Tree**
- **Right Side View Of A Binary Tree**
- **Zigzag Level Order Traversal Of A Binary Tree**
- **Root To Leaf Path Sum Equal To K**
- **Print All Paths That Sum To K**
- **Diameter Of A Binary Tree**
- **Convert Sorted List To Binary Search Tree**
- **Construct A Binary Search Tree From Its Preorder Traversal**
- **Is It A BST**
- **Single Value Tree**
- **Upside Down**
- **Merge Two BSTs**
- **Largest BST**
- **Convert A Binary Tree Into A Circular Doubly Linked List**
- **Construct Binary Tree**

## Graph
- **Check If Eulerian Cycle Exists**
- **Check If Eulerian Path Exists**
- **Convert Edge List To Adjacency List**
- **Convert Edge List To Adjacency Matrix**
- **BFS Traversal Of A Graph**
- **DFS Traversal Of A Graph**
- **Is It A Tree**
- **Count Connected Components In An Undirected Graph**
- **Friendly Groups**
- **Count Islands**
- **Find Largest Island**
- **Flood Fill**
- **Knight's Tour On A Chessboard**
- **Shortest String Transformation Using A Dictionary**
- **Zombie Clusters**
- **Count Basins**
- **Shortest Distance To A Guard**
- **Detect Cycle In Directed Graph**
- **Longest Path In Weighted DAG**
- **Course Schedule**
- **Critical Connections**
- **Shortest Path In 2D Grid With Keys And Doors**
- **Snakes And Ladders Matrix**
- **Complete All Courses With Dependencies**

## Dynamic Programming
### 1. Fibonacci / Recurrence Pattern

**Description:** Problems where the solution is built by combining results from one or two previous states. These problems often have a simple recurrence relation.

**Problems:**

* **Fibonacci Number:** Classic example of a simple recurrence relation.
* **Count Ways To Reach The Nth Step:** Similar to climbing stairs, relies on combining previous results.

### 2. 0/1 Knapsack / Subset Sum Pattern

**Description:** Problems that involve making choices to include or exclude items to maximize or minimize a value within constraints.

**Problems:**

* **Equal Subset Partition:** Determines if a set can be partitioned into two subsets with equal sums.
* **Minimum Coins:** Finding the minimum number of coins to make a target sum (can also be viewed as an unbounded knapsack).
* **Number Of Ways To Make Change:** Counting the number of ways to make change for a given amount.
* **Coin Play:** Finding the optimal strategy for a coin game (involves making choices, similar to knapsack).

### 3. Longest Common Subsequence (LCS) / Edit Distance Pattern

**Description:** Problems that compare sequences (strings, arrays) and build solutions based on match/mismatch or insert/delete operations.

**Problems:**

* **Levenshtein Distance:** Calculates the minimum edit distance between two strings.
* **Longest Common Subsequence:** Finds the longest common subsequence between two sequences.
* **Strings Interleave:** Checks if a string is an interleaving of two other strings.

### 4. Longest Increasing Subsequence (LIS) / Sequence Related Pattern

**Description:** Problems that involve finding optimal subsequences or sequences based on given constraints.

**Problems:**

* **Jump Ways:** Counting the ways to reach the last index of an array by jumping.
* **Jump Game:** Determining if it is possible to reach the last index of an array by jumping.

### 5. DP on Intervals / Partitioning Pattern

**Description:** Problems that require partitioning a sequence or interval into segments to optimize a cost or value.

**Problems:**

* **Cut The Rod To Maximize Profit:** Finding the maximum profit by cutting a rod into pieces.
* **Matrix Chain Multiplication:** Optimizing the order of matrix multiplications.
* **Word Wrap:** Optimizing line breaks to minimize cost.

### 6. DP on Grids / Paths Pattern

**Description:** Problems that involve finding optimal paths or values within grid structures.

**Problems:**

* **Unique Paths:** Counting the number of unique paths in a grid.
* **Maximum Path Sum:** Finding the maximum sum path in a grid or tree.
* **Largest Square Submatrix With All 1s:** Finding the largest square submatrix with all 1s.

### 7. Other DP Patterns

**Description:** Problems that don't neatly fit into the above categories or are specific variations.

**Problems:**

* **N Choose R:** Combinatorial problem that can be solved using DP.
* **Min Cost Climbing Stairs:** Finding the minimum cost to climb stairs (a variation of the Fibonacci/Recurrence Pattern, but often treated separately).
* **Word Break Count:** Counting the number of ways a string can be segmented into dictionary words.