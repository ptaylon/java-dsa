# Majority element

### You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes. If there's not a majority vote, return an empty array.

**Note:** The answer should be returned in an increasing format.

**Examples:**

- **Input:** `arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]`
    - **Output:** `[5, 6]`
    - **Explanation:** 5 and 6 occur more than `n/3` times.

- **Input:** `arr[] = [1, 2, 3, 4, 5]`
    - **Output:** `[]`
    - **Explanation:** No candidate occurs more than `n/3` times.

**Constraint:**
- `1 <= arr.size() <= 10^6`
- `-10^9 <= arr[i] <= 10^9`

==========================================================

### Boyer-Moore’s Voting Algorithm - O(n) Time and O(1) Space

The idea is based on the observation that there can be at most two majority elements, which appear more than `n/3` times. So we can use Boyer-Moore’s Voting algorithm. As we iterate the array, we identify potential majority elements by keeping track of two candidates and their respective counts.

**Steps:**

1. Initialize two variables `ele1 = -1` and `ele2 = -1` for candidates and two variables `cnt1 = 0` and `cnt2 = 0` for counting.
2. In each iteration:
  - If an element is equal to any candidate, update that candidate's count.
  - If the count of a candidate reaches zero, then replace that candidate with the current element.
  - If neither candidate matches and both counts are non-zero, decrement the counts.
3. After this, in a second pass, check if the chosen candidates appear more than `n/3` times in the array. If they do, then include them in the result array.

