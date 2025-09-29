// ============================================================================
// 1. ARRAY - Basic Implementation
// ============================================================================
class ArrayExample {
    public static void demo() {
        // Fixed size array
        int[] arr = new int[5];
        
        // Initialize
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 10;
        }
        
        // Access - O(1)
        System.out.println("Element at index 2: " + arr[2]);
        
        // Search - O(n)
        int target = 30;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found " + target + " at index " + i);
                break;
            }
        }
    }
}

// ============================================================================
// 2. ARRAYLIST - Dynamic Array Implementation
// ============================================================================
import java.util.ArrayList;

class ArrayListExample {
    public static void demo() {
        ArrayList<Integer> list = new ArrayList<>();
        
        // Add - O(1) amortized
        list.add(10);
        list.add(20);
        list.add(30);
        
        // Access - O(1)
        System.out.println("Element at index 1: " + list.get(1));
        
        // Insert at position - O(n)
        list.add(1, 15);
        
        // Remove - O(n)
        list.remove(2);
        
        // Search - O(n)
        System.out.println("Contains 20? " + list.contains(20));
        
        System.out.println("ArrayList: " + list);
    }
}

// ============================================================================
// 3. SINGLY LINKED LIST - From Scratch
// ============================================================================
class SinglyLinkedList {
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Insert at beginning - O(1)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Insert at end - O(n)
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    // Delete from beginning - O(1)
    public void deleteFromHead() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    
    // Search - O(n)
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Display
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public int getSize() {
        return size;
    }
}

// ============================================================================
// 4. DOUBLY LINKED LIST - From Scratch
// ============================================================================
class DoublyLinkedList {
    private class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Insert at beginning - O(1)
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    // Insert at end - O(1)
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    // Delete from head - O(1)
    public void deleteFromHead() {
        if (head == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    // Display forward
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// ============================================================================
// 5. STACK - Array-based Implementation
// ============================================================================
class Stack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }
    
    // Push - O(1)
    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = data;
    }
    
    // Pop - O(1)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }
    
    // Peek - O(1)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public int size() {
        return top + 1;
    }
}

// ============================================================================
// 6. QUEUE - Array-based Circular Queue
// ============================================================================
class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    // Enqueue - O(1)
    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }
    
    // Dequeue - O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }
    
    // Peek - O(1)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int size() {
        return size;
    }
}

// ============================================================================
// 7. HASH TABLE - Simple Implementation with Chaining
// ============================================================================
import java.util.LinkedList;

class HashTable {
    private class Entry {
        String key;
        int value;
        
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<Entry>[] table;
    private int capacity;
    private int size;
    
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    // Put - O(1) average
    public void put(String key, int value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        // Update if key exists
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        // Add new entry
        bucket.add(new Entry(key, value));
        size++;
    }
    
    // Get - O(1) average
    public Integer get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    // Remove - O(1) average
    public void remove(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        Entry toRemove = null;
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        
        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }
    
    public int size() {
        return size;
    }
}

// ============================================================================
// 8. BINARY TREE - Basic Implementation
// ============================================================================
class BinaryTree {
    private class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    // Inorder Traversal: Left -> Root -> Right
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
    
    // Preorder Traversal: Root -> Left -> Right
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    // Postorder Traversal: Left -> Right -> Root
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }
}

// ============================================================================
// 9. BINARY SEARCH TREE (BST) - From Scratch
// ============================================================================
class BinarySearchTree {
    private class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;
    
    public BinarySearchTree() {
        this.root = null;
    }
    
    // Insert - O(log n) average, O(n) worst
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    // Search - O(log n) average, O(n) worst
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        
        if (data == root.data) {
            return true;
        }
        
        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
    
    // Delete - O(log n) average
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return null;
        }
        
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node to be deleted found
            
            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            // Case 3: Two children
            // Find inorder successor (min in right subtree)
            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        
        return root;
    }
    
    private int findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    
    // Inorder traversal (gives sorted order)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}

