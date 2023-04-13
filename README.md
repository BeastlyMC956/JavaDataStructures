# Java Data Structures
This is a small library of Java data structures that includes the following data structures:

## Data Structures

### ``Array<E>``
This is an array implementation in Java with a fixed size.
The type of elements stored in the array is denoted by ``<E>``.

### ``BinarySearchTree<E>``
This is a concrete implementation of the ``AbstractBinaryTree`` class that represents a binary tree 
data structure that stores elements of type ``E`` in sorted order. To be stored in the ``BinarySearchTree``, 
the elements must implement the ``Comparable`` interface. The type of elements stored in the BinarySearchTree 
is denoted by ``<E>``.

### ``BinaryTree<E>``
This is a concrete implementation of the ``AbstractBinaryTree`` class that represents a binary tree 
data structure with elements of type ``E``. The type of elements stored in the ``BinaryTree`` is denoted by ``<E>``.

### ``LinkedList<E>``
This represents a linked list data structure that stores elements of type ``E``. 
The type of elements stored in the ``LinkedList`` is denoted by ``<E>``.

### ``Pair<K, V>``
This is a generic class that represents a pair of two values, one of type ``K`` and the other of type ``V``. 
The type of the left-side value in the pair is denoted by ``<K>``, 
and the type of the right-side value in the pair is denoted by ``<V>``.

### ``Queue<E>``
This represents a First-In-First-Out (FIFO) queue data structure that stores elements of type ``E``. 
The type of elements stored in the ``Queue`` is denoted by ``<E>``.

### ``Stack<E>``
This represents a Last-In-First-Out (LIFO) stack data structure that stores elements of type ``E``. 
The type of elements stored in the ``Stack`` is denoted by ``<E>``.

### ``Vector<E>``
This represents a generic ``Array`` that stores elements of type ``E``, is thread safe and 
automatically resizes itself when it is out of space. 
The type of elements stored in the ``Vector`` is represented by ``<E>``