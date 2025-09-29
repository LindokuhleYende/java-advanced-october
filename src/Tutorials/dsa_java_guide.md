# Data Structures & Big O Notation - Complete Guide

## Understanding Big O Notation

### What is Big O?
Big O notation describes the **performance** or **complexity** of an algorithm. It specifically describes the worst-case scenario and helps us understand how the runtime or space requirements grow as the input size increases.

### Common Big O Complexities (Best to Worst):

1. **O(1) - Constant Time**
   - Performance doesn't change with input size
   - Example: Accessing an array element by index

2. **O(log n) - Logarithmic Time**
   - Performance grows slowly as input increases
   - Example: Binary search in a sorted array

3. **O(n) - Linear Time**
   - Performance grows proportionally with input
   - Example: Iterating through an array

4. **O(n log n) - Linearithmic Time**
   - Common in efficient sorting algorithms
   - Example: Merge Sort, Quick Sort (average case)

5. **O(n²) - Quadratic Time**
   - Performance grows exponentially with input
   - Example: Nested loops, Bubble Sort

6. **O(n³) - Cubic Time**
   - Triple nested loops
   - Example: Matrix multiplication (naive approach)

7. **O(2ⁿ) - Exponential Time**
   - Doubles with each addition to input
   - Example: Recursive Fibonacci (naive)

8. **O(n!) - Factorial Time**
   - Extremely slow
   - Example: Generating all permutations

### Big O Rules:
- Drop constants: O(2n) → O(n)
- Drop non-dominant terms: O(n² + n) → O(n²)
- Different inputs use different variables: O(a + b) not O(n)

---

## 1. Arrays

### Description:
Fixed-size, contiguous memory locations storing elements of the same type.

### Characteristics:
- **Fixed size** (in standard arrays)
- **Random access** via index
- **Homogeneous** elements

### Time Complexity:
- Access: **O(1)**
- Search: **O(n)**
- Insertion (at end): **O(1)** if space available
- Insertion (at position): **O(n)** - must shift elements
- Deletion: **O(n)** - must shift elements

### Space Complexity: **O(n)**

### When to Use:
- Know the size in advance
- Need fast random access
- Memory locality is important

### Java Example:
```java
int[] arr = new int[5];
arr[0] = 10;  // O(1) access
```

---

## 2. ArrayList (Dynamic Array)

### Description:
Resizable array implementation that grows automatically.

### Characteristics:
- **Dynamic size** - grows as needed
- Backed by an array internally
- Automatically resizes (typically doubles capacity)

### Time Complexity:
- Access: **O(1)**
- Search: **O(n)**
- Insertion (at end): **O(1)** amortized
- Insertion (at position): **O(n)**
- Deletion: **O(n)**
- Resize operation: **O(n)**

### Space Complexity: **O(n)**

### When to Use:
- Don't know size in advance
- Need fast random access
- More additions at the end than middle

---

## 3. Linked List

### Description:
Linear collection of nodes where each node contains data and a reference to the next node.

### Types:
1. **Singly Linked List** - Each node points to next
2. **Doubly Linked List** - Each node points to next and previous
3. **Circular Linked List** - Last node points back to first

### Characteristics:
- Non-contiguous memory
- Dynamic size
- No random access

### Time Complexity:
- Access: **O(n)** - must traverse from head
- Search: **O(n)**
- Insertion (at head): **O(1)**
- Insertion (at tail): **O(1)** if tail pointer exists, else O(n)
- Insertion (at position): **O(n)**
- Deletion (at head): **O(1)**
- Deletion (at position): **O(n)**

### Space Complexity: **O(n)** (extra space for pointers)

### When to Use:
- Frequent insertions/deletions at beginning
- Don't need random access
- Size changes frequently

---

## 4. Stack

### Description:
LIFO (Last In, First Out) data structure.

### Characteristics:
- Only access top element
- Push and pop operations
- Can be implemented with array or linked list

### Time Complexity:
- Push: **O(1)**
- Pop: **O(1)**
- Peek/Top: **O(1)**
- Search: **O(n)**

