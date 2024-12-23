package br.com.studies.array.reversearray;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Approach implements ReverseArray {

    @Override
    public <T> T[] reverseArray(final T[] arr) {

        // or Collections.reverse(arr);

        for (int i = 0; i < arr.length / 2; i++) {

            T aux = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = aux;

        }

        return arr;

    }

    public static void main(String[] args) {

        int[] initialArray = {1,2,3,4,5,6,7};
        Approach approach = new Approach();

        Integer[] response = approach.reverseArray(
            Arrays.stream(initialArray).boxed().toArray(Integer[]::new)
        );

        System.out.println(
            "Initial array: " +
                Arrays.stream(initialArray).boxed().map(Object::toString).collect(Collectors.joining(",")));
        System.out.println(
            "Reversed array: " +
                Arrays.stream(response).map(Object::toString).collect(Collectors.joining(",")));

        String stringTest = "Hello World!";

        Character[] wordArray = stringTest.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] reversedSetence = approach.reverseArray(wordArray);

        System.out.println(stringTest);
        System.out.println(Arrays.stream(reversedSetence).map(String::valueOf).collect(Collectors.joining("")));

    }

}