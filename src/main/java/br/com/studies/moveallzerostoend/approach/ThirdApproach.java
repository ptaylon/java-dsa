package br.com.studies.moveallzerostoend.approach;

import br.com.studies.moveallzerostoend.PushZerosToEnd;

public class ThirdApproach implements PushZerosToEnd {

    @Override
    public void pushZerosToEnd(int[] arr) {

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