### Space Complexity: **O(n)**

### When to Use:
- Function call management (recursion)
- Undo mechanisms
- Expression evaluation
- Backtracking algorithms
- Depth-First Search (DFS)

---

## 5. Queue

### Description:
FIFO (First In, First Out) data structure.

### Characteristics:
- Elements added at rear, removed from front
- Can be implemented with array or linked list

### Time Complexity:
- Enqueue: **O(1)**
- Dequeue: **O(1)**
- Peek/Front: **O(1)**
- Search: **O(n)**

### Space Complexity: **O(n)**

### Types:
- **Simple Queue**
- **Circular Queue** - Last position connects to first
- **Priority Queue** - Elements have priority
- **Deque** - Double-ended queue (add/remove from both ends)

### When to Use:
- Breadth-First Search (BFS)
- Task scheduling
- Buffer management
- Order processing

---

## 6. Hash Table / HashMap

### Description:
Key-value pairs with fast lookup using hashing.

### Characteristics:
- Uses hash function to compute index
- Handles collisions (chaining or open addressing)
- No guaranteed order

### Time Complexity:
- Insert: **O(1)** average, **O(n)** worst case
- Delete: **O(1)** average, **O(n)** worst case
- Search: **O(1)** average, **O(n)** worst case

### Space Complexity: **O(n)**

### When to Use:
- Need fast lookups by key
- Counting frequencies
- Caching
- Detecting duplicates

### Collision Resolution:
1. **Chaining** - Store collisions in linked list
2. **Open Addressing** - Find next available slot

---

## 7. Binary Tree

### Description:
Hierarchical structure where each node has at most two children (left and right).

### Characteristics:
- Root node at top
- Each node has 0, 1, or 2 children
- Leaf nodes have no children

### Types:
- **Full Binary Tree** - Every node has 0 or 2 children
- **Complete Binary Tree** - All levels filled except possibly last
- **Perfect Binary Tree** - All levels completely filled
- **Balanced Binary Tree** - Height difference ≤ 1 for all nodes

### Time Complexity (general):
- Search: **O(n)** worst case
- Insertion: **O(n)** worst case
- Deletion: **O(n)** worst case

### Space Complexity: **O(n)**

### Traversals:
1. **Inorder** (Left, Root, Right) - O(n)
2. **Preorder** (Root, Left, Right) - O(n)
3. **Postorder** (Left, Right, Root) - O(n)
4. **Level-order** (BFS) - O(n)

---

## 8. Binary Search Tree (BST)

### Description:
Binary tree where left child < parent < right child.

### Characteristics:
- Ordered structure
- Inorder traversal gives sorted order
- Performance depends on balance

### Time Complexity:
- Search: **O(log n)** average, **O(n)** worst (unbalanced)
- Insertion: **O(log n)** average, **O(n)** worst
- Deletion: **O(log n)** average, **O(n)** worst

### Space Complexity: **O(n)**

### When to Use:
- Need sorted data
- Frequent search operations
- Need range queries

---

## 9. AVL Tree (Self-Balancing BST)

### Description:
Self-balancing BST where heights of left and right subtrees differ by at most 1.

### Characteristics:
- Automatically balances after operations
- Uses rotations to maintain balance
- More strictly balanced than Red-Black trees

### Time Complexity:
- Search: **O(log n)**
- Insertion: **O(log n)**
- Deletion: **O(log n)**

### Space Complexity: **O(n)**

### When to Use:
- Need guaranteed O(log n) operations
- Read-heavy workloads
- Can afford rebalancing overhead

---

## 10. Red-Black Tree

### Description:
Self-balancing BST with colored nodes (red/black) following specific rules.

### Characteristics:
- Less rigidly balanced than AVL
- Faster insertions/deletions
- Used in Java's TreeMap and TreeSet

### Time Complexity:
- Search: **O(log n)**
- Insertion: **O(log n)**
- Deletion: **O(log n)**

### Space Complexity: **O(n)**