// ============================================================================
// 10. MIN HEAP - Array-based Implementation
// ============================================================================
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }
    
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    // Insert - O(log n)
    public void insert(int data) {
        if (size == capacity) {
            throw new RuntimeException("Heap is full");
        }
        
        heap[size] = data;
        int current = size;
        size++;
        
        // Heapify up
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    
    // Extract Min - O(log n)
    public int extractMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        heapifyDown(0);
        
        return min;
    }
    
    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }
    
    // Get Min - O(1)
    public int getMin() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }
    
    public int size() {
        return size;
    }
}

// ============================================================================
// 11. GRAPH - Adjacency List Implementation
// ============================================================================
import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;
    
    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    // Add edge - O(1)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        // For undirected graph, add this line:
        // adjList[dest].add(src);
    }
    
    // BFS Traversal - O(V + E)
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);
        
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for (int neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    
    // DFS Traversal - O(V + E)
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS: ");
        DFSUtil(start, visited);
        System.out.println();
    }
    
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
    
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

// ============================================================================
// 12. TRIE (Prefix Tree) - From Scratch
// ============================================================================
class Trie {
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new TrieNode[26]; // For lowercase a-z
            isEndOfWord = false;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    // Insert - O(m) where m is word length
    public void insert(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        
        current.isEndOfWord = true;
    }
    
    // Search - O(m)
    public boolean search(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        
        return current.isEndOfWord;
    }
    
    // Starts with prefix - O(m)
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        
        return true;
    }
    
    // Delete - O(m)
    public void delete(String word) {
        deleteRec(root, word, 0);
    }
    
    private boolean deleteRec(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return hasNoChildren(current);
        }
        
        int charIndex = word.charAt(index) - 'a';
        TrieNode node = current.children[charIndex];
        
        if (node == null) {
            return false;
        }
        
        boolean shouldDeleteNode = deleteRec(node, word, index + 1);
        
        if (shouldDeleteNode) {
            current.children[charIndex] = null;
            return hasNoChildren(current) && !current.isEndOfWord;
        }
        
        return false;
    }
    
    private boolean hasNoChildren(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
}

// ============================================================================
// MAIN CLASS - Demonstration
// ============================================================================
public class DataStructuresDemo {
    public static void main(String[] args) {
        System.out.println("=== DATA STRUCTURES DEMONSTRATIONS ===\n");
        
        // 1. Array
        System.out.println("1. ARRAY:");
        ArrayExample.demo();
        
        // 2. ArrayList
        System.out.println("\n2. ARRAYLIST:");
        ArrayListExample.demo();
        
        // 3. Singly Linked List
        System.out.println("\n3. SINGLY LINKED LIST:");
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtHead(10);
        sll.insertAtHead(20);
        sll.insertAtTail(30);
        sll.display();
        
        // 4. Stack
        System.out.println("\n4. STACK:");
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        
        // 5. Queue
        System.out.println("\n5. QUEUE:");
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeue: " + queue.dequeue());
        
        // 6. Hash Table
        System.out.println("\n6. HASH TABLE:");
        HashTable ht = new HashTable(10);
        ht.put("apple", 100);
        ht.put("banana", 200);
        System.out.println("Get 'apple': " + ht.get("apple"));
        
        // 7. Binary Search Tree
        System.out.println("\n7. BINARY SEARCH TREE:");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        System.out.print("Inorder: ");
        bst.inorder();
        System.out.println("Search 40: " + bst.search(40));
        
        // 8. Min Heap
        System.out.println("\n8. MIN HEAP:");
        MinHeap heap = new MinHeap(10);
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        System.out.println("Min: " + heap.getMin());
        System.out.println("Extract Min: " + heap.extractMin());
        
        // 9. Graph
        System.out.println("\n9. GRAPH:");
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.BFS(0);
        graph.DFS(0);
        
        // 10. Trie
        System.out.println("\n10. TRIE:");
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Starts with 'appl': " + trie.startsWith("appl"));
    }
}