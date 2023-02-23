# ADT Queue

+createQueue() - constructs an empty queue

+isEmpty(): boolean - determines if the queue is empty

+enqueue(newItem : QueueItemType) - add the new item to the end of the queue. Throws an exception if the queue is full.

+dequeue() : QueueItemType - retrieve and remove the item at the front of the queue. Throws an exception when the queue is empty.

+dequeueAll() : removes all items from the queue

+peek() : QueueItemType - retrieves the item at the front of the queue. Note: the item is not removed. Throws an exception when the queue is empty.