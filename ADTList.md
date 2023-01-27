# ADT List
| ArrayBasedList |
|:---------------|
|-items : Objects[] |
|-numItems : integer |
|:---------------|
|+isEmpty() : boolean|
|+getSize() : integer|
|+add(index: integer, item: Object)|

+createList() - creates an empty list (constructor)

+isEmpty(): boolean - determines whether the list is empty

+getSize(): integer - returns the number of items that are in the list

+add(index: integer, item: ListItemType) 

Inserts the given item at position given by the index. A precondition is that the index is >= 0 and <= getSize(). If the index is < getSize() then the time at index moves to index +1 , the item at index + 1 moves to index + 2, and so on. Note: throw an exception if index is out of range or if the list is full. 

+remove(index : integer) 

Removes the item at the position given by the index. A precondition is that the index is >= 0 and < getSize(). If the index < getSize() - 1, then items must be shifted as follows: the item at index+1 moves to index, the item at index+2 moves to index + 1, and so on.  Note: throw an exception if index is out of range or if the list is full. 

+removeAll() - removes all the items in the list

+get(index: integer) : ListItemType

This returns the item at position index of the list. A precondition is that the index is >= 0 and < getSize(). Note: throw an exception if index is out of range or if the list is full. 
