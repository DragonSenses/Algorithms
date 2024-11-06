class CacheNode {
  key: number; // Key for the cache entry
  val: number; // Value for the cache entry
  next: CacheNode | null; // Pointer to the next node in the linked list
  prev: CacheNode | null; // Pointer to the previous node in the linked list

  constructor(key: number, val: number) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

class LRUCache {
  private capacity: number;
  private map: Map<number, CacheNode>;
  private head: CacheNode;
  private tail: CacheNode;

  constructor(capacity: number) {
    this.capacity = capacity;
    this.map = new Map();
    this.head = new CacheNode(0, 0);
    this.tail = new CacheNode(0, 0);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  add(node: CacheNode): void {
    const previousEnd = this.tail.prev!;
    previousEnd.next = node;
    node.prev = previousEnd;
    node.next = this.tail;
    this.tail.prev = node;
  }

  remove(node: CacheNode): void {
    node.prev!.next = node.next;
    node.next!.prev = node.prev;
  }

  get(key: number): number {
    if (!this.map.has(key)) {
      return -1;
    }

    const node = this.map.get(key)!;
    this.remove(node);
    this.add(node);
    return node.val;
  }

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

/**
* Your LRUCache object will be instantiated and called as such:
* var obj = new LRUCache(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/