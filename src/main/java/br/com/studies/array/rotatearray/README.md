# Rotate Array

Given an array `arr[]`. Rotate the array to the left (counter-clockwise direction) by `d` steps, where `d` is a positive integer. Do the mentioned change in the array in place.

**Note:** Consider the array as circular.

## Examples

### Example 1
- **Input:** `arr[] = [1, 2, 3, 4, 5]`, `d = 2`
- **Output:** `[3, 4, 5, 1, 2]`
- **Explanation:** When rotated by 2 elements, it becomes `3 4 5 1 2`.

### Example 2
- **Input:** `arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]`, `d = 3`
- **Output:** `[8, 10, 12, 14, 16, 18, 20, 2, 4, 6]`
- **Explanation:** When rotated by 3 elements, it becomes `8 10 12 14 16 18 20 2 4 6`.

### Example 3
- **Input:** `arr[] = [7, 3, 9, 1]`, `d = 9`
- **Output:** `[3, 9, 1, 7]`
- **Explanation:** When we rotate 9 times, we'll get `3 9 1 7` as the resultant array.

## Constraints
1 <= arr.size(), d <= 105 
0 <= arr[i] <= 105


References: 

https://www.geeksforgeeks.org/complete-guide-on-array-rotations/
https://www.geeksforgeeks.org/array-rotation/