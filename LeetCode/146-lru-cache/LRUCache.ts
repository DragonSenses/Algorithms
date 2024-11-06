/**
 * Represents a node in the LRU cache.
 */
class CacheNode {
  key: number; // Key for the cache entry
  val: number; // Value for the cache entry
  next: CacheNode | null; // Pointer to the next node in the linked list
  prev: CacheNode | null; // Pointer to the previous node in the linked list

  /**
   * Constructs a new CacheNode with the specified key and value.
   * @param {number} key - The key for the cache entry.
   * @param {number} val - The value for the cache entry.
   */
  constructor(key: number, val: number) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

/**
 * LRU (Least Recently Used) Cache implemented with a doubly linked list and a Map.
 */
class LRUCache {
  private capacity: number;
  private map: Map<number, CacheNode>;
  private head: CacheNode;
  private tail: CacheNode;

  /**
   * Constructs an LRUCache with the specified capacity.
   * @param {number} capacity - The maximum number of items the cache can hold.
   */
  constructor(capacity: number) {
    this.capacity = capacity;
    this.map = new Map();
    this.head = new CacheNode(0, 0);
    this.tail = new CacheNode(0, 0);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  /**
   * Adds a node to the end of the doubly linked list.
   * @param {CacheNode} node - The node to be added.
   */
  add(node: CacheNode): void {
    const previousEnd = this.tail.prev!;
    previousEnd.next = node;
    node.prev = previousEnd;
    node.next = this.tail;
    this.tail.prev = node;
  }

  /**
   * Removes a node from the doubly linked list.
   * @param {CacheNode} node - The node to be removed.
   */
  remove(node: CacheNode): void {
    node.prev!.next = node.next;
    node.next!.prev = node.prev;
  }

  /**
   * Retrieves the value associated with the specified key.
   * If the key exists, the corresponding node is moved to the end of the doubly linked list.
   * @param {number} key - The key whose associated value is to be returned.
   * @returns {number} The value associated with the key, or -1 if the key does not exist.
   */
  get(key: number): number {
    if (!this.map.has(key)) {
      return -1;
    }

    const node = this.map.get(key)!;
    this.remove(node);
    this.add(node);
    return node.val;
  }

  /**
   * Adds a key-value pair to the cache.
   * If the key already exists, the corresponding node is updated and moved to the end of the doubly linked list.
   * If adding the new key-value pair exceeds the cache's capacity, the least recently used item is removed.
   * @param {number} key - The key with which the specified value is to be associated.
   * @param {number} value - The value to be associated with the specified key.
   */
  put(key: number, value: number): void {
    if (this.map.has(key)) {
      const oldNode = this.map.get(key)!;
      this.remove(oldNode);
    }

    const node = new CacheNode(key, value);
    this.map.set(key, node);
    this.add(node);

    if (this.map.size > this.capacity) {
      const nodeToDelete = this.head.next!;
      this.remove(nodeToDelete);
      this.map.delete(nodeToDelete.key);
    }
  }
}
