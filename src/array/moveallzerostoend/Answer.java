package array.moveallzerostoend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Answer {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            //new Solution().pushZerosToEnd(arr);
            new Solution4().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {

        void pushZerosToEnd(int[] arr) {

            Integer position = null;

            for (int i = 0; i < arr.length; i++) {

                int currentValue = arr[i];

                if (currentValue == 0 && position == null) {

                    position = i;

                }

                else if (position != null && arr[i] > 0) {
                    arr[i] =  0; // arr[position] == 0
                    arr[position] = currentValue;
                    // Get actual position to change and increase 1, because if I get iterator position
                    // is possible to lose a sequence of zeros.
                    position += 1;
                }

            }

        }

    }

    static class Solution2 {

        void pushZerosToEnd(int[] arr) {

            int length = arr.length;

            List<Integer> list = Arrays.stream(arr).boxed()
                .filter(value -> value > 0)
                .toList();

            for (int i = 0; i < length; i++) {
                if (i < list.size()) {
                    arr[i] = list.get(i);
                } else {
                    arr[i] = 0;
                }
            }

        }

    }

    static class Solution3 {

        void pushZerosToEnd(int[] arr) {

            Integer zeroPosition = null;

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == 0 && zeroPosition == null) {

                    zeroPosition = i;

                } else if (arr[i] > 0 && zeroPosition != null) {

                    arr[zeroPosition] = arr[i];
                    arr[i] = 0;
                    zeroPosition += 1;

                }

            }

        }

    }

    static class Solution4 {

        void pushZerosToEnd(int[] arr) {

            int nonZeroIndex = 0;

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] != 0) {

                    int temp = arr[i];
                    arr[i] = arr[nonZeroIndex];
                    arr[nonZeroIndex] = temp;
                    nonZeroIndex += 1;

                }

            }

        }

    }



}
