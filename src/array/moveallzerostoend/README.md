# Move all zero's to right

Given an array arr[]. Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. Do the mentioned change in the array in place.

Examples:

```
Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.
```

```
Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: No change in array as there are no 0s.
```

```
Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: No change in array as there are all 0s.
```

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105

=====================================================================

## Answer

**Simulation Table** — Shows the values of `position`, `currentValue`, and the array `arr` at each iteration.  

---

### **Input Array Example**
We will use:
```java
int[] arr = {1, 0, 2, 0, 3, 0, 4};
```

---

### **1️⃣ Simulation Table**
| **Step** | **i** | **arr[i]** | **position** | **Condition**                  | **Action**                        | **Updated Array**        |
|---------|------|------------|--------------|---------------------------------|-----------------------------------|--------------------------|
| **Start** | --  | --         | `null`       | --                              | Initial state                     | `[1, 0, 2, 0, 3, 0, 4]`   |
| **1**    | 0    | 1          | `null`       | `arr[i] != 0`                   | No action                         | `[1, 0, 2, 0, 3, 0, 4]`   |
| **2**    | 1    | 0          | 1            | `arr[i] == 0`                   | Set `position = 1`                | `[1, 0, 2, 0, 3, 0, 4]`   |
| **3**    | 2    | 2          | 1            | `arr[i] > 0 && position != null`| Swap `arr[1]` and `arr[2]`        | `[1, 2, 0, 0, 3, 0, 4]`   |
| **4**    | 3    | 0          | 2            | `arr[i] == 0`                   | No action                         | `[1, 2, 0, 0, 3, 0, 4]`   |
| **5**    | 4    | 3          | 2            | `arr[i] > 0 && position != null`| Swap `arr[2]` and `arr[4]`        | `[1, 2, 3, 0, 0, 0, 4]`   |
| **6**    | 5    | 0          | 3            | `arr[i] == 0`                   | No action                         | `[1, 2, 3, 0, 0, 0, 4]`   |
| **7**    | 6    | 4          | 3            | `arr[i] > 0 && position != null`| Swap `arr[3]` and `arr[6]`        | `[1, 2, 3, 4, 0, 0, 0]`   |

**Final Array:**  
`[1, 2, 3, 4, 0, 0, 0]` — All zeros have been moved to the end. 🎉

---

### ** Explaining the algorithm**

1. **Start** — The algorithm begins with an array input.
2. **Loop through the array** — It iterates from `i = 0` to `i = n-1`.
3. **Check if `arr[i] == 0` and `position == null`** — If true, it sets `position` to `i`.
4. **Check if `position != null` and `arr[i] > 0`** — If true, it swaps `arr[i]` with `arr[position]` and increments `position`.
5. **Continue to the next iteration** — The loop continues until the end of the array.
6. **End** — All zeros are moved to the end of the array.