# Java Data Structures
This is a small library of Java data structures that includes the following data structures:

## Data Structures
<details>
<summary>Trees</summary>

### ``BinarySearchTree<E>``
This is a concrete implementation of the ``AbstractBinaryTree`` class that represents a binary tree
data structure that stores elements of type ``E`` in sorted order. To be stored in the ``BinarySearchTree``,
the elements must implement the ``Comparable`` interface. The type of elements stored in the BinarySearchTree
is denoted by ``<E>``.

### ``BinaryTree<E>``
This is a concrete implementation of the ``AbstractBinaryTree`` class that represents a binary tree
data structure with elements of type ``E``. The type of elements stored in the ``BinaryTree`` is denoted by ``<E>``.

### ``Heaps<T>``
The Heap data structure is a tree where the elements ``E``  are sorted in a particular order,
with the help of the ``Comparable`` interface.

#### ``Max-Heap<T>``
The elements are sorted by the maximum value as root,
making it suitable for applications that require retrieving the maximum element quickly.

#### ``Min-Heap<T>``
The elements are sorted by the minimum value as root,
making it suitable for applications that require retrieving the minimum element quickly.

</details>

### ``Array<E>``
This is an array implementation in Java with a fixed size. 
The type of elements stored in the array is denoted by ``<E>``. 
It provides constant-time access to elements, making it a suitable choice when the 
size of the collection is known in advance.

### ``LinkedList<E>``
This represents a linked list data structure that stores elements of type ``E``. 
The type of elements stored in the ``LinkedList`` is denoted by ``<E>``.
It provides constant-time insertion and deletion operations at the beginning and end of the list.

### ``Pair<K, V>``
This is a generic class that represents a pair of two values, one of type ``K`` and the other of type ``V``. 
The type of the left-side value in the pair is denoted by ``<K>``, 
and the type of the right-side value in the pair is denoted by ``<V>``.

### ``Queue<E>``
This represents a First-In-First-Out (FIFO) queue data structure that stores elements of type ``E``. 
The type of elements stored in the ``Queue`` is denoted by ``<E>``. 
It supports adding elements to the end of the queue and removing elements from the 
front of the queue in constant time.

### ``Stack<E>``
This represents a Last-In-First-Out (LIFO) stack data structure that stores elements of type ``E``. 
The type of elements stored in the ``Stack`` is denoted by ``<E>``. 
It supports adding elements to the top of the stack and removing elements 
from the top of the stack in constant time.

### ``Vector<E>``
This represents a generic ``Array`` that stores elements of type ``E``, 
is thread-safe and automatically resizes itself when it is out of space. 
The type of elements stored in the ``Vector`` is represented by ``<E>``. 
It provides constant-time access to elements and is useful in situations where the size 
of the collection needs to be dynamically adjusted.