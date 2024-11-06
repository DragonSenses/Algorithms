# 146. LRU Cache

<p>Design a data structure that follows the constraints of a <strong><a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a></strong>.</p>

<p>Implement the <code>LRUCache</code> class:</p>

<ul>
  <li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <strong>positive</strong> size <code>capacity</code>.</li>
  <li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li>
  <li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li>
</ul>

<p>The functions <code>get</code> and <code>put</code> must each run in <code>O(1)</code> average time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>Output</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>Explanation</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= capacity &lt;= 3000</code></li>
  <li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li>
  <li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
  <li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li>
</ul>

<br>

---

# Solution

Preferred Solution:
- [Custom Data Structure: Doubly Linked List](#custom-data-structure-doubly-linked-list)
  - **Time Complexity**: `O(1)` for both `get` and `put`
  
- [Built-In Data Structure](#built-in-data-structures)
  - **Time Complexity**: `O(1)` for both `get` and `put`

## **Overview of LRU Cache**

An LRU (Least Recently Used) cache is a type of data structure that removes the least recently used item when the cache reaches its capacity. It keeps track of the order in which keys are accessed to ensure that the least recently used item is the first to be evicted when a new item is added. The typical operations are:
- **get(key)**: Fetch the value associated with the key.
- **put(key, value)**: Add or update the key-value pair in the cache.

To implement an LRU cache efficiently, data structures such as a hash map (for `O(1)` access time) and a doubly linked list (to keep track of the order of usage) are often used.

## **Implementing an LRU Cache**

Let's start by thinking about how we can implement the data structure without caring about time complexity.

### Key Concepts

#### Key-Value Storage

The description of the `put` method states that we are storing key-value pairs. This means the data structure is similar to a hash map, which also stores key-value pairs. It's easy enough to add new key-value pairs or update existing ones using a hash map. 

#### Capacity Limitation

The challenge arises because the hash map is limited to a size of `capacity`. When the hash map exceeds this capacity, we cannot arbitrarily remove a key - we need to remove the least recently used one. After we remove it, we need to know what the second least recently used one was (as it will be the next one to be deleted).

#### Maintaining Usage Order

To keep track of the order in which keys have been used, we can implement a queue. The key at the front of the queue is the least recently used key, and the key at the back of the queue is the most recently used key.

#### Operations on the Queue

- **Insertion**: When we insert a key for the first time, we put it at the back of the queue.
- **Access**: When we use an existing key (with either `get` or `put`), we locate it in the queue and move it to the back.
- **Eviction**: If the data structure exceeds capacity, we can reference the front of the queue to find the key that should be deleted.

#### Efficiency Considerations

If we use an array/list to implement the queue, operations will cost `O(n)`. This is because we will frequently be removing elements from arbitrary positions in the list, which costs `O(n)`.

#### Optimization

We need a way to implement this queue such that the operations will run in `O(1)`.

To achieve `O(1)` operations, we can use a combination of:

1. **Hash Map**: For storing the key-value pairs and providing `O(1)` access to keys.
2. **Doubly Linked List**: To maintain the order of usage and enable `O(1)` insertion, deletion, and update operations.

By using these data structures, we can ensure that both the `get` and `put` methods run in `O(1)` average time complexity.

# Built-In Data Structures

The major programming languages have built-in data structures that make this problem much easier. This approach is included for the sake of completeness.

## **Intuition**

Many programming languages offer built-in data structures that simplify the implementation of an LRU cache. These built-in structures can handle most of the heavy lifting, making the solution more straightforward.

### **Interview Note**

**Warning**: Using these built-in data structures might defeat the purpose of the problem. If you are asked this problem in an interview, the interviewer likely wants to see you implement the LRU cache from scratch. It is recommended to ask the interviewer before using built-in data structures.

### Using Built-In Data Structures

#### Key Points

- **Built-In Efficiency**: Built-in data structures are optimized and tested for efficiency and reliability.
- **Simplified Implementation**: Using built-in structures can significantly reduce the complexity of your code.

#### Examples

- **Java**: The `LinkedHashMap` class.
- **C++**: The `std::list` class.
- **Python**: The `OrderedDict` class from the `collections` module.

- In **Java**, we will be using [LinkedHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html), which is a hash map that maintains insertion order. It essentially implements the linked list for us in the same data structure as the hash map, with the add and remove methods built into the hash map operations.

- In **C++**, we will be using [std::list](https://en.cppreference.com/w/cpp/container/list), which implements the doubly linked list.

- In **Python**, we will be using [collections.OrderedDict](https://docs.python.org/3/library/collections.html#collections.OrderedDict). This is similar to the Java data structure - it is a hash map that maintains insertion order.

Using these built-in data structures, you can quickly create an LRU cache with minimal effort, but always be mindful of the context in which you're applying this approach.

## **Algorithm**

The only difference between using built-in data structures and implementing our own data structure is that much of the code we needed to implement the linked list logic is now done automatically for us by the built-in data structure we are using.

Here are the steps:

1. **Adding a Node to the Back of the Linked List**
2. **Removing a Node from the Linked List**
3. **The `get(int key)` Method**
4. **The `put(int key, int value)` Method**

## **Implementation**

### Java

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(1)` for both `get` and `put`

### **Space Complexity**: `O(capacity)`

# Custom Data Structure: Doubly Linked List

## **Intuition**

We need a way to store data in an ordered manner such that elements can be removed from any position in constant time.

A linked list is a great candidate for this task. Removing from arbitrary positions is one of the few things that a linked list does better than an array.

For example, in a linked list `A -> B -> C -> D -> E`, we can remove `C` from the list by performing `B.next = D`. As `C` is no longer reachable, it is effectively "removed" from the list. If you were to traverse from the head (`A`), you would visit nodes `A`, `B`, `D`, `E`. This operation is done in constant time, no matter how large the list is.

To remove `C` from the list, we needed a reference to the node before it (`B`), so that we could change `B.next`. Therefore, we shall use a doubly linked list. This way, when we want to remove a node, we have a `prev` pointer to reference the node before it.

```java
public class Node {
  int key;
  int val;
  Node next;
  Node prev;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}
```

**Note**: We use `Node` to avoid confusion with the online judge environment, which may already have a `ListNode` class defined.

As each node represents an element in the data structure, we can also store the key-value pair in each node.

### **Functionality**

We need to achieve the following functionality:
1. Store a key-value pair
2. Update a key-value pair
3. Given a key, determine if it exists in the data structure. If it does, return the value. If it doesn't, return -1.
4. When a new key-value pair is added, create a new linked list node and put it at the back.
5. When an existing key is updated or fetched, find its associated linked list node. Move it to the back.
6. When a new key-value pair is added and the size of the data structure exceeds capacity, remove the linked list node at the front.

Tasks 4 - 6 follow the process determined in the overview.

Tasks 1, 2, and 3 can be easily achieved using a standard built-in hash map. But how do we accomplish tasks 4, 5, and 6?

## **Implementation Plan**

### Adding Nodes to the Back

In tasks 4 and 5, we need to add nodes to the back of the linked list. Because we are aiming for an `O(1)` time complexity, we must keep a reference to the tail of our linked list. 

### Removing Nodes from the Front

In task 6, we need to remove from the front of the linked list. This means we must also keep a reference to the head (although we would probably do this anyways since you always want to keep the head of a linked list).

We can easily detect when the size of the data structure exceeds capacity by checking the size of our hash map.

### Moving Nodes to the Back

When an existing key is updated or fetched, we need to find its associated linked list node and move it to the back. This requires a reference to the node. By mapping each key to its associated node in the hash map (`int: Node`), we can achieve this in `O(1)` time.

### Using Sentinel Nodes

To handle edge cases, we use sentinel nodes. We set our head and tail attributes to dummy nodes. The "real" head will be `head.next` and the "real" tail will be `tail.prev`. These dummy nodes prevent `head` or `tail` from being null. Initialize `head.next = tail` and `tail.prev = head`.

## **Attributes**

For our `LRUCache` class, we need the following attributes:
1. `capacity` - to detect when we need to start deleting key-value pairs.
2. `map` - our hash map that maps keys to nodes.
3. `head` - the head of our linked list.
4. `tail` - the tail of our linked list.

## **Edge Cases**

If the linked list is empty and we call `put` to create a new key-value pair, we create a node for this pair and set it as both the head and tail. Handling scenarios where capacity is 1 or the list is empty is simplified using sentinel nodes.

We now have everything we need! Let's implement some methods.

## **Algorithm**

### Adding a Node to the Back of the Linked List

To add a node to the end of our linked list whenever we add a new key or update an existing one, we can write a helper method `add(Node node)`:

**Steps:**

1. Get the current node at the end of the linked list, `tail.prev`, and call it `previousEnd`.
2. Insert `node` after `previousEnd` by setting `previousEnd.next = node`.
3. Set `node.prev = previousEnd`.
4. Set `node.next = tail`, as the "real" tail is before `tail`.
5. Update `tail.prev = node`.

This method ensures that the new node is added to the end of the linked list efficiently.

```java
public void add(Node node) {
   Node previousEnd = tail.prev;
   previousEnd.next = node;
   node.prev = previousEnd;
   node.next = tail;
   tail.prev = node;
}
```

### Removing a node from the linked list

We need to perform removals when we update/fetch an existing key, or when the data structure exceeds capacity. Let's write a helper method `remove(Node node)` that removes `node` from the linked list.

**Steps:**

1. Let's call `nextNode = node.next` and `prevNode = node.prev`. Currently, `nextNode.prev = node` and `prevNode.next = node`. To remove `node` from the linked list, we need to reassign `nextNode.prev = prevNode` and `prevNode.next = nextNode`.
2. We can perform both these reassignments without needing to declare `prevNode` or `nextNode` using the following code:

    ```java
    node.prev.next = node.next;
    node.next.prev = node.prev;
    ```

**Example:**

Imagine you have `A <-> B <-> C`. To remove `B`, we need `A` and `C` to become adjacent, i.e. `A <-> C`. Here, `prevNode = A` and `nextNode = C`.

```java
public void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
}
```

### The `get(int key)` Method

Now that we have helper methods for adding and removing from our linked list, we can easily implement the `get` method using simple logic:

1. **Check Key in Hash Map**: Check if the key exists in the hash map. If not, return `-1`.
2. **Get Node from Hash Map**: Retrieve the node associated with the key from the hash map.
3. **Move Node to Back**: Move it to the back of the linked list by first calling `remove(node)` and then `add(node)`.
4. **Return Value**: Return the value associated with the key, which is `node.val`.

```java
public int get(int key) {
    if (!map.containsKey(key)) {
        return -1;
    }

    Node node = map.get(key);
    remove(node);
    add(node);
    return node.val;
}
```

This `get(int key)` method retrieves the value associated with the key, updates the node's position to the back of the doubly linked list, and ensures the node's recent usage is recorded.

