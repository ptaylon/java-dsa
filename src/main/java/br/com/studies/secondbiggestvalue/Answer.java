package br.com.studies.secondbiggestvalue;//{ Driver Code Starts

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Answer {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            Solution3 ob2 = new Solution3();
            int ans2 = ob2.getSecondLargest(arr);
            System.out.println(ans2);

            System.out.println("~");
        }

    }

    static class Solution {

        // My submitted solution
        public int getSecondLargest(int[] arr) {

            if (arr.length < 1)
                return -1;

            int biggestValue = -1;
            int secondBiggestValue = -1;

            if (arr[0] > arr[1]) {
                biggestValue = arr[0];
                secondBiggestValue = arr[1];
            } else {
                biggestValue = arr[1];
                secondBiggestValue = arr[0];
            }

            for (int i = 2; i < arr.length; i++) {

                int current = arr[i];

                if (current > biggestValue) {

                    secondBiggestValue = biggestValue;
                    biggestValue = current;

                } else if (current > secondBiggestValue && current != biggestValue) {
                    secondBiggestValue = current;
                }


            }

            return biggestValue == secondBiggestValue ? -1 : secondBiggestValue;

        }

    }

    static class Solution2 {

        // Other solution using streams, but it isn't have good performance comparing to previous
        public int getSecondLargest(int[] arr) {

            List<Integer> answer = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .toList();

            return answer.get(0).equals(answer.get(1)) ? -1 : answer.get(1);

        }

    }

    static class Solution3 {

        // Better approach and performance
        public int getSecondLargest(int[] arr) {

            int biggest = 0;
            int secondBiggest = 0;

            for (int i = 0; i < arr.length; i++) {

                if (biggest <= arr[i]) {
                    secondBiggest = biggest;
                    biggest = arr[i];
                } else if (secondBiggest < arr[i]) {
                    secondBiggest = arr[i];
                }

            }

            return biggest == secondBiggest ? -1 : secondBiggest;

        }

    }

}