### When to Use:
- Need balanced tree with frequent modifications
- Java TreeMap/TreeSet internally use this

---

## 11. Heap (Binary Heap)

### Description:
Complete binary tree where parent is greater (Max Heap) or smaller (Min Heap) than children.

### Types:
1. **Min Heap** - Parent < Children (root is minimum)
2. **Max Heap** - Parent > Children (root is maximum)

### Characteristics:
- Usually implemented as array
- Not a BST
- Used for priority queues

### Time Complexity:
- Insert: **O(log n)**
- Delete Max/Min: **O(log n)**
- Get Max/Min: **O(1)**
- Build Heap: **O(n)**
- Heapify: **O(log n)**

### Space Complexity: **O(n)**

### When to Use:
- Priority Queue implementation
- Heap Sort
- Finding kth largest/smallest element
- Median maintenance

---

## 12. Priority Queue

### Description:
Abstract data type where elements have priorities. Typically implemented using heaps.

### Characteristics:
- Higher priority elements dequeued first
- Not strictly FIFO

### Time Complexity (using binary heap):
- Insert: **O(log n)**
- Remove (highest priority): **O(log n)**
- Peek (highest priority): **O(1)**

### Space Complexity: **O(n)**

### When to Use:
- Dijkstra's algorithm
- Huffman coding
- Task scheduling
- Event-driven simulation

---

## 13. Graph

### Description:
Collection of nodes (vertices) connected by edges.

### Types:
1. **Directed Graph** - Edges have direction
2. **Undirected Graph** - Edges have no direction
3. **Weighted Graph** - Edges have weights
4. **Unweighted Graph** - All edges equal

### Representations:
1. **Adjacency Matrix** - 2D array
   - Space: O(V²)
   - Check edge: O(1)
   - Get all neighbors: O(V)

2. **Adjacency List** - Array of lists
   - Space: O(V + E)
   - Check edge: O(degree)
   - Get all neighbors: O(degree)

### Common Algorithms:
- BFS: **O(V + E)**
- DFS: **O(V + E)**
- Dijkstra's: **O((V + E) log V)** with priority queue

### When to Use:
- Social networks
- Maps and navigation
- Network routing
- Dependency resolution

---

## 14. Trie (Prefix Tree)

### Description:
Tree-like structure for storing strings where each node represents a character.

### Characteristics:
- Each path represents a word
- Shares common prefixes
- Root is empty

### Time Complexity:
- Insert: **O(m)** where m is word length
- Search: **O(m)**
- Delete: **O(m)**
- Prefix search: **O(m)**

### Space Complexity: **O(ALPHABET_SIZE * N * M)**
- Can be space-intensive

### When to Use:
- Autocomplete features
- Spell checkers
- IP routing tables
- Word games

---

## Quick Reference: Time Complexity Comparison

| Data Structure | Access | Search | Insert | Delete | Space |
|---------------|--------|--------|--------|--------|-------|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| ArrayList | O(1) | O(n) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Hash Table | - | O(1)† | O(1)† | O(1)† | O(n) |
| BST | O(log n)† | O(log n)† | O(log n)† | O(log n)† | O(n) |
| AVL Tree | O(log n) | O(log n) | O(log n) | O(log n) | O(n) |
| Heap | - | O(n) | O(log n) | O(log n) | O(n) |
| Trie | - | O(m) | O(m) | O(m) | O(n*m) |

*At head/tail with proper reference
†Average case; worst case may differ

---

## Tips for Choosing Data Structures:

1. **Need fast access by index?** → Array or ArrayList
2. **Frequent insertions/deletions at beginning?** → Linked List
3. **Need LIFO behavior?** → Stack
4. **Need FIFO behavior?** → Queue
5. **Need fast key-value lookup?** → HashMap
6. **Need sorted data with fast operations?** → BST or TreeMap
7. **Need to find min/max quickly?** → Heap or Priority Queue
8. **Need to model relationships?** → Graph
9. **Need prefix-based searching?** → Trie
10. **Need guaranteed O(log n)?** → AVL Tree or Red-Black Tree