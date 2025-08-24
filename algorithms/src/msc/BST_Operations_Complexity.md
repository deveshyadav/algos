# Binary Search Tree (BST) Operations: Time & Space Complexity

## Operations Overview

| Operation            | Balanced BST  | Skewed BST  | Iterative vs Recursive | Best Approach & Why? | Time Complexity | Space Complexity |
|----------------------|--------------|-------------|------------------------|-----------------------|-----------------|-----------------|
| **Insertion**       | O(log N)      | O(N)        | Iterative              | Avoids stack overflow & improves performance | O(log N) / O(N) | O(1) Iterative / O(N) Recursive |
| **Deletion**        | O(log N)      | O(N)        | Iterative              | Recursion can cause stack overflow; iteration is preferred | O(log N) / O(N) | O(1) Iterative / O(N) Recursive |
| **Search**         | O(log N)      | O(N)        | Iterative              | Iteration prevents unnecessary stack usage | O(log N) / O(N) | O(1) Iterative / O(N) Recursive |
| **Inorder Traversal**  | O(N)         | O(N)        | Recursive              | More natural recursive calls & maintains order | O(N) | O(N) |
| **Preorder Traversal** | O(N)         | O(N)        | Recursive              | Easier to implement due to tree structure | O(N) | O(N) |
| **Postorder Traversal**| O(N)         | O(N)        | Recursive              | Easier to implement due to stack-based processing | O(N) | O(N) |
| **Level Order Traversal** | O(N)      | O(N)        | Iterative              | Uses Queue instead of recursion for better efficiency | O(N) | O(N) |

## When to Use What?

| Scenario                          | Best Approach | Why? |
|------------------------------------|--------------|------|
| **Deep BST with high depth**       | Iterative    | Avoids stack overflow and excessive recursion calls |
| **Shallow BST with small size**    | Recursive    | Easier and more readable with fewer function calls |
| **Tree traversal**                 | Recursive    | Natural and simple recursive implementation |
| **Level order traversal**          | Iterative    | Queue-based approach is more efficient and avoids recursion depth issues |
