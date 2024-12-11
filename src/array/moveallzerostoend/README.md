
# Move all zero's to right

1️⃣ **Simulation Table** — Shows the values of `position`, `currentValue`, and the array `arr` at each iteration.  
2️⃣ **Visual Diagram** — A flowchart illustrating the logic of the algorithm.

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

### **2️⃣ Explaining the algorithm**
The image above illustrates the logic of the **pushZerosToEnd** algorithm step-by-step using a flowchart. Here's a quick breakdown of the key elements:

1. **Start** — The algorithm begins with an array input.
2. **Loop through the array** — It iterates from `i = 0` to `i = n-1`.
3. **Check if `arr[i] == 0` and `position == null`** — If true, it sets `position` to `i`.
4. **Check if `position != null` and `arr[i] > 0`** — If true, it swaps `arr[i]` with `arr[position]` and increments `position`.
5. **Continue to the next iteration** — The loop continues until the end of the array.
6. **End** — All zeros are moved to the end of the array.