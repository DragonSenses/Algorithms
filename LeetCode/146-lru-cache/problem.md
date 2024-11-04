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

