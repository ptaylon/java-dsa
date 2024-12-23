package br.com.studies.array.rotatearray;

// Complexity Space: O(n)
// Complexity Running: O(n)
// Best Case: O(1)

public class RotateArrayImpl implements RotateArray {

    @Override
    public void rotateArr(int[] arr, int d) {

        int n = arr.length;
        int movements = d % n;
        if (movements == 0) return;

        int[] rotationArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rotationArray[mapPosition(arr.length, i, d)] = arr[i];
        }

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = rotationArray[i];
//        }

        System.arraycopy(rotationArray, 0, arr,0, arr.length);

    }

    static int mapPosition(int length, int i, int d) {

        // Get the rest if d is greater than array length,
        // this is necessary to ignore multiple unnecessary operations
        int movements = d >= length ? d % length : d;

        int position = i - movements;
        if (position < 0) {
            position = position + length;
        }

        return position;

    }

}
