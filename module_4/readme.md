# Module 4: LinkedList Traversal Performance Test

## Overview
This module tests the performance difference between traversing a `LinkedList` using an iterator versus using the `get(index)` method. The test was conducted with two list sizes: 50,000 and 500,000 integers.

## Test Results

### 50,000 Elements
- **Iterator traversal time**: 1,134,300 ns (approximately 1.13 ms)
- **get(index) traversal time**: 825,302,400 ns (approximately 825 ms)

### 500,000 Elements
- **Iterator traversal time**: 2,674,400 ns (approximately 2.67 ms)
- **get(index) traversal time**: 92,356,573,900 ns (approximately 92.36 seconds)

## Analysis

### Time Complexity
- **Iterator traversal**: O(n) - The iterator maintains a reference to the current node and moves to the next node in constant time.
- **get(index) method**: O(n²) in the worst case for traversal - Each `get(index)` call starts from the head of the list and traverses to the specified index, making it O(n) per call. When traversing the entire list, this becomes O(n²).

### Performance Difference
The results clearly demonstrate the significant performance impact of using `get(index)` for traversal:

- For 50,000 elements: Iterator is approximately 728 times faster than `get(index)`
- For 500,000 elements: Iterator is approximately 34,500 times faster than `get(index)`

The difference becomes more pronounced with larger list sizes because the `get(index)` approach performs increasingly more work as the list grows, while the iterator approach scales linearly.

### Recommendations
- Always use iterators for traversing `LinkedList` collections
- Avoid using `get(index)` in loops when possible
- Consider using `ArrayList` if random access is frequently needed, as it provides O(1) `get(index)` operations

## Unit Tests

The `TestLinkedListTraversal` class has been refactored to follow Object-Oriented Programming principles and includes comprehensive unit tests in `UnitTestLinkedListTraversal.java`. The unit tests cover all methods in the class:

- **testConstructor()**: Verifies that the constructor properly initializes the `LinkedList` instance.
- **testPopulateList()**: Tests the `populateList(int size)` method to ensure it correctly populates the list with sequential integers.
- **testTimeIteratorTraversal()**: Validates that `timeIteratorTraversal()` returns a positive time measurement for iterator-based traversal.
- **testTimeGetTraversal()**: Validates that `timeGetTraversal()` returns a positive time measurement for `get(index)`-based traversal.
- **testWriteResults()**: Tests the `writeResults()` method by writing to a temporary file and verifying the correct output format.
- **testRunTests()**: Ensures the `runTests()` method executes without errors and performs the full test suite.

The unit tests use Java reflection to access private methods and fields, allowing for thorough testing of encapsulated functionality.