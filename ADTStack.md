# ADT Stack

+createStack() - create an empty stack

+isEmpty() : boolean - determine if the stack is empty

+push(newItem : StackItemType) - adds a new item to the *top* of the stack. May throw an exception if stack is full.

+pop() : StackItemType - retrieve and remove the top item from the stack. Throws an exception if the stack is empty

+popAll() - removes all items from the stack

+peek() : StackItemType - retrieves the item on top of the stack. That is, the item added most recently. This does _not_ change the stack. Throws an exception if the stack is empty.