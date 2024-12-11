package br.com.studies.moveallzerostoend.approach;

import br.com.studies.moveallzerostoend.PushZerosToEnd;

import java.util.Arrays;
import java.util.List;

public class SecondApproach implements PushZerosToEnd {

    @Override
    public void pushZerosToEnd(int[] arr) {

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