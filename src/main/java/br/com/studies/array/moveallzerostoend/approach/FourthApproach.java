package br.com.studies.array.moveallzerostoend.approach;

import br.com.studies.array.moveallzerostoend.PushZerosToEnd;

public class FourthApproach implements PushZerosToEnd {

    @Override
    public void pushZerosToEnd(int[] arr) {

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