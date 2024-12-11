package br.com.studies.moveallzerostoend.approach;

import br.com.studies.moveallzerostoend.PushZerosToEnd;

public class FirstApproach implements PushZerosToEnd {

    @Override
    public void pushZerosToEnd(int[] arr) {

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