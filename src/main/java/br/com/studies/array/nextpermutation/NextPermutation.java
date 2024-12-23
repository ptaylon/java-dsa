package br.com.studies.array.nextpermutation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        //int[] arr = {2, 4, 1, 7, 5, 0};
        int[] arr = {1,2,3,6,5,4};

        int pivot = findPivotPosition(arr);

        if (pivot >= 0) {

            int newPositionPoint = getClosestNumberInRelationToPivot(pivot, arr);

            // Shift value between pivot and newPosition point.
            shift(arr, pivot, newPositionPoint);

            // after change nextToNumberPivotPosition, I need to ignore the first
            // nextToNumberPivotPosition and organize the rest in ascendant mode.
            reverseSubArray(arr, pivot + 1, arr.length - 1);

        } else {

            Arrays.sort(arr);

        }

    }

    private static void reverseSubArray(int[] arr, int start, int end) {

        while (start < end) {

            shift(arr, start, end);
            start++;
            end--;

        }

    }

    private static void shift(int[] arr, int i, int j) {

        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;

    }

    private static int getClosestNumberInRelationToPivot(int pivot, int[] arr) {

        int newPositionPoint = -1;
        int difference = Integer.MAX_VALUE;

        for (int i = pivot + 1; i < arr.length; i++) {

            int diff = arr[i] - arr[pivot];
            if (diff > 0 && diff < difference) {
                difference = diff;
                newPositionPoint = i;
            }

        }

        return newPositionPoint;

    }

    private static int findPivotPosition(int[] arr) {

        int pivot = -1;

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                pivot = i - 1;
                break;
            }
        }

        return pivot;

    }

